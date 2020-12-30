package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class onDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        if(e.getEntityType() == EntityType.PLAYER) {
            Player victim = (Player) e.getEntity();
            Player killer = (Player) victim.getKiller();
            if(killer != null) {
                Main.data.playerKillUpdate(killer.getUniqueId(),+1);
                Main.data.playerDeathUpdate(victim.getUniqueId(), +1);
                int i = new Random().nextInt(10);
                Main.data.playerXpSetter(killer.getUniqueId(), Main.data.playerXpGetter(killer.getUniqueId()) + i);
                int KillersHealth = (int) killer.getHealth();
                victim.sendMessage(Utils.chat("&7Killed by " + killer.getName() + " (&f" + KillersHealth / 2 + "&c❤&7)"));
                killer.sendMessage(Utils.chat("&7You killed " + victim.getName() + "&fAnd earned: " + i + " XP"));
            }
        }
    }
}
