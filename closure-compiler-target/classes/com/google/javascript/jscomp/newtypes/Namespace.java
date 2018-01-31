/*
 * Copyright 2014 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp.newtypes;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.javascript.jscomp.newtypes.RawNominalType.PropAccess;
import com.google.javascript.rhino.Node;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * An object whose properties can be types (nominal types, enums, typedefs).
 * Constructor/interface functions, enums and object literals can be namespaces.
 *
 * @author blickly@google.com (Ben Lickly)
 * @author dimvar@google.com (Dimitris Vardoulakis)
 */
public abstract class Namespace implements Serializable {
  private Map<String, Namespace> namespaces = ImmutableMap.of();
  private Map<String, Typedef> typedefs = ImmutableMap.of();
  // "Simple type" properties (i.e. represented as JSTypes rather than something
  // more specific).
  protected PersistentMap<String, Property> otherProps = PersistentMap.create();
  protected final String name;
  protected final JSTypes commonTypes;
  // Represents the namespace as an ObjectType wrapped in a JSType.
  // The namespace field of the ObjectType contains the namespace instance.
  // In addition,
  // For a function/constructor namespace, the fn field is the function type.
  // For window as namespace, the nominalType field is Window.
  protected JSType namespaceType;
  // Used to detect recursion when computing the type of circular namespaces.
  private boolean duringComputeJSType = false;
  // The node that defines this namespace.
  protected final Node defSite;

  protected Namespace(JSTypes commonTypes, String name, Node defSite) {
    this.name = name;
    this.commonTypes = commonTypes;
    this.defSite = checkNotNull(defSite);
  }

  protected abstract JSType computeJSType();

  public final String getName() {
    return name;
  }

  public Node getDefSite() {
    return this.defSite;
  }

  private boolean isDefined(String name) {
    return namespaces.containsKey(name)
        || typedefs.containsKey(name)
        || otherProps.containsKey(name);
  }

  public final boolean isDefined(QualifiedName qname) {
    String name;
    Namespace ns;
    if (qname.isIdentifier()) {
      name = qname.getLeftmostName();
      ns = this;
    } else {
      name = qname.getRightmostName();
      ns = getSubnamespace(qname.getAllButRightmost());
      if (ns == null) {
        return false;
      }
    }
    return ns.isDefined(name);
  }

  public void addNamespace(QualifiedName qname, Namespace ns) {
    checkState(!isDefined(qname));
    checkState(this.namespaceType == null);
    Namespace subns = getReceiverNamespace(qname);
    if (subns.namespaces.isEmpty()) {
      subns.namespaces = new LinkedHashMap<>();
    }
    String name = qname.getRightmostName();
    checkState(!subns.namespaces.containsKey(name));
    subns.namespaces.put(name, ns);
  }

  // For a function namespace, when we compute the function summary during NTI,
  // we update the type here for more precision.
  void updateNamespaceType(JSType t) {
    checkNotNull(t);
    checkNotNull(this.namespaceType);
    this.namespaceType = t;
  }

  public final Declaration getDeclaration(QualifiedName qname) {
    Namespace recv = getReceiverNamespace(qname);
    if (recv == null) {
      return null;
    }
    String name = qname.getRightmostName();
    if (!recv.isDefined(name)) {
      return null;
    }
    Namespace ns = recv.namespaces.get(name);
    DeclaredTypeRegistry scope = ns instanceof FunctionNamespace
        ? ((FunctionNamespace) ns).getScope() : null;
    return new Declaration(
        recv.getPropDeclaredType(name),
        recv.typedefs.get(name),
        ns, scope, false, false);
  }

  public final void addTypedef(QualifiedName qname, Typedef td) {
    checkState(!isDefined(qname));
    checkState(this.namespaceType == null);
    Namespace ns = getReceiverNamespace(qname);
    if (ns.typedefs.isEmpty()) {
      ns.typedefs = new LinkedHashMap<>();
    }
    String name = qname.getRightmostName();
    ns.typedefs.put(name, td);
  }

  private Namespace getReceiverNamespace(QualifiedName qname) {
    if (qname.isIdentifier()) {
      return this;
    } else {
      return getSubnamespace(qname.getAllButRightmost());
    }
  }

