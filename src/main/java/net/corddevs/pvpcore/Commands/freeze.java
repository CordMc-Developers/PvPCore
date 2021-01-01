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

public class freeze implements CommandExecutor {

    public static List<Player> freezed = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("cord.staff")) {
            if(args.length == 0) {

            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target.isOnline()) {
                    if(freezed.contains(target)) {
                        freezed.remove(target);
                        target.sendMessage(Utils.chat(Main.prefix + " You've been unfrozen, sorry for the inconvenience "));
                        player.sendMessage(Utils.chat(Main.prefix + target.getName() + " has been unfrozen.."));
                    } else {
                        freezed.add(target);
                        target.sendMessage(Utils.chat(Main.prefix + " You've been frozen, please join our discord server for a ss "));
                        player.sendMessage(Utils.chat(Main.prefix + target.getName() + " have been frozen.."));
                    }
                } else {
                    player.sendMessage(Utils.chat(Main.prefix + " You must provide an online player.."));
                }
            }
        }
        return true;
    }
}
