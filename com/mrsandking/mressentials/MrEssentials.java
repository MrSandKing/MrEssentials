package com.mrsandking.mressentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.mrsandking.mressentials.cmds.DEOP;
import com.mrsandking.mressentials.cmds.Fly;
import com.mrsandking.mressentials.cmds.Kick;
import com.mrsandking.mressentials.cmds.OP;
import com.mrsandking.mressentials.cmds.TPHere;
import com.mrsandking.mressentials.cmds.Trash;
import com.mrsandking.mressentials.listeners.ProtectedWorlds;
import com.mrsandking.mressentials.utils.KitUtils;
import com.mrsandking.mressentials.utils.ProtectedWorldsUtils;

import net.md_5.bungee.api.ChatColor;

public class MrEssentials extends JavaPlugin {

	private static MrEssentials instance;
	private static List<String> list = ProtectedWorldsUtils.getProtectedWorlds();
	
	public void onEnable() {
    
		saveDefaultConfig();	
		reloadConfig();
		saveConfig();
		KitUtils.loadKits();
		Trash.createTrash();
		
		if(getConfig().getBoolean("protect-world") == true) {
			ProtectedWorldsUtils.setProtect(true);
			//ProtectedWorldsUtils.getProtectedWorlds().add(getConfig().getStringList("protected-worlds"));
			List<String> protectedlist = getConfig().getStringList("protected-worlds");
			setList(protectedlist);
			//ProtectedWorldsUtils.loadProtectedWorlds();
			sendInfo("Protect Worlds - enabled");
		} else if(getConfig().getBoolean("protect-world") == false){
			ProtectedWorldsUtils.setProtect(false);
			sendInfo("Protect Worlds - disabled");
		}
		
		//List<String> blcm = getConfig().getStringList("blocked-cmds");
		//setBlockedcmds(blcm);
		
		/*ProtectedWorldsUtils.loadProtectedWorlds();
		
		ConfigManager.loadConfig();
		
		ConfigManager.saveConfig();
		ConfigManager.saveMessages();*/
		
		getServer().getPluginManager().registerEvents(new ProtectedWorlds(), this);
		//getServer().getPluginManager().registerEvents(new BlockedCommands(), this);
		
		getCommand("trash").setExecutor(new Trash());
		getCommand("kick").setExecutor(new Kick());
		getCommand("fly").setExecutor(new Fly());
		getCommand("tphere").setExecutor(new TPHere());
		getCommand("op").setExecutor(new OP());
		getCommand("deop").setExecutor(new DEOP());
	}
	
	public static MrEssentials getInstance() {
		return instance;
	}

	public void sendInfo(String message) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+message);
	}

	public static List<String> getList() {
		return list;
	}

	public static void setList(List<String> list) {
		MrEssentials.list = list;
	}
	
}
