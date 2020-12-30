package net.corddevs.pvpcore.Scoreboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.base.Splitter;

public class ScoreBoard1 {

    public static final String objective = "NoFlicker";
    private Scoreboard scoreboard;
    private ConcurrentHashMap<Integer, String> storedLines = new ConcurrentHashMap<Integer, String>();
    private Team[] teams;
    private List<ChatColor> chatMap;

    public ScoreBoard1() {
        scoreboard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        scoreboard.registerNewObjective(objective, "dummy");
        teams = new Team[16];

        chatMap = new ArrayList<>();

        for(ChatColor c : ChatColor.values()) {
            if(chatMap.size() + 1 > 15) {
                break;
            }
            chatMap.add(c);
        }
    }

    public boolean hasLine(int lineID) {
        return storedLines.get(lineID) != null;
    }

    public void setSlot(DisplaySlot slot) {
        scoreboard.getObjective(objective).setDisplaySlot(slot);
    }

    public void setName(String name) {
        scoreboard.getObjective(objective).setDisplayName(name);
    }

    public String getName() {
        return scoreboard.getObjective(objective).getName();
    }

    private String fixDuplicates(String text) {
        while(storedLines.contains(text)) {
            text += "§r";
        }
        return text;
    }

    public void addLine(int scoreValue, String name) {
        name = fixDuplicates(name);
        teams[scoreValue] = scoreboard.registerNewTeam(String.valueOf(scoreValue));
        int r = new Random().nextInt(chatMap.size());
        String idd = chatMap.get(r).toString();
        teams[scoreValue].addEntry(idd);
        storedLines.put(scoreValue, idd);
        scoreboard.getObjective(objective).getScore(idd).setScore(scoreValue);

        Iterator<String> iterator = Splitter.fixedLength(16).split(name).iterator();
        String prefix = iterator.next();
        boolean shouldInsert = name.length() >= 16 && prefix.charAt(15) == ChatColor.COLOR_CHAR;

        if(shouldInsert) {
            prefix = prefix.substring(0, 15);
        }

        teams[scoreValue].setPrefix(prefix);
        String chatcolor = ChatColor.getLastColors(prefix);

        if(name.length() > 16) {
            String suffix = iterator.next();

            if(shouldInsert) {
                suffix = "§" + suffix;
            } else {
                suffix = chatcolor + suffix;
            }

            if(suffix.length() > 16) {
                suffix = suffix.substring(0, 16);
            }

            teams[scoreValue].setSuffix(suffix);
        }
        chatMap.remove(r);
    }

    public void removeLine(int id) {
        if(!(hasLine(id))) {
            return;
        }
        teams[id].unregister();
        teams[id] = null;
        String idd = storedLines.get(id);
        scoreboard.resetScores(idd);
        storedLines.remove(id);
    }

    public void blankLine(int id) {
        if(!(hasLine(id))) {
            addLine(id, " ");
        }
    }

    public void updateLine(int id, String newName) {
        if(!(hasLine(id))) {
            return;
        }

        newName = fixDuplicates(newName);
        Iterator<String> iterator = Splitter.fixedLength(16).split(newName).iterator();
        String prefix = iterator.next();

        boolean shouldInsert = newName.length() >= 16 && prefix.charAt(15) == ChatColor.COLOR_CHAR;

        if(shouldInsert) {
            prefix = prefix.substring(0, 15);
        }

        teams[id].setPrefix(prefix);
        String chatcolor = ChatColor.getLastColors(prefix);

        if(newName.length() > 16) {
            String suffix = iterator.next();

            if(shouldInsert) {
                suffix = "§" + suffix;
            } else {
                suffix = chatcolor + suffix;
            }

            if(suffix.length() > 16) {
                suffix = suffix.substring(0, 16);
            }

            teams[id].setSuffix(suffix);
        } else {
            teams[id].setSuffix(" ");
        }
    }

    public String getLine(int id) {
        return teams[id].getPrefix() + teams[id].getSuffix();
    }

    public boolean hasBoard(Player player) {
        return player.getScoreboard().getObjective(objective) != null;
    }

    public void setForPlayer(Player player) {
        player.setScoreboard(scoreboard);
    }

}
