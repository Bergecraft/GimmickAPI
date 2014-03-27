package com.gimmicknetwork.gimmickapi;

import java.util.HashMap;

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
		pvpModes.put(player, pvpMode);
	}
	
	public static String getPvpModeForPlayer(Player player) {
		if (pvpModes.containsKey(player)) {
			return pvpModes.get(player);
		} else {
			return defaultPvpMode;
		}
	}
}