  public final Namespace getSubnamespace(QualifiedName qname) {
    String leftmost = qname.getLeftmostName();
    Namespace firstNamespace = this.namespaces.get(leftmost);
    if (firstNamespace == null || qname.isIdentifier()) {
      return firstNamespace;
    } else {
      return firstNamespace.getSubnamespace(qname.getAllButLeftmost());
    }
  }

  public final boolean hasSubnamespace(QualifiedName qname) {
    return getSubnamespace(qname) != null;
  }

  // Static properties

  public final boolean hasStaticProp(String pname) {
    Property prop = otherProps.get(pname);
    if (prop == null) {
      return false;
    }
    checkState(!prop.isOptional());
    return true;
  }

  /** Add a new non-optional declared property to this namespace */
  public final void addProperty(
      String pname, Node defSite, JSType type, boolean isConstant) {
    checkState(this.namespaceType == null);
    if (type == null && isConstant) {
      type = this.commonTypes.UNKNOWN;
    }
    otherProps = otherProps.with(pname, isConstant
        ? Property.makeConstant(defSite, type, type)
        : Property.makeWithDefsite(defSite, type, type));
  }

  /** Add a new undeclared property to this namespace */
  public final void addUndeclaredProperty(
      String pname, Node defSite, JSType t, boolean isConstant) {
    checkState(this.namespaceType == null);
    if (otherProps.containsKey(pname) && otherProps.get(pname).isDeclared()) {
      return;
    }
    otherProps = otherProps.with(pname, isConstant
        ? Property.makeConstant(defSite, t, null)
        : Property.makeWithDefsite(defSite, t, null));
  }

  public final JSType getPropDeclaredType(String pname) {
    Property p = otherProps.get(pname);
    return p == null ? null : p.getDeclaredType();
  }

  final Property getNsProp(String pname) {
    if (this.namespaces.containsKey(pname)) {
      Namespace subns = this.namespaces.get(pname);
      checkState(subns.namespaceType != null);
      return Property.makeWithDefsite(subns.getDefSite(), subns.namespaceType, subns.namespaceType);
    }
    if (this.otherProps.containsKey(pname)) {
      return this.otherProps.get(pname);
    }
    // Do instanceof check instead of making the method non-final, because it
    // should only be overriden by NamespaceLit, not by the other subclasses.
    if (this instanceof NamespaceLit) {
      NominalType maybeWin = ((NamespaceLit) this).getWindowType();
      if (maybeWin != null) {
        return maybeWin.getProp(pname, PropAccess.EXCLUDE_STRAY_PROPS);
      }
    }
    return null;
  }

  final Set<String> getAllPropsOfNamespace() {
    Set<String> s = new LinkedHashSet<>();
    s.addAll(this.namespaces.keySet());
    s.addAll(this.otherProps.keySet());
    return s;
  }

  public final JSType toJSType() {
    if (this.namespaceType == null) {
      checkNotNull(commonTypes);
      for (Namespace ns : this.namespaces.values()) {
        if (this.duringComputeJSType) {
          return null;
        }
        this.duringComputeJSType = true;
        ns.toJSType();
        this.duringComputeJSType = false;
      }
      this.namespaceType = checkNotNull(computeJSType());
    }
    return this.namespaceType;
  }

  // Copy properties from window to Window.prototype, because in rare cases
  // people pass window around rather than using it directly.
  public final void copyWindowProperties(JSTypes commonTypes, RawNominalType win) {
    checkArgument(win.getName().equals("Window"));
    checkNotNull(
        this.namespaces,
        "The built-in types are missing from window. "
            + "Perhaps you forgot to run DeclaredGlobalExternsOnWindow?");

    for (Map.Entry<String, Namespace> entry : this.namespaces.entrySet()) {
      Namespace ns = entry.getValue();
      if (ns instanceof RawNominalType) {
        RawNominalType rawType = (RawNominalType) ns;
        // Hack: circular namespace here, skip adding Window.
        if (!rawType.isFrozen()) {
          Preconditions.checkState(rawType.getName().equals("Window"),
              "Unexpected unfrozen type %s", rawType.getName());
          continue;
        }
      }
      win.addProtoProperty(entry.getKey(), null, ns.toJSType(), true);
    }
    for (Map.Entry<String, Property> entry : this.otherProps.entrySet()) {
      Property p = entry.getValue();
      win.addProtoProperty(entry.getKey(), null, p.getType(), p.isConstant());
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
