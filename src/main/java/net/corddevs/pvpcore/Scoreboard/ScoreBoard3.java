package net.corddevs.pvpcore.Scoreboard;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class ScoreBoard3 {
    private final String player;
    private final ScoreBoard1 sb;
    public Player p;

    public ScoreBoard3(String player) {
        this.player = player;
        p = Bukkit.getPlayer(player);
        this.sb = new ScoreBoard1();
        sb.setSlot(DisplaySlot.SIDEBAR);
        sb.setName(Utils.chat("&4&lERROR"));
        sb.addLine(8, Utils.chat("&4&lERROR"));
        sb.addLine(7, Utils.chat("&4&lERROR"));
        sb.addLine(6, Utils.chat("&4&lERROR"));
        sb.addLine(5, Utils.chat("&4&lERROR"));
        sb.addLine(4, Utils.chat("&4&lERROR"));
        sb.addLine(3, Utils.chat("&4&lERROR"));
        sb.addLine(2, Utils.chat("&4&lERROR"));
        sb.addLine(1, Utils.chat("&4&lERROR"));
    }

    public synchronized void updateScoreboard(Player p) {
        if (!(sb.hasBoard(getPlayer()))) {
            sb.setForPlayer(getPlayer());
        }
        sb.setName(Utils.chat("&c&lPVP"));
        sb.updateLine(9, Utils.chat("&8&m-------------------"));
        sb.updateLine(8, Utils.chat("&b" + p.getName() + "&8:"));
        sb.updateLine(7, Utils.chat("  &8» &7EXP: &f" + Main.data.playerXpGetter(p.getUniqueId())));
        sb.updateLine(6, Utils.chat("  &8» &7Deaths: &f" + Main.data.playerDeathGetter(p.getUniqueId())));
        sb.updateLine(5, Utils.chat("  &8» &7Kills: &f" + Main.data.playerKillGetter(p.getUniqueId())));
        sb.updateLine(4, Utils.chat("  &8» &7KDR" + " &fComing soon"));
        sb.updateLine(3, Utils.chat("  &8» &7"));
        sb.updateLine(2, Utils.chat("  &8» &3play.cordmc.net"));
        sb.updateLine(1, Utils.chat("&8&m-------------------"));
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(player);
    }
}