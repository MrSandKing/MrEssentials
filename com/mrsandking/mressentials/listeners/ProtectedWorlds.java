package com.mrsandking.mressentials.listeners;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.mrsandking.mressentials.MrEssentials;
import com.mrsandking.mressentials.utils.ProtectedWorldsUtils;

import net.md_5.bungee.api.ChatColor;

public class ProtectedWorlds implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		String world = event.getBlock().getLocation().getWorld().getName();
		if(ProtectedWorldsUtils.getProtect() == true) {
			if(MrEssentials.getList().contains(world)) {
				player.sendMessage(ChatColor.RED+"You can't break block!");
				event.getBlock().getLocation().getWorld().playEffect(event.getBlock().getLocation().add(0, 1, 0), Effect.LARGE_SMOKE, 30);
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		String world = event.getBlock().getLocation().getWorld().getName();
		if(ProtectedWorldsUtils.getProtect() == true) {
			if(MrEssentials.getList().contains(world)) {
				player.sendMessage(ChatColor.RED+"You can't place block!");
				event.getBlock().getLocation().getWorld().playEffect(event.getBlock().getLocation().add(0, 1, 0), Effect.LARGE_SMOKE, 30);
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		String world = entity.getLocation().getWorld().getName();
		if(ProtectedWorldsUtils.getProtect() == true) {
			if(MrEssentials.getList().contains(world)) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		String world = event.getEntity().getLocation().getWorld().getName();
		if(ProtectedWorldsUtils.getProtect() == true) {
			if(MrEssentials.getList().contains(world)) {
				event.setCancelled(true);
			}
		}
	}
	
}
