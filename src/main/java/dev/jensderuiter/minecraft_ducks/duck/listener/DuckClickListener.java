package dev.jensderuiter.minecraft_ducks.duck.listener;

import dev.jensderuiter.minecraft_ducks.duck.Duck;
import dev.jensderuiter.minecraft_ducks.duck.DuckSeat;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static dev.jensderuiter.minecraft_ducks.duck.Duck.ducks;

public class DuckClickListener implements Listener {

    @EventHandler
    public void onPlayerDuckInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!(event.getRightClicked() instanceof Interaction interaction)) return;

        Duck duck = ducks.get(interaction.getEntityId());
        if (duck == null) return;

        player.sendMessage(ChatColor.YELLOW + "Quack Quack");

        // lets the player sit on the duck if there isn't a passenger already
        duck.getParts().stream()
                .filter(DuckSeat.class::isInstance)
                .findAny()
                .ifPresent(part -> {
                    // scale down the player to make sure
                    // he's about the same size as the duck
                    player.getAttribute(Attribute.SCALE).setBaseValue(0.3);

                    // this method is always called, but this doesn't mean
                    // the player is guaranteed a seat.
                    // this method only does something when the duck doesn't have a passenger
                    ((DuckSeat) part).take(player);
                });
    }
}
