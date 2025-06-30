package dev.jensderuiter.minecraft_ducks.duck;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


/**
 * DuckPart that functions as a seat for a player.
 */
public class DuckSeat extends DuckPart {

    private ArmorStand armorStand;

    public DuckSeat(Location spawnLocation) {
        super(
                new Offset(0, 0, 0, 0, 0, 0),
                new Offset(0, 0, 0, 0, 0, 0),
                null,
                Material.AIR,
                null
        );

        this.armorStand = (ArmorStand) spawnLocation.getWorld().spawnEntity(spawnLocation.getWorld().getSpawnLocation(), EntityType.ARMOR_STAND);
        this.armorStand.setAI(false);
        this.armorStand.setGravity(true);
        this.armorStand.setSmall(true);
        this.armorStand.setVisible(false);
        this.armorStand.setMarker(false);
        this.armorStand.setCustomName("duck_seat");
    }

    public void move(Location location) {
        location = location.clone();
        location.setY(location.getY() - 0.8);
        Vector velocity = location.clone()
                .subtract(this.armorStand.getLocation())
                .multiply(0.25) // because it's ran every 4 ticks
                .toVector();
        this.armorStand.setVelocity(velocity);
        this.armorStand.teleport(location);
    }

    public boolean take(Player player) {
        if (this.armorStand.getPassengers().stream().anyMatch(p -> player.isOnline())) return false;
        this.armorStand.addPassenger(player);
        return true;
    }

    public void remove() {
        super.remove();


    }

}
