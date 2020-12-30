package net.corddevs.pvpcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuit implements Listener {

    @EventHandler
    public void onQuit1(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
