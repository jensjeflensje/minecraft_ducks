package net.bingomc.spring_lobby_2025.quest.duck.animation;


import net.bingomc.spring_lobby_2025.quest.duck.Offset;
import org.bukkit.Location;


public interface Moveable {

    Offset getAnimationOffset();
    void setAnimationOffset(Offset offset);
    Location getLocation();

}
