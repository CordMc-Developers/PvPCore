package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Scoreboard.ScoreBoard2;
import net.corddevs.pvpcore.Scoreboard.ScoreBoard3;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ScoreBoardEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        ScoreBoard2.getPlayers().put(e.getPlayer().getUniqueId(), new ScoreBoard3(e.getPlayer().getName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        ScoreBoard2.getPlayers().remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        ScoreBoard2.getPlayers().remove(e.getPlayer().getUniqueId());
    }
}