package com.gimmicknetwork.gimmickapi;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GimmickAPI extends JavaPlugin {
	
	private static HashMap<Player, String> pvpModes = new HashMap<Player, String>();
	private static String defaultPvpMode = "vanilla";
	
	public void onEnable() {
		this.saveDefaultConfig();
		defaultPvpMode = this.getConfig().getString("pvp.default", "vanilla");
	}
	
	public void onDisable() { }
	
	public static void setPvpModeForPlayer(Player player, String pvpMode) {
		String oldPvpMode = getPvpModeForPlayer(player);
		pvpModes.put(player, pvpMode);
		//call event to let plugins know the player changed mode
		PlayerLeavePvpModeEvent leaveEvent = new PlayerLeavePvpModeEvent(player, pvpMode, oldPvpMode);
		PlayerJoinPvpModeEvent joinEvent = new PlayerJoinPvpModeEvent(player, pvpMode, oldPvpMode);
		Bukkit.getServer().getPluginManager().callEvent(leaveEvent);
		Bukkit.getServer().getPluginManager().callEvent(joinEvent);
		
		
	}
	
	public static String getPvpModeForPlayer(Player player) {
		if (pvpModes.containsKey(player)) {
			return pvpModes.get(player);
		} else {
			return defaultPvpMode;
		}
	}
}
