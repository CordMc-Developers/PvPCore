package net.corddevs.pvpcore.Utils;

import net.corddevs.pvpcore.Main;
import org.bukkit.Bukkit;

public class Autobc {
    public static void onEnable() {

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(Main.class), new Runnable() {

            @Override
            public synchronized void run() {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(Utils.chat("&b&lCORD&3&lMC &7Join our Discord at &3&ndiscord.cordmc.net&7."));
                Bukkit.broadcastMessage("");
            }

        }, 0, 750);
    }
}
