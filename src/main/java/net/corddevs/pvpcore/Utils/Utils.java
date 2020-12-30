package net.corddevs.pvpcore.Utils;

import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;


import java.io.File;
import java.util.UUID;

public class Utils {
    private static File file;
    private static FileConfiguration config;

    public static String chat(String args) {
        return ChatColor.translateAlternateColorCodes('&', args);
    }


    public static String getPrefix(UUID uuid) {
        String prefix = LuckPermsProvider.get().getGroupManager().getGroup(LuckPermsProvider.get().getUserManager().getUser(uuid).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
        return prefix;
    }

    /*
    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PvPCore").getDataFolder(), "config.yml")
    }

     */
}