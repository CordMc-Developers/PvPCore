package net.corddevs.pvpcore.Scoreboard;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.corddevs.pvpcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class ScoreBoard2 {

    private static ConcurrentHashMap<UUID, ScoreBoard3> players = new ConcurrentHashMap<UUID, ScoreBoard3>();

    public static ConcurrentHashMap<UUID, ScoreBoard3> getPlayers() {
        return players;
    }

    public static void onEnable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            players.put(p.getUniqueId(), new ScoreBoard3(p.getName()));
            p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(Main.class), new Runnable() {

            @Override
            public synchronized void run() {
                for (ScoreBoard3 player : players.values()) {
                    player.updateScoreboard(player.getPlayer());
                }
            }

        }, 0, 1);
    }
}