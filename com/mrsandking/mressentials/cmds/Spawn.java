package com.mrsandking.mressentials.cmds;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("mressentials.spawn")) {
					
					double x,y,z,pitch,yaw;
					String world;
					
					File spawn = new File("plugins/MrEssentials/spawn.yml");
					
					if(!spawn.exists()) {
						player.sendMessage(ChatColor.RED+"File doesn't exists!");
					}
					
					YamlConfiguration spawnconfig = YamlConfiguration.loadConfiguration(spawn);
					
					x = spawnconfig.getDouble("spawn.x");
					y = spawnconfig.getDouble("spawn.y");
					z = spawnconfig.getDouble("spawn.z");
					pitch = spawnconfig.getDouble("spawn.pitch");
					yaw = spawnconfig.getDouble("spawn.yaw");
					
					world = spawnconfig.getString("spawn.world");
					
					if(world == null) {
						player.sendMessage(ChatColor.RED+"You can't teleport to nulled world!");
					} else { 
					
						player.teleport(new Location(Bukkit.getWorld(world), x,y,z,(float)pitch,(float)yaw));
					
					}
				} else {
					player.sendMessage(ChatColor.RED+"You don't have permission to perform that command!");
				}
			} else {
				sender.sendMessage(ChatColor.RED+"Console can't teleport to the spawn!");
			}
			return true;
		}
		return false;
	}

	
	
}
