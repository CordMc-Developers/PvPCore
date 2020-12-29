package net.corddevs.pvpcore.sql;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private String enabled = Main.getInstance().getConfig().getString("MySQL.enabled");
    private String host = Main.getInstance().getConfig().getString("MySQL.host");
    private int port = Main.getInstance().getConfig().getInt("MySQL.port");
    private String username = Main.getInstance().getConfig().getString("MySQL.username");
    private String pw = Main.getInstance().getConfig().getString("MySQl.pw");
    private String database = Main.getInstance().getConfig().getString("MySQL.database");
    private Connection connection;

    public boolean isConnected() {
        return(connection != null);
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                Bukkit.getConsoleSender()
                        .sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
                Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lAN FATAL ERROR OCCURRED WHILE TRYING TO CLOSE MYSQL CONNECTION"));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lYOU SHOULDN'T GET AN ERROR LIKE THIS!"));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lCONTACT THE DEVELOPERS IF YOU DON'T KNOW HOW TO FIX THIS"));
                Bukkit.getConsoleSender()
                        .sendMessage(Utils.chat("&3*" + e));
                Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
                Bukkit.getConsoleSender()
                        .sendMessage(Utils.chat("&3* Version: &b" + Main.getInstance().getDescription().getVersion() + "&7."));
                Bukkit.getConsoleSender()
                        .sendMessage(Utils.chat("&3* Author(s): &b" + Main.getInstance().getDescription().getAuthors() + "&7."));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* MYSQL ERROR CODE: &C&L4430&7."));
                Bukkit.getConsoleSender()
                        .sendMessage(Utils.chat("&7&m---------------------------------------------------"));
            }
        }
    }

    public void connect() throws SQLException {
        if(Main.getInstance().getConfig().getString("MySQL.enabled").equals("false")) {
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&WARNING MYSQL DATABASE IS DISABLED BY DEFAULT"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&lIF YOU WANT TO USE MYSQL (RECOMMENDED) ENABLE IT IN THE CONFIG.YML"));
            Bukkit.getConsoleSender().sendMessage(Utils.chat("&7&m---------------------------------------------------"));
        } else {
            if(!isConnected()) {
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&7&m---------------------&f &3&lPVPCORE &7&m---------------------"));
                Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&3* &c&CONNECTING TO MYSQL DATABASE PLEASE WAIT..."));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&b"));
                Bukkit.getConsoleSender().sendMessage(Utils.chat("&7&m---------------------------------------------------"));
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, pw);
            }
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
