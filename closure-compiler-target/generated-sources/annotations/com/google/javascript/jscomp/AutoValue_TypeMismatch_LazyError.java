
package com.google.javascript.jscomp;

import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.TypeI;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TypeMismatch_LazyError extends TypeMismatch.LazyError {

  private final String message;
  private final Node node;
  private final TypeI sourceType;
  private final TypeI targetType;

  AutoValue_TypeMismatch_LazyError(
      String message,
      Node node,
      TypeI sourceType,
      TypeI targetType) {
    if (message == null) {
      throw new NullPointerException("Null message");
    }
    this.message = message;
    if (node == null) {
      throw new NullPointerException("Null node");
    }
    this.node = node;
    if (sourceType == null) {
      throw new NullPointerException("Null sourceType");
    }
    this.sourceType = sourceType;
    if (targetType == null) {
      throw new NullPointerException("Null targetType");
    }
    this.targetType = targetType;
  }

  @Override
  String message() {
    return message;
  }

  @Override
  Node node() {
    return node;
  }

  @Override
  TypeI sourceType() {
    return sourceType;
  }

  @Override
  TypeI targetType() {
    return targetType;
  }

  @Override
  public String toString() {
    return "LazyError{"
        + "message=" + message + ", "
        + "node=" + node + ", "
        + "sourceType=" + sourceType + ", "
        + "targetType=" + targetType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TypeMismatch.LazyError) {
      TypeMismatch.LazyError that = (TypeMismatch.LazyError) o;
      return (this.message.equals(that.message()))
           && (this.node.equals(that.node()))
           && (this.sourceType.equals(that.sourceType()))
           && (this.targetType.equals(that.targetType()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.message.hashCode();
    h *= 1000003;
    h ^= this.node.hashCode();
    h *= 1000003;
    h ^= this.sourceType.hashCode();
    h *= 1000003;
    h ^= this.targetType.hashCode();
    return h;
  }

}
