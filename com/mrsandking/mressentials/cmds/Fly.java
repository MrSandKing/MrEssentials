package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrsandking.mressentials.utils.PlayerUtils;

import net.md_5.bungee.api.ChatColor;

public class Fly implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("mressentials.fly")) {
					if(args.length == 0) {
						if(player.getAllowFlight()) {
							player.setAllowFlight(false);
							player.sendMessage(ChatColor.AQUA+"Fly - disabled");
						} else {
							player.setAllowFlight(true);
							player.sendMessage(ChatColor.AQUA+"Fly - enabled");
						}
					} else if(args.length == 1) {
						Player target = Bukkit.getPlayer(args[0]);
						if(PlayerUtils.getOnlinePlayer(target)) {
							if(target.getAllowFlight()) {
								target.setAllowFlight(false);
								target.sendMessage(ChatColor.AQUA+"Fly - disabled");
							} else {
								target.setAllowFlight(true);
								target.sendMessage(ChatColor.AQUA+"Fly - enabled");
							}
						} else {
							player.sendMessage(ChatColor.RED+"Couldn't find that player!");
						}
					} else {
						player.sendMessage(ChatColor.AQUA+"Correct Usage: /fly <player>");
					}
				} else {
					player.sendMessage(ChatColor.RED+"You don't have permission to perform that command.");
				}
			} else {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(PlayerUtils.getOnlinePlayer(target)) {
						if(target.getAllowFlight()) {
							target.setAllowFlight(false);
							target.sendMessage(ChatColor.AQUA+"Fly - disabled");
						} else {
							target.setAllowFlight(true);
							target.sendMessage(ChatColor.AQUA+"Fly - enabled");
						}
					} else {
						sender.sendMessage(ChatColor.RED+"Couldn't find that player!");
					}
				} else {
					sender.sendMessage(ChatColor.AQUA+"You're the console! You can't fly!");
					sender.sendMessage(ChatColor.AQUA+"Correct usage: /fly <player>");
				}
			}
			return true;
		}
		return false;
	}
	
	

}
