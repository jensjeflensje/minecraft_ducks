package dev.jensderuiter.minecraft_ducks.duck;

import dev.jensderuiter.minecraft_ducks.duck.animation.Moveable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.joml.Quaternionfc;

/**
 * A part of a Duck that's able to move around
 * the center-location of the Duck by using its Offset.
 */
@Getter
@Builder
public class DuckPart implements Moveable {

    private Offset offset;

    @Setter
    private Offset animationOffset;

    private Quaternionfc rotation;

    private Material material;

    private ItemDisplay display;

    public void summon(Location location) {
        this.animationOffset = new Offset(0, 0, 0, 0, 0, 1);

        if (display == null) {
            display = (ItemDisplay) location.getWorld()
                    .spawnEntity(location.clone().add(this.offset.toVector()), EntityType.ITEM_DISPLAY);

            ItemStack sword = new ItemStack(this.material);
            display.setItemStack(sword);
        }

        Transformation transformation = display.getTransformation();
        transformation.getScale().set(offset.size.getX(), offset.size.getY(), offset.size.getZ());
        if (rotation != null) transformation.getLeftRotation().set(rotation);
        display.setTransformation(transformation);
    }

    public void move(Location location) {
        Location offsetLocation = location.clone();
        double sinus = Math.sin(location.getYaw() / 180 * Math.PI);
        double cosinus = Math.cos(location.getYaw() / 180 * Math.PI);
        double x = this.offset.x + this.animationOffset.x;
        double z = this.offset.z + this.animationOffset.z;
        double y = this.offset.y + this.animationOffset.y;
        float yaw = this.offset.yaw + this.animationOffset.yaw;
        float pitch = this.offset.pitch + this.animationOffset.pitch;
        double newX = x * cosinus - z * sinus;
        double newZ = z * cosinus + x * sinus;
        offsetLocation.add(newX, y, newZ);
        offsetLocation.setYaw(location.getYaw() + yaw);
        offsetLocation.setPitch(pitch);

        this.display.teleport(offsetLocation);
    }

    @Override
    public Location getLocation() {
        return this.display.getLocation();
    }

    public void remove() {
        if (this.display != null) this.display.remove();
    }

}
