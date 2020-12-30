package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(Main.SQL.isConnected()) {
            e.setJoinMessage(null);
            e.getPlayer().sendMessage(Utils.chat("&7&m------------------------------------"));
            e.getPlayer().sendMessage(Utils.chat("&7"));
            e.getPlayer().sendMessage(Utils.chat("&7Welcome to &c&lPVP &f" + e.getPlayer().getName()));
            e.getPlayer().sendMessage(Utils.chat("&7"));
            e.getPlayer().sendMessage(Utils.chat("&7&m------------------------------------"));
        } else {
            p.kickPlayer(Utils.chat("&cMySQL failed to connect... Check the console for errors"));
        }
    }
}
