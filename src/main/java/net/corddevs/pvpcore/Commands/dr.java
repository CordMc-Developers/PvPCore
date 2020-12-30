package net.corddevs.pvpcore.Commands;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class dr implements CommandExecutor, Listener {

    Plugin plugin = Main.getPlugin(Main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 1) {
            Player target = dm.KnownSender.get(player);
            String message = getMessage(args);
            if(target != null) {
                if(target.isOnline()) {
                    target.sendMessage(Utils.chat("&fFrom " + "&b" + Utils.getPrefix(player.getUniqueId()) + player.getName() + "&8: " + "&f" + message));
                    sender.sendMessage(Utils.chat("&fTo " + "&b" + Utils.getPrefix(target.getUniqueId()) + target.getName() + "&8: " + "&f" + message));
                } else {
                    sender.sendMessage(Utils.chat("&cSpilleren blev ikke fundet!"));
                }
            } else {
                sender.sendMessage(Utils.chat("&cIngen beskeder fundet"));
            }

        }
        return false;
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        dm.KnownSender.remove(e.getPlayer());
    }

    private static String getMessage(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}