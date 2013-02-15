package com.mitsugaru.sarcasm.listener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.mitsugaru.sarcasm.Sarcasm;
import com.mitsugaru.sarcasm.config.RootConfigNode;
import com.mitsugaru.sarcasm.services.PermissionNode;

public class ChatListener implements Listener {

   private Sarcasm plugin;

   private static final Pattern sarcasm = Pattern.compile("/sarcasm", Pattern.CASE_INSENSITIVE);

   public ChatListener(Sarcasm plugin) {
      this.plugin = plugin;
   }

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onPlayerChat(AsyncPlayerChatEvent event) {
      if(event.isCancelled()) {
         return;
      } else if(!event.getPlayer().hasPermission(PermissionNode.USE.getNode())) {
         return;
      }
      String source = event.getMessage();
      if(!(source.contains("/sarcasm"))) {
         return;
      }
      String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getRootConfig().getString(RootConfigNode.PREFIX));
      String suffix = ChatColor.translateAlternateColorCodes('&', plugin.getRootConfig().getString(RootConfigNode.SUFFIX));
      String replace = ChatColor.translateAlternateColorCodes('&', plugin.getRootConfig().getString(RootConfigNode.REPLACE));
      Matcher matcher = sarcasm.matcher(source);
      StringBuilder builder = new StringBuilder();
      if(!prefix.isEmpty()) {
         builder.append(prefix);
      }
      builder.append(matcher.replaceAll(replace));
      if(!suffix.isEmpty()) {
         builder.append(suffix);
      }
      event.setMessage(builder.toString());
   }

}
