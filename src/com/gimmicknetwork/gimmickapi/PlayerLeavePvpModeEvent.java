package com.gimmicknetwork.gimmickapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
 
public final class PlayerLeavePvpModeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private String newPvpMode;
    private String oldPvpMode;
    private Player player;
 
    public PlayerLeavePvpModeEvent(Player player, String newPvpMode, String oldPvpMode) {
    	this.player = player;
        this.newPvpMode = newPvpMode;
        this.oldPvpMode = oldPvpMode;
    }
 
    public Player getPlayer() {
        return player;
    }
    
    public String getNewPvpMode() {
    	return newPvpMode;
    }
    
    public String getOldPvpMode() {
    	return oldPvpMode;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
