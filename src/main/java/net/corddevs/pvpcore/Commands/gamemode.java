package net.corddevs.pvpcore.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static net.corddevs.pvpcore.Utils.Utils.chat;
import static net.corddevs.pvpcore.Utils.Utils.getPrefix;
import static net.corddevs.pvpcore.Main.prefix;

public class gamemode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("cord.staff")) {
            if(args.length == 0) {
                return true;
            } else {
                switch (args[0]) {
                    case "s":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(chat(prefix + " set your gamemode to survival"));
                        break;
                    case "c":
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(chat(prefix + " set your gamemode to creative"));
                        break;
                    case "sp":
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(chat(prefix + " set your gamemode to spectator"));
                        break;
                }
            }
        }
        return true;
    }
}
