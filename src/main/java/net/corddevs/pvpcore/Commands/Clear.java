package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("cord.staff")) {
                if(args.length != 0) {
                    Player  target = Bukkit.getPlayer(args[0]);
                    if(target.isOnline()) {
                        target.getInventory().clear();
                        target.sendMessage(Utils.chat(Main.prefix + " You're inventory has been cleared by " + p.getName()));
                        p.sendMessage(Utils.chat(Main.prefix + " You've cleared " + target.getName() + " inventory"));
                    } else {
                        p.sendMessage(Utils.chat(Main.prefix + " Player is not online!"));
                    }
                } else {
                    p.getInventory().clear();
                    p.sendMessage(Utils.chat(" You've cleared your own inventory"));
                }
            } else {
                p.sendMessage(Utils.chat(Main.prefix + " you don't have permission for this command"));
            }
        }
        return true;
    }
}
