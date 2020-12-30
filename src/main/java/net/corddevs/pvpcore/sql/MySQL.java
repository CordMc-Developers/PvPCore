package net.corddevs.pvpcore.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.corddevs.pvpcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class MySQL {

    Plugin plugin = Main.getPlugin(Main.class);
    private final String host = plugin.getConfig().getString("host");
    private final int port = plugin.getConfig().getInt("port");
    private final String database = plugin.getConfig().getString("database");
    private final String username = plugin.getConfig().getString("username");
    private final String password = plugin.getConfig().getString("password");

    private Connection connection;

    public boolean isConnected() {
        return (connection != null);
    }

    public void connect() throws SQLException {
        if (!isConnected()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "CONNECTING TO MYSQL DATABASE PLEASE WAIT....");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
