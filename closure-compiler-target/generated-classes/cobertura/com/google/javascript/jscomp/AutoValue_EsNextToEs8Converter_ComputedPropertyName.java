
package com.google.javascript.jscomp;

import com.google.javascript.rhino.Node;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EsNextToEs8Converter_ComputedPropertyName extends EsNextToEs8Converter.ComputedPropertyName {

  private final String varName;
  private final Node computation;

  AutoValue_EsNextToEs8Converter_ComputedPropertyName(
      String varName,
      Node computation) {
    if (varName == null) {
      throw new NullPointerException("Null varName");
    }
    this.varName = varName;
    if (computation == null) {
      throw new NullPointerException("Null computation");
    }
    this.computation = computation;
  }

  @Override
  String varName() {
    return varName;
  }

  @Override
  Node computation() {
    return computation;
  }

  @Override
  public String toString() {
    return "ComputedPropertyName{"
        + "varName=" + varName + ", "
        + "computation=" + computation
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EsNextToEs8Converter.ComputedPropertyName) {
      EsNextToEs8Converter.ComputedPropertyName that = (EsNextToEs8Converter.ComputedPropertyName) o;
      return (this.varName.equals(that.varName()))
           && (this.computation.equals(that.computation()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.varName.hashCode();
    h *= 1000003;
    h ^= this.computation.hashCode();
    return h;
  }

}
