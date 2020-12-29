package net.corddevs.pvpcore;

import net.corddevs.pvpcore.Utils.Utils;
import net.corddevs.pvpcore.sql.MySQL;
import net.corddevs.pvpcore.sql.SQLGetter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static MySQL SQL;
    public static SQLGetter data;
    public FileConfiguration config = getConfig();


    @Override
    public void onEnable() {
        instance = this;
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

        this.SQL = new MySQL();
        data = new SQLGetter();

        try {
            SQL.connect();
        } catch (SQLException e) {
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lAN FATAL ERROR OCCURRED WHILE TRYING TO CONNECT TO MYSQL"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lPLEASE CONTACT THE DEVELOPERS TO FIX THIS"));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3*" + e));
            Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&3* Author(s): &b" + getDescription().getAuthors() + "&7."));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* MYSQL ERROR CODE: &C&3322&7."));
            Bukkit.getConsoleSender()
                    .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        }
    }

    @Override
    public void onDisable() {
        if(SQL.isConnected()) {
            SQL.disconnect();
        } else {
            try {
                throw new SQLException(Utils.chat("&C&LMYSQL DATABASE ISN'T CONNECTED!"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public void loadConfig() {
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&3* Version: &b" + getDescription().getVersion() + "&7."));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&3* Author(s): &b" + getDescription().getAuthors() + "&7."));
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* Plugin Status: &bConfig has loaded."));
        Bukkit.getConsoleSender()
                .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        config.options().copyDefaults();
        saveDefaultConfig();
    }
}
