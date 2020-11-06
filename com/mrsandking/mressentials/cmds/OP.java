package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrsandking.mressentials.utils.PlayerUtils;

public class OP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("op")) {
			if(!(sender instanceof Player)) {
				if(args.length == 1) {
					Player player = Bukkit.getPlayer(args[0]);
					if(PlayerUtils.getOnlinePlayer(player)) {
						if(!player.isOp()) {
							player.setOp(true);
							sender.sendMessage(ChatColor.GREEN+"New "+ChatColor.RED+"Server Operator"+ChatColor.GREEN+"!");
							sender.sendMessage(ChatColor.RED+player.getName()+ChatColor.GREEN+" now is the "+ChatColor.RED+"Server Operator");
						} else {
							sender.sendMessage(ChatColor.RED+"This player is already server operator!");
						}
					} else {
						sender.sendMessage(ChatColor.RED+"Couldn't find this player!");
					}
				} else {
					sender.sendMessage(ChatColor.RED+"Correct usage: /op <player>");
				}
			} else {
				sender.sendMessage(ChatColor.RED+"You can't perform that command!");
				sender.sendMessage(ChatColor.RED+"Only console can execute that command!");
			}
			return true;
		}
		return false;
	}
	
	

}
