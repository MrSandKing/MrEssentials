package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mrsandking.mressentials.utils.PlayerUtils;

public class DEOP implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("deop")) {
			if(!(sender instanceof Player)) {
				if(args.length == 1) {
					
					Player player = Bukkit.getPlayer(args[0]);
					
					if(player == null) {
						sender.sendMessage(ChatColor.RED+"Couldn't find that player!");
					}
						
					for(OfflinePlayer ops : Bukkit.getOperators()) {
						if(ops.equals(player)) {
							PlayerUtils.setOP(player,false);
							sender.sendMessage(ChatColor.GREEN+"This player is no longer Server Operator");
						} 
					}

					
					sender.sendMessage(ChatColor.RED+"This player isn't Server Operator");

				} else {
					sender.sendMessage(ChatColor.RED+"Correct usage: /deop <server operator>");
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
