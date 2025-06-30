package dev.jensderuiter.minecraft_ducks.duck.animation;


import dev.jensderuiter.minecraft_ducks.duck.Offset;
import org.bukkit.Location;


public interface Moveable {

    Offset getAnimationOffset();
    void setAnimationOffset(Offset offset);
    Location getLocation();

}
