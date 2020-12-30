package net.corddevs.pvpcore.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import net.corddevs.pvpcore.Main;
import org.bukkit.entity.Player;
public class SQLGetter {

    private Main plugin;

    public SQLGetter(Main plugin) {
        this.plugin = plugin;
    }


    public void createTable() {
        PreparedStatement ps;
        try {
            ps = Main.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS user_data (NAME VARCHAR(100),UUID VARCHAR(100),IP VARCHAR(100),KILLS INT(100),DEATH INT(100),XP INT(100),WHITELISTED BOOLEAN,PRIMARY KEY (Name))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createPlayer(UUID uuid, Player player) {
        try {
            PreparedStatement ps2 = Main.SQL.getConnection().prepareStatement("INSERT IGNORE INTO user_data (NAME,UUID,KILLS,DEATH,WHITELISTED,XP) VALUES (?,?,?,?,?,?)");
            ps2.setString(1, player.getName());
            ps2.setString(2, uuid.toString());
            ps2.setInt(3,0);
            ps2.setInt(4, 0);
            ps2.setBoolean(5, false);
            ps2.setInt(6, 0);
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean playerExist(UUID uuid) {
        try {
            PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean playerNameExist(String name) {
        try {
            PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE NAME=?");
            ps.setString(1, name);
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @SuppressWarnings("static-access")
    public Integer playerDeathGetter(UUID uuid) {
        int i = 0;

        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                i = results.getInt("DEATH");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @SuppressWarnings("static-access")
    public void playerDeathSetter(UUID uuid, Integer deaths) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE user_data SET DEATH=? WHERE UUID=?");
            ps.setInt(1, deaths);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void playerDeathUpdate(UUID uuid, Integer deaths) {
        playerDeathSetter(uuid, playerDeathGetter(uuid) + deaths);
    }


    @SuppressWarnings("static-access")
    public Integer playerKillGetter(UUID uuid) {
        int i = 0;
        try {
            PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                i = results.getInt("KILLS");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @SuppressWarnings("static-access")
    public void playerKillSetter(UUID uuid, Integer kills) {
        try {
            PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE user_data SET KILLS=? WHERE UUID=?");
            ps.setInt(1, kills);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void playerKillUpdate(UUID uuid, Integer kills) {
        playerKillSetter(uuid, playerKillGetter(uuid) + kills);
    }


    @SuppressWarnings("static-access")
    public Integer playerXpGetter(UUID uuid) {
        int i = 0;
        try {
            PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                i = results.getInt("XP");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @SuppressWarnings("static-access")
    public void playerXpSetter(UUID uuid, Integer xp) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE user_data SET XP=? WHERE UUID=?");
            ps.setInt(1, xp);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void playerXpUpdate(UUID uuid, Integer xp) {
        playerKillSetter(uuid, playerKillGetter(uuid) + xp);
    }

    @SuppressWarnings("static-access")
    public Boolean isWhitelistGetter(String name) {
        boolean b = false;
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM user_data WHERE NAME=?");
            ps.setString(1, name);
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                b = results.getBoolean("WHITELISTED");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @SuppressWarnings("static-access")
    public void isWhitelistSetter(String name, boolean b) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE user_data SET WHITELISTED=? WHERE NAME=?");
            ps.setBoolean(1, b);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
