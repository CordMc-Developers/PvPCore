package net.corddevs.pvpcore;

import net.corddevs.pvpcore.Commands.*;
import net.corddevs.pvpcore.Kits.Kits;
import net.corddevs.pvpcore.Kits.Resetcooldowns;
import net.corddevs.pvpcore.Scoreboard.ScoreBoard2;
import net.corddevs.pvpcore.Utils.Autobc;
import net.corddevs.pvpcore.Utils.Utils;
import net.corddevs.pvpcore.listeners.*;
import net.corddevs.pvpcore.sql.MySQL;
import net.corddevs.pvpcore.sql.SQLGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

//import net.corddevs.pvpcore.Commands.dm;
//import net.corddevs.pvpcore.Commands.dr;

public class Main extends JavaPlugin {
    public static MySQL SQL;
    public static SQLGetter data;
    public static String prefix = Utils.chat("&3&lCORD&B&LMC &7");
    public FileConfiguration config = getConfig();

    @SuppressWarnings("static-access")
    @Override
    public void onEnable() {
        if (!Bukkit.getPluginManager().isPluginEnabled("PlaceHolderAPI")) {
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
        data = new SQLGetter(this);

        try {
            SQL.connect();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "MYSQL DATABASE FAILED TO CONNECT!!!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + String.valueOf(e));
        }

        if (SQL.isConnected()) {
            data.createTable();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL DATABASE CONNECTED SUCCESSFULLY");
        }

        ScoreBoard2.onEnable();
        Autobc.onEnable();
        new Kits();
        new Resetcooldowns();

        // Load Events
        getServer().getPluginManager().registerEvents(new Kits(), this);
        getServer().getPluginManager().registerEvents(new CombatLog(), this);
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onQuit(), this);
        getServer().getPluginManager().registerEvents(new chatEvent(), this);
        getServer().getPluginManager().registerEvents(new onDeath(), this);
        getServer().getPluginManager().registerEvents(new ScoreBoardEvents(), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);


        //commands
        getCommand("clear").setExecutor(new Clear());
        getCommand("tp").setExecutor(new tp());
        getCommand("gamemode").setExecutor(new gamemode());
        getCommand("tphere").setExecutor(new tphere());
        getCommand("freeze").setExecutor(new freeze());
        getCommand("fly").setExecutor(new fly());
        getCommand("staff").setExecutor(new StaffMode());
        getCommand("vanish").setExecutor(new vanish());
        getCommand("setspawn").setExecutor(new setspawn());
        getCommand("spawn").setExecutor(new spawn());
        /*
        getCommand("dm").setExecutor(new dm());
        getCommand("d4").setExecutor(new dr());
        */
    }

    public void loadConfig() {
        config.options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SQL.disconnect();
    }

}
