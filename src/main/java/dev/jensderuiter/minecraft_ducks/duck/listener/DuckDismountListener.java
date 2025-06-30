package dev.jensderuiter.minecraft_ducks.duck.listener;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDismountEvent;

public class DuckDismountListener implements Listener {

    @EventHandler
    public void onPlayerDuckDismount(EntityDismountEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        if (event.getDismounted().getCustomName() != null && event.getDismounted().getCustomName().equals("duck_seat")) {
            player.getAttribute(Attribute.SCALE).setBaseValue(1);
        }
    }
}
