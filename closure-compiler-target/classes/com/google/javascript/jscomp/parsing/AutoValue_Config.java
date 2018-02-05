
package com.google.javascript.jscomp.parsing;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Config extends Config {

  private final Config.LanguageMode languageMode;
  private final Config.StrictMode strictMode;
  private final Config.JsDocParsing jsDocParsingMode;
  private final Config.RunMode runMode;
  private final ImmutableMap<String, Annotation> annotations;
  private final ImmutableSet<String> suppressionNames;
  private final boolean parseInlineSourceMaps;

  private AutoValue_Config(
      Config.LanguageMode languageMode,
      Config.StrictMode strictMode,
      Config.JsDocParsing jsDocParsingMode,
      Config.RunMode runMode,
      ImmutableMap<String, Annotation> annotations,
      ImmutableSet<String> suppressionNames,
      boolean parseInlineSourceMaps) {
    this.languageMode = languageMode;
    this.strictMode = strictMode;
    this.jsDocParsingMode = jsDocParsingMode;
    this.runMode = runMode;
    this.annotations = annotations;
    this.suppressionNames = suppressionNames;
    this.parseInlineSourceMaps = parseInlineSourceMaps;
  }

  @Override
  Config.LanguageMode languageMode() {
    return languageMode;
  }

  @Override
  Config.StrictMode strictMode() {
    return strictMode;
  }

  @Override
  Config.JsDocParsing jsDocParsingMode() {
    return jsDocParsingMode;
  }

  @Override
  Config.RunMode runMode() {
    return runMode;
  }

  @Override
  ImmutableMap<String, Annotation> annotations() {
    return annotations;
  }

  @Override
  ImmutableSet<String> suppressionNames() {
    return suppressionNames;
  }

  @Override
  boolean parseInlineSourceMaps() {
    return parseInlineSourceMaps;
  }

  @Override
  public String toString() {
    return "Config{"
        + "languageMode=" + languageMode + ", "
        + "strictMode=" + strictMode + ", "
        + "jsDocParsingMode=" + jsDocParsingMode + ", "
        + "runMode=" + runMode + ", "
        + "annotations=" + annotations + ", "
        + "suppressionNames=" + suppressionNames + ", "
        + "parseInlineSourceMaps=" + parseInlineSourceMaps
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Config) {
      Config that = (Config) o;
      return (this.languageMode.equals(that.languageMode()))
           && (this.strictMode.equals(that.strictMode()))
           && (this.jsDocParsingMode.equals(that.jsDocParsingMode()))
           && (this.runMode.equals(that.runMode()))
           && (this.annotations.equals(that.annotations()))
           && (this.suppressionNames.equals(that.suppressionNames()))
           && (this.parseInlineSourceMaps == that.parseInlineSourceMaps());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.languageMode.hashCode();
    h *= 1000003;
    h ^= this.strictMode.hashCode();
    h *= 1000003;
    h ^= this.jsDocParsingMode.hashCode();
    h *= 1000003;
    h ^= this.runMode.hashCode();
    h *= 1000003;
    h ^= this.annotations.hashCode();
    h *= 1000003;
    h ^= this.suppressionNames.hashCode();
    h *= 1000003;
    h ^= this.parseInlineSourceMaps ? 1231 : 1237;
    return h;
  }

  static final class Builder extends Config.Builder {
    private Config.LanguageMode languageMode;
    private Config.StrictMode strictMode;
    private Config.JsDocParsing jsDocParsingMode;
    private Config.RunMode runMode;
    private ImmutableMap<String, Annotation> annotations;
    private ImmutableSet<String> suppressionNames;
    private Boolean parseInlineSourceMaps;
    Builder() {
    }
    @Override
    Config.Builder setLanguageMode(Config.LanguageMode languageMode) {
      if (languageMode == null) {
        throw new NullPointerException("Null languageMode");
      }
      this.languageMode = languageMode;
      return this;
    }
    @Override
    Config.Builder setStrictMode(Config.StrictMode strictMode) {
      if (strictMode == null) {
        throw new NullPointerException("Null strictMode");
      }
      this.strictMode = strictMode;
      return this;
    }
    @Override
    Config.Builder setJsDocParsingMode(Config.JsDocParsing jsDocParsingMode) {
      if (jsDocParsingMode == null) {
        throw new NullPointerException("Null jsDocParsingMode");
      }
      this.jsDocParsingMode = jsDocParsingMode;
      return this;
    }
    @Override
    Config.Builder setRunMode(Config.RunMode runMode) {
      if (runMode == null) {
        throw new NullPointerException("Null runMode");
      }
      this.runMode = runMode;
      return this;
    }
    @Override
    Config.Builder setAnnotations(ImmutableMap<String, Annotation> annotations) {
      if (annotations == null) {
        throw new NullPointerException("Null annotations");
      }
      this.annotations = annotations;
      return this;
    }
    @Override
    Config.Builder setSuppressionNames(Iterable<String> suppressionNames) {
      if (suppressionNames == null) {
        throw new NullPointerException("Null suppressionNames");
      }
      this.suppressionNames = ImmutableSet.copyOf(suppressionNames);
      return this;
    }
    @Override
    Config.Builder setParseInlineSourceMaps(boolean parseInlineSourceMaps) {
      this.parseInlineSourceMaps = parseInlineSourceMaps;
      return this;
    }
    @Override
    Config build() {
      String missing = "";
      if (this.languageMode == null) {
        missing += " languageMode";
      }
      if (this.strictMode == null) {
        missing += " strictMode";
      }
      if (this.jsDocParsingMode == null) {
        missing += " jsDocParsingMode";
      }
      if (this.runMode == null) {
        missing += " runMode";
      }
      if (this.annotations == null) {
        missing += " annotations";
      }
      if (this.suppressionNames == null) {
        missing += " suppressionNames";
      }
      if (this.parseInlineSourceMaps == null) {
        missing += " parseInlineSourceMaps";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Config(
          this.languageMode,
          this.strictMode,
          this.jsDocParsingMode,
          this.runMode,
          this.annotations,
          this.suppressionNames,
          this.parseInlineSourceMaps);
    }
  }

}
