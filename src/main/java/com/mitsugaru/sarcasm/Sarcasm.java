package com.mitsugaru.sarcasm;

import org.bukkit.plugin.java.JavaPlugin;

import com.mitsugaru.sarcasm.listener.ChatListener;

public class Sarcasm extends JavaPlugin {

   @Override
   public void onEnable() {
      getServer().getPluginManager().registerEvents(new ChatListener(this), this);
   }

}
