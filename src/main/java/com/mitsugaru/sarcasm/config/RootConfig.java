package com.mitsugaru.sarcasm.config;

import org.bukkit.configuration.ConfigurationSection;

import com.mitsugaru.sarcasm.Sarcasm;
import com.mitsugaru.sarcasm.services.ModularConfig;

public class RootConfig extends ModularConfig<Sarcasm> {

   public RootConfig(Sarcasm plugin) {
      super(plugin);
      loadDefaults(plugin.getConfig());
      plugin.saveConfig();
      reload();
   }

   @Override
   public void save() {
      plugin.saveConfig();
   }

   @Override
   public void set(String path, Object value) {
      plugin.getConfig().set(path, value);
      plugin.saveConfig();
   }

   @Override
   public void reload() {
      plugin.reloadConfig();
      loadSettings(plugin.getConfig());
   }

   @Override
   public void loadSettings(ConfigurationSection config) {
      for(final RootConfigNode node : RootConfigNode.values()) {
         updateOption(node);
      }
   }

   @Override
   public void loadDefaults(ConfigurationSection config) {
      for(final RootConfigNode node : RootConfigNode.values()) {
         if(!config.contains(node.getPath())) {
            config.set(node.getPath(), node.getDefaultValue());
         }
      }
   }

   @Override
   public void boundsCheck() {
   }

}
