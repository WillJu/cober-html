
package com.google.javascript.jscomp;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RemoveUnusedPolyfills_PrototypeMethod extends RemoveUnusedPolyfills.PrototypeMethod {

  private final String type;
  private final String method;

  AutoValue_RemoveUnusedPolyfills_PrototypeMethod(
      String type,
      String method) {
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    if (method == null) {
      throw new NullPointerException("Null method");
    }
    this.method = method;
  }

  @Override
  String type() {
    return type;
  }

  @Override
  String method() {
    return method;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RemoveUnusedPolyfills.PrototypeMethod) {
      RemoveUnusedPolyfills.PrototypeMethod that = (RemoveUnusedPolyfills.PrototypeMethod) o;
      return (this.type.equals(that.type()))
           && (this.method.equals(that.method()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.type.hashCode();
    h *= 1000003;
    h ^= this.method.hashCode();
    return h;
  }

}
