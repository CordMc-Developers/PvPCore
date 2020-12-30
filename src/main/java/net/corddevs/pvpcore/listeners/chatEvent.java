package net.corddevs.pvpcore.listeners;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(Bukkit.getPluginManager().isPluginEnabled("LuckPerms")) {
            e.setFormat(Utils.chat("&8[&a" + Main.data.playerXpGetter(e.getPlayer().getUniqueId()) + "&8] "
                    + Utils.getPrefix(e.getPlayer().getUniqueId()) + "&f " + e.getPlayer().getName() + " &8» &f"
                    + e.getMessage()));
        } else {
            e.setFormat(Utils.chat("&8[&a" + Main.data.playerXpGetter(e.getPlayer().getUniqueId()) + "&8] "
                    + "&8&l<&4&lERROR&8&l>" + "&f " + e.getPlayer().getName() + " &8» &f"
                    + e.getMessage()));
        }
    }
}
