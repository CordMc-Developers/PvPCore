package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class tphere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("cord.staff")) {
            if(args.length == 0) {
                player.sendMessage(Utils.chat(Main.prefix + " You must provide a player to teleport to you"));
            } else {
                Player tosennd = Bukkit.getPlayer(args[0]);
                if(tosennd.isOnline()) {
                    tosennd.teleport(player.getLocation());
                    tosennd.sendMessage(Utils.chat(Main.prefix + " You got teleported to " + player.getName()));
                } else {
                    player.sendMessage(Utils.chat(Main.prefix + " Player is not online!"));
                }
            }
        } else {
            player.sendMessage(Utils.chat(Main.prefix + " You don't have permissions for this command!"));
        }
        return true;
    }
}
