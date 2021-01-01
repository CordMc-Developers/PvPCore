package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Commands.freeze;
import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {


    @EventHandler
    public void MoveEvent(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if(freeze.freezed.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Utils.chat(Main.prefix + " You have been frozen by a staff member and cannot move.."));
        } else {
            e.setCancelled(false);
        }
    }
}
