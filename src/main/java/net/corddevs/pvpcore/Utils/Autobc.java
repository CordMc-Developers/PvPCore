package net.corddevs.pvpcore.Utils;

import net.corddevs.pvpcore.Main;
import org.bukkit.Bukkit;

public class Autobc {
    public static void onEnable() {

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(Main.class), new Runnable() {

            @Override
            public synchronized void run() {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(Utils.chat("&7Join our Discord at &bdiscord.cordmc.net&7."));
                Bukkit.broadcastMessage("");
            }

        }, 0, 2160);
    }
}