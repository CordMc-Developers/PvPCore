package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class CombatLog implements Listener {
    int ctt = 5;
    public static ArrayList<UUID> CombatLog = new ArrayList<UUID>();
    public static ArrayList<UUID> KillOnJoin = new ArrayList<UUID>();

    @EventHandler
    public void onEntityDamageEvent(EntityDamageByEntityEvent e) {
        Player damager = (Player) e.getEntity();
        Player hitter = (Player) e.getDamager();
        if (CombatLog.contains(damager.getUniqueId())) {
            damager.sendMessage(Utils
                    .chat("&b&lCORD&3&lMC &7You are now in combat for &c&n" + ctt + " seconds&7, do not log out!"));
            CombatLog.add(damager.getUniqueId());
        }
        if (CombatLog.contains(hitter.getUniqueId())) {
            hitter.sendMessage(Utils
                    .chat("&b&lCORD&3&lMC &7You are now in combat for &c&n" + ctt + " seconds&7, do not log out!"));
            CombatLog.add(hitter.getUniqueId());
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                CombatLog.remove(damager.getUniqueId());
                CombatLog.remove(hitter.getUniqueId());
                hitter.sendMessage(Utils.chat("&b&lCORD&3&lMC &7You are no longer in combet"));
                damager.sendMessage(Utils.chat("&b&lCORD&3&lMC &7You are no longer in combet"));
            }
        }.runTaskLater(Main.getPlugin(Main.class), ctt * 20);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (CombatLog.contains(p.getUniqueId())) {
            KillOnJoin.add(p.getUniqueId());
            Bukkit.broadcastMessage(Utils.chat("&b&lCORD&3&lMC &c" + p.getName() + " &7Logged out in combat!"));
            CombatLog.remove(p.getUniqueId());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (KillOnJoin.contains(p.getUniqueId())) {
            p.sendMessage(Utils.chat(""));
            p.sendMessage(Utils.chat("&b&lCORD&3&lMC &7You logged out and were killed..."));
            p.sendMessage(Utils.chat(""));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill " + p.getName());
            CombatLog.remove(p.getUniqueId());
        }
    }
}
