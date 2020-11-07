package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrsandking.mressentials.utils.PlayerUtils;

public class Kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kick")) {
			if(args.length >= 2) {
				String string = "";
		        for (int i = 1; i < args.length; i++)
		        	string = String.valueOf(string) + args[i] + " ";
		        
				Player target = Bukkit.getPlayer(args[0]);
				
				PlayerUtils.kickPlayer(target, "You've been kicked, reason", string, sender);
				
			} else {
				sender.sendMessage(ChatColor.RED+"Correct usage: /kick <player> <reason>");
			}
			return true;
		}
		return false;
	}

}
