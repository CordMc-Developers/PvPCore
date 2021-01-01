package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class fly implements CommandExecutor {


    private static List<Player> isFly = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("cord.staff")) {
            if(args.length != 0) {
                p.sendMessage(Utils.chat(Main.prefix + " Invalid args"));
            } else {
                if(isFly.contains(p)) {
                    p.setAllowFlight(false);
                    p.sendMessage(Utils.chat(Main.prefix + " Fly disabled!"));
                } else {
                    isFly.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(Utils.chat(Main.prefix + " Fly enabled..."));
                }
            }
        } else {
            p.sendMessage(Utils.chat(Main.prefix + " No permissions"));
        }
        return true;
    }
}
