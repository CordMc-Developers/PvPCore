package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class vanish implements CommandExecutor {

    private static List<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }


        Player player = (Player) sender;

        if(player.hasPermission("cord.staff")) {
            if(args.length != 0) {
                player.sendMessage(Utils.chat(Main.prefix + " Invalid args"));
            } else {
                if(vanished.contains(player)) {
                    vanished.remove(player);
                    player.sendMessage(Utils.chat(Main.prefix + " Vanish disabled"));
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.showPlayer(player);
                    }
                } else {
                    vanished.add(player);
                    player.sendMessage(Utils.chat(Main.prefix + " vanished enabled"));
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        if(all.hasPermission("cord.*") || all.hasPermission("cord.staff.bypass")) {
                            all.showPlayer(player);
                        } else {
                            all.hidePlayer(player);
                        }
                    }
                }
            }
        } else {
            player.sendMessage(Utils.chat(Main.prefix + " You don't have permission to execute this command!"));
        }
        return true;
    }
}