package net.corddevs.pvpcore.Utils;

import net.corddevs.pvpcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils {

    public static String chat(String args) {
        return ChatColor.translateAlternateColorCodes('§', args);
    }



    public static void loadConfig() {
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&3* Version: &b" + Main.getInstance().getDescription().getVersion() + "&7."));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&3* Author(s): &b" + Main.getInstance().getDescription().getAuthors() + "&7."));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* Plugin Status: &bConfig has loaded."));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        Main.getInstance().saveDefaultConfig();
    }
}
