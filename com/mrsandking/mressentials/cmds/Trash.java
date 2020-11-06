package com.mrsandking.mressentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trash implements CommandExecutor {
	
	private static Inventory trash;
	private static int rows = 9*4;
	private static String name = "&4&lTrash";
	
	public static void createTrash() {
		trash = Bukkit.createInventory(null, rows, ChatColor.translateAlternateColorCodes('&', name));
	}

	private void openTrash(Player player) {
		player.openInventory(trash);
		if(trash.getContents() != null) {
			trash.clear();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("trash")) {
			
			if(sender instanceof Player) {
				Player player = (Player) sender;
				openTrash(player);
			} else {
				sender.sendMessage(ChatColor.RED+"You're the console! You can't open any inventory!");
			}
			return true;
			
		}
		
		return false;
	}

	
	
	
}
