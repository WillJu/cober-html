
package com.google.javascript.jscomp.deps;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SimpleDependencyInfo extends SimpleDependencyInfo {

  private final String name;
  private final String pathRelativeToClosureBase;
  private final ImmutableList<String> provides;
  private final ImmutableList<String> requires;
  private final ImmutableList<String> weakRequires;
  private final ImmutableMap<String, String> loadFlags;

  private AutoValue_SimpleDependencyInfo(
      String name,
      String pathRelativeToClosureBase,
      ImmutableList<String> provides,
      ImmutableList<String> requires,
      ImmutableList<String> weakRequires,
      ImmutableMap<String, String> loadFlags) {
    this.name = name;
    this.pathRelativeToClosureBase = pathRelativeToClosureBase;
    this.provides = provides;
    this.requires = requires;
    this.weakRequires = weakRequires;
    this.loadFlags = loadFlags;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPathRelativeToClosureBase() {
    return pathRelativeToClosureBase;
  }

  @Override
  public ImmutableList<String> getProvides() {
    return provides;
  }

  @Override
  public ImmutableList<String> getRequires() {
    return requires;
  }

  @Override
  public ImmutableList<String> getWeakRequires() {
    return weakRequires;
  }

  @Override
  public ImmutableMap<String, String> getLoadFlags() {
    return loadFlags;
  }

  @Override
  public String toString() {
    return "SimpleDependencyInfo{"
        + "name=" + name + ", "
        + "pathRelativeToClosureBase=" + pathRelativeToClosureBase + ", "
        + "provides=" + provides + ", "
        + "requires=" + requires + ", "
        + "weakRequires=" + weakRequires + ", "
        + "loadFlags=" + loadFlags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SimpleDependencyInfo) {
      SimpleDependencyInfo that = (SimpleDependencyInfo) o;
      return (this.name.equals(that.getName()))
           && (this.pathRelativeToClosureBase.equals(that.getPathRelativeToClosureBase()))
           && (this.provides.equals(that.getProvides()))
           && (this.requires.equals(that.getRequires()))
           && (this.weakRequires.equals(that.getWeakRequires()))
           && (this.loadFlags.equals(that.getLoadFlags()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.pathRelativeToClosureBase.hashCode();
    h *= 1000003;
    h ^= this.provides.hashCode();
    h *= 1000003;
    h ^= this.requires.hashCode();
    h *= 1000003;
    h ^= this.weakRequires.hashCode();
    h *= 1000003;
    h ^= this.loadFlags.hashCode();
    return h;
  }

  static final class Builder extends SimpleDependencyInfo.Builder {
    private String name;
    private String pathRelativeToClosureBase;
    private ImmutableList<String> provides;
    private ImmutableList<String> requires;
    private ImmutableList<String> weakRequires;
    private ImmutableMap<String, String> loadFlags;
    Builder() {
    }
    @Override
    SimpleDependencyInfo.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    SimpleDependencyInfo.Builder setPathRelativeToClosureBase(String pathRelativeToClosureBase) {
      if (pathRelativeToClosureBase == null) {
        throw new NullPointerException("Null pathRelativeToClosureBase");
      }
      this.pathRelativeToClosureBase = pathRelativeToClosureBase;
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setProvides(Collection<String> provides) {
      if (provides == null) {
        throw new NullPointerException("Null provides");
      }
      this.provides = ImmutableList.copyOf(provides);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setProvides(String... provides) {
      if (provides == null) {
        throw new NullPointerException("Null provides");
      }
      this.provides = ImmutableList.copyOf(provides);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setRequires(Collection<String> requires) {
      if (requires == null) {
        throw new NullPointerException("Null requires");
      }
      this.requires = ImmutableList.copyOf(requires);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setRequires(String... requires) {
      if (requires == null) {
        throw new NullPointerException("Null requires");
      }
      this.requires = ImmutableList.copyOf(requires);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setWeakRequires(Collection<String> weakRequires) {
      if (weakRequires == null) {
        throw new NullPointerException("Null weakRequires");
      }
      this.weakRequires = ImmutableList.copyOf(weakRequires);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setWeakRequires(String... weakRequires) {
      if (weakRequires == null) {
        throw new NullPointerException("Null weakRequires");
      }
      this.weakRequires = ImmutableList.copyOf(weakRequires);
      return this;
    }
    @Override
    public SimpleDependencyInfo.Builder setLoadFlags(Map<String, String> loadFlags) {
      if (loadFlags == null) {
        throw new NullPointerException("Null loadFlags");
      }
      this.loadFlags = ImmutableMap.copyOf(loadFlags);
      return this;
    }
    @Override
    public SimpleDependencyInfo build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (this.pathRelativeToClosureBase == null) {
        missing += " pathRelativeToClosureBase";
      }
      if (this.provides == null) {
        missing += " provides";
      }
      if (this.requires == null) {
        missing += " requires";
      }
      if (this.weakRequires == null) {
        missing += " weakRequires";
      }
      if (this.loadFlags == null) {
        missing += " loadFlags";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SimpleDependencyInfo(
          this.name,
          this.pathRelativeToClosureBase,
          this.provides,
          this.requires,
          this.weakRequires,
          this.loadFlags);
    }
  }

}
