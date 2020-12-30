package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("cordmc.staff")) {
            if(args.length == 0) {
                p.sendMessage(Utils.chat(Main.prefix + " Invalid args"));
            } else {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target.isOnline()) {
                        p.teleport(target.getLocation());
                    } else {
                        p.sendMessage(Utils.chat(Main.prefix + " Player is not online!!"));
                    }
                } else {
                    if(args.length == 2) {
                        Player target = Bukkit.getPlayer(args[1]);
                        Player tosend = Bukkit.getPlayer(args[0]);
                        if(target.isOnline()) {
                            if(tosend.isOnline()) {
                                tosend.teleport(target.getLocation());
                            } else {
                                p.sendMessage(Utils.chat(Main.prefix + " Insufficient player"));
                            }
                        } else {
                            p.sendMessage(Utils.chat(Main.prefix + " Insufficient player"));
                        }
                    }
                }
            }
        } else {
            p.sendMessage(Utils.chat(Main.prefix + " No permissions"));
        }
        return true;
    }
}
