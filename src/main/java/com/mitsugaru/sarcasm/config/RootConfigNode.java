package com.mitsugaru.sarcasm.config;

import com.mitsugaru.sarcasm.services.ConfigNode;

public enum RootConfigNode implements ConfigNode {
   PREFIX("sarcasm.prefix", VarType.STRING, ""),
   SUFFIX("sarcasm.suffix", VarType.STRING, ""),
   REPLACE("sarcasm.replace", VarType.STRING, "");

   private String path;
   private VarType type;
   private Object defaultValue;

   private RootConfigNode(String path, VarType type, Object def) {
      this.path = path;
      this.type = type;
      this.defaultValue = def;
   }

   @Override
   public String getPath() {
      return path;
   }

   @Override
   public VarType getVarType() {
      return type;
   }

   @Override
   public Object getDefaultValue() {
      return defaultValue;
   }

}
