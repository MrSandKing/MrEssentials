package com.mrsandking.mressentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerUtils {

	public static boolean getOnlinePlayer(Player player) {
		return player.isOnline();	
	}

	public static void kickPlayer(Player player, String info, String reason, CommandSender sender) {
		if(getOnlinePlayer(player)) {
			if(reason.length() >= 2) {
				if(sender != null) {
					player.kickPlayer(ChatColor.GREEN+info+": "+reason);
				}
			}
		}
	}
	
}
