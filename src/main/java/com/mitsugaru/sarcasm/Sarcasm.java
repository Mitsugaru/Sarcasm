package com.mitsugaru.sarcasm;

import org.bukkit.plugin.java.JavaPlugin;

import com.mitsugaru.sarcasm.config.RootConfig;
import com.mitsugaru.sarcasm.listener.ChatListener;

public class Sarcasm extends JavaPlugin {

   RootConfig config;

   @Override
   public void onEnable() {
      config = new RootConfig(this);

      getServer().getPluginManager().registerEvents(new ChatListener(this), this);
   }

   public RootConfig getRootConfig() {
      return config;
   }
}
