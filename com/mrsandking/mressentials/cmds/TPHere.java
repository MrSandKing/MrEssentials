package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrsandking.mressentials.utils.PlayerUtils;
import com.mrsandking.mressentials.utils.TeleportUtils;

public class TPHere implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tphere")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("mressentials.tphere")) {
					if(args.length == 1) {
						Player target = Bukkit.getPlayer(args[0]);
						if(PlayerUtils.getOnlinePlayer(target)) {
							TeleportUtils.teleportToPlayer(target, player);
						} else {
							player.sendMessage(ChatColor.RED+"Couldn't find that player!");
						}
					} else {
						player.sendMessage(ChatColor.RED+"Correct usage: /tphere <player>");
					}
				} else {
					player.sendMessage(ChatColor.RED+"You don't have permission to perform that command!");
				}
			} else {
				sender.sendMessage(ChatColor.AQUA+"You're the console! You can't teleport any player to you!");
			}
			return true;
		}
		return false;
	}
	

}
