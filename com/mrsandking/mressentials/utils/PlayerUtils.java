package com.mrsandking.mressentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerUtils {

	public static void kickPlayer(Player player, String info, String reason, CommandSender sender) {
			
		if(player != null) {
			
			if(!player.isOp()) { 
				
				if(reason == null) reason = ChatColor.RED+"-";
				
				if(sender != null) {
					player.kickPlayer(ChatColor.AQUA+info+": "+ ChatColor.translateAlternateColorCodes('&', reason));
				}
				
			} else {
				sender.sendMessage(ChatColor.RED+"You can't kick OP!");
			}
			
		} else {
			sender.sendMessage(ChatColor.RED+"Couldn't find that player!");
		}
		
	}
	
	public static void setOP(Player player, boolean op) {
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players.getName().equals(player.getName())) {
				if(op == true) {
					player.setOp(true);
				} else if(op == false) {
					player.setOp(false);
				}
			} else {
				if(op == true) {
					player.setOp(true);
				} else if(op == false) {
					player.setOp(false);
				}
			}
		}
		
	}
	
}
