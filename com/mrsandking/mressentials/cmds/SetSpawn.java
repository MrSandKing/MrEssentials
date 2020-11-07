package com.mrsandking.mressentials.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("mressentials.setspawn")) {
					Location location = player.getLocation();
					
					double x,y,z,pitch,yaw;
					String world;
					
					File spawn = new File("plugins/MrEssentials/spawn.yml");
					
					if(!spawn.exists()) {
						player.sendMessage(ChatColor.RED+"File doesn't exists! Creating spawn.yml file...");
						
						try {
							spawn.createNewFile();
							player.sendMessage(ChatColor.GREEN+"Created spawn.yml file!");
						} catch(Exception e) {
							e.printStackTrace();
						}
						
					}
					
					YamlConfiguration spawnconfig = YamlConfiguration.loadConfiguration(spawn);
					
					x = location.getX();
					y = location.getY();
					z = location.getZ();
					pitch = location.getPitch();
					yaw = location.getYaw();
					
					world = location.getWorld().getName();
					
					spawnconfig.set("spawn.x", x);
					spawnconfig.set("spawn.y", y);
					spawnconfig.set("spawn.z", z);
					spawnconfig.set("spawn.pitch", pitch);
					spawnconfig.set("spawn.yaw", yaw);
					spawnconfig.set("spawn.world", world);
				
					try {
						spawnconfig.save(spawn);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					sender.sendMessage(ChatColor.RED+"You don't have permission to perform that command!");
				}
			} else {
				sender.sendMessage(ChatColor.AQUA+"Console can't perform that command!");
			}
			return true;
		}
		return false;
	}
	
	

}
