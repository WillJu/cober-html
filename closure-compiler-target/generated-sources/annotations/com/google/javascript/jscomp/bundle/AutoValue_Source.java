
package com.google.javascript.jscomp.bundle;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.nio.file.Path;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Source extends Source {

  private final Path path;
  private final String sourceMap;
  private final String sourceUrl;
  private final String sourceMappingUrl;
  private final ImmutableSet<String> runtimes;
  private final ImmutableMap<String, String> loadFlags;
  private final int estimatedSize;
  private final Source.Lazy<String> codeSupplier;
  private final Source.Lazy<String> originalCodeSupplier;

  private AutoValue_Source(
      Path path,
      String sourceMap,
      String sourceUrl,
      String sourceMappingUrl,
      ImmutableSet<String> runtimes,
      ImmutableMap<String, String> loadFlags,
      int estimatedSize,
      Source.Lazy<String> codeSupplier,
      @Nullable Source.Lazy<String> originalCodeSupplier) {
    this.path = path;
    this.sourceMap = sourceMap;
    this.sourceUrl = sourceUrl;
    this.sourceMappingUrl = sourceMappingUrl;
    this.runtimes = runtimes;
    this.loadFlags = loadFlags;
    this.estimatedSize = estimatedSize;
    this.codeSupplier = codeSupplier;
    this.originalCodeSupplier = originalCodeSupplier;
  }

  @Override
  public Path path() {
    return path;
  }

  @Override
  public String sourceMap() {
    return sourceMap;
  }

  @Override
  public String sourceUrl() {
    return sourceUrl;
  }

  @Override
  public String sourceMappingUrl() {
    return sourceMappingUrl;
  }

  @Override
  public ImmutableSet<String> runtimes() {
    return runtimes;
  }

  @Override
  public ImmutableMap<String, String> loadFlags() {
    return loadFlags;
  }

  @Override
  public int estimatedSize() {
    return estimatedSize;
  }

  @Override
  Source.Lazy<String> codeSupplier() {
    return codeSupplier;
  }

  @Nullable
  @Override
  Source.Lazy<String> originalCodeSupplier() {
    return originalCodeSupplier;
  }

  @Override
  public String toString() {
    return "Source{"
        + "path=" + path + ", "
        + "sourceMap=" + sourceMap + ", "
        + "sourceUrl=" + sourceUrl + ", "
        + "sourceMappingUrl=" + sourceMappingUrl + ", "
        + "runtimes=" + runtimes + ", "
        + "loadFlags=" + loadFlags + ", "
        + "estimatedSize=" + estimatedSize + ", "
        + "codeSupplier=" + codeSupplier + ", "
        + "originalCodeSupplier=" + originalCodeSupplier
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Source) {
      Source that = (Source) o;
      return (this.path.equals(that.path()))
           && (this.sourceMap.equals(that.sourceMap()))
           && (this.sourceUrl.equals(that.sourceUrl()))
           && (this.sourceMappingUrl.equals(that.sourceMappingUrl()))
           && (this.runtimes.equals(that.runtimes()))
           && (this.loadFlags.equals(that.loadFlags()))
           && (this.estimatedSize == that.estimatedSize())
           && (this.codeSupplier.equals(that.codeSupplier()))
           && ((this.originalCodeSupplier == null) ? (that.originalCodeSupplier() == null) : this.originalCodeSupplier.equals(that.originalCodeSupplier()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.path.hashCode();
    h *= 1000003;
    h ^= this.sourceMap.hashCode();
    h *= 1000003;
    h ^= this.sourceUrl.hashCode();
    h *= 1000003;
    h ^= this.sourceMappingUrl.hashCode();
    h *= 1000003;
    h ^= this.runtimes.hashCode();
    h *= 1000003;
    h ^= this.loadFlags.hashCode();
    h *= 1000003;
    h ^= this.estimatedSize;
    h *= 1000003;
    h ^= this.codeSupplier.hashCode();
    h *= 1000003;
    h ^= (originalCodeSupplier == null) ? 0 : this.originalCodeSupplier.hashCode();
    return h;
  }

  @Override
  public Source.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends Source.Builder {
    private Path path;
    private String sourceMap;
    private String sourceUrl;
    private String sourceMappingUrl;
    private ImmutableSet<String> runtimes;
    private ImmutableMap<String, String> loadFlags;
    private Integer estimatedSize;
    private Source.Lazy<String> codeSupplier;
    private Source.Lazy<String> originalCodeSupplier;
    Builder() {
    }
    private Builder(Source source) {
      this.path = source.path();
      this.sourceMap = source.sourceMap();
      this.sourceUrl = source.sourceUrl();
      this.sourceMappingUrl = source.sourceMappingUrl();
      this.runtimes = source.runtimes();
      this.loadFlags = source.loadFlags();
      this.estimatedSize = source.estimatedSize();
      this.codeSupplier = source.codeSupplier();
      this.originalCodeSupplier = source.originalCodeSupplier();
    }
    @Override
    public Source.Builder setPath(Path path) {
      if (path == null) {
        throw new NullPointerException("Null path");
      }
      this.path = path;
      return this;
    }
    @Override
    public Source.Builder setSourceMap(String sourceMap) {
      if (sourceMap == null) {
        throw new NullPointerException("Null sourceMap");
      }
      this.sourceMap = sourceMap;
      return this;
    }
    @Override
    public Source.Builder setSourceUrl(String sourceUrl) {
      if (sourceUrl == null) {
        throw new NullPointerException("Null sourceUrl");
      }
      this.sourceUrl = sourceUrl;
      return this;
    }
    @Override
    public Source.Builder setSourceMappingUrl(String sourceMappingUrl) {
      if (sourceMappingUrl == null) {
        throw new NullPointerException("Null sourceMappingUrl");
      }
      this.sourceMappingUrl = sourceMappingUrl;
      return this;
    }
    @Override
    public Source.Builder setRuntimes(ImmutableSet<String> runtimes) {
      if (runtimes == null) {
        throw new NullPointerException("Null runtimes");
      }
      this.runtimes = runtimes;
      return this;
    }
    @Override
    ImmutableSet<String> runtimes() {
      if (runtimes == null) {
        throw new IllegalStateException("Property \"runtimes\" has not been set");
      }
      return runtimes;
    }
    @Override
    public Source.Builder setLoadFlags(ImmutableMap<String, String> loadFlags) {
      if (loadFlags == null) {
        throw new NullPointerException("Null loadFlags");
      }
      this.loadFlags = loadFlags;
      return this;
    }
    @Override
    public Source.Builder setEstimatedSize(int estimatedSize) {
      this.estimatedSize = estimatedSize;
      return this;
    }
    @Override
    Source.Builder setCodeSupplier(Source.Lazy<String> codeSupplier) {
      if (codeSupplier == null) {
        throw new NullPointerException("Null codeSupplier");
      }
      this.codeSupplier = codeSupplier;
      return this;
    }
    @Override
    Source.Lazy<String> codeSupplier() {
      if (codeSupplier == null) {
        throw new IllegalStateException("Property \"codeSupplier\" has not been set");
      }
      return codeSupplier;
    }
    @Override
    Source.Builder setOriginalCodeSupplier(@Nullable Source.Lazy<String> originalCodeSupplier) {
      this.originalCodeSupplier = originalCodeSupplier;
      return this;
    }
    @Override
    @Nullable Source.Lazy<String> originalCodeSupplier() {
      return originalCodeSupplier;
    }
    @Override
    Source autoBuild() {
      String missing = "";
      if (this.path == null) {
        missing += " path";
      }
      if (this.sourceMap == null) {
        missing += " sourceMap";
      }
      if (this.sourceUrl == null) {
        missing += " sourceUrl";
      }
      if (this.sourceMappingUrl == null) {
        missing += " sourceMappingUrl";
      }
      if (this.runtimes == null) {
        missing += " runtimes";
      }
      if (this.loadFlags == null) {
        missing += " loadFlags";
      }
      if (this.estimatedSize == null) {
        missing += " estimatedSize";
      }
      if (this.codeSupplier == null) {
        missing += " codeSupplier";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Source(
          this.path,
          this.sourceMap,
          this.sourceUrl,
          this.sourceMappingUrl,
          this.runtimes,
          this.loadFlags,
          this.estimatedSize,
          this.codeSupplier,
          this.originalCodeSupplier);
    }
  }

}
