package net.corddevs.pvpcore.Kits;

import net.corddevs.pvpcore.Main;
import net.corddevs.pvpcore.Utils.Config;
import net.corddevs.pvpcore.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Resetcooldowns implements CommandExecutor, Listener {
    public Resetcooldowns() {
        Main.getPlugin(Main.class).getCommand("resetcooldowns").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
        }
        Player p = (Player) sender;
        p.sendMessage(Utils.chat(Main.prefix + "Clearing you from all cooldowns!"));
        Config.KitSpecialCooldownTime.remove(p.getUniqueId());
        Config.KitHeroCooldownTime.remove(p.getUniqueId());
        Config.KitZeusCooldownTime.remove(p.getUniqueId());
        Config.KitEternalCooldownTime.remove(p.getUniqueId());
        Config.KitImmortalCooldownTime.remove(p.getUniqueId());
        Config.KitLegendCooldownTime.remove(p.getUniqueId());
        return false;
    }
}