package net.bingomc.spring_lobby_2025.quest.duck;

import net.bingomc.spring_lobby_2025.LobbyPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class DuckSeat extends DuckPart {

    private ArmorStand armorStand;

    public DuckSeat() {
        super(
                new Offset(0, 0, 0, 0, 0, 0),
                new Offset(0, 0, 0, 0, 0, 0),
                null,
                Material.AIR,
                null
        );

        this.armorStand = (ArmorStand) LobbyPlugin.getWorld().spawnEntity(LobbyPlugin.getWorld().getSpawnLocation(), EntityType.ARMOR_STAND);
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
