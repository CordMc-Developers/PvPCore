package net.corddevs.pvpcore;

import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceHolderAPI")) {
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* Version: &b" + getDescription().getVersion() + "&7."));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* Author(s): &b" + getDescription().getAuthors() + "&7."));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* Plugin Status: &bLoaded."));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        } else {
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lTHIS PLUGIN NEEDS PLACEHOLDERAPI IN ORDER TO WORK"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lPLEASE INSTALL PLACEHOLDERAPI"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lYOU CAN INSTALL IT AT THE LINK BELOW"));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* &3https://www.spigotmc.org/resources/placeholderapi.6245"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* Version: &b" + getDescription().getVersion() + "&7."));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* Author(s): &b" + getDescription().getAuthors() + "&7."));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* Plugin Status: &aLoaded&7."));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
