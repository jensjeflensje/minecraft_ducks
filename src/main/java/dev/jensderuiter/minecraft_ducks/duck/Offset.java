package net.bingomc.spring_lobby_2025.quest.duck;

import org.bukkit.util.Vector;

public class Offset {

    public double x;
    public double y;
    public double z;
    public float pitch;
    public float yaw;
    public Vector size;

    public Offset(double x, double y, double z, float pitch, float yaw, float size) {
        this(x, y, z, pitch, yaw, new Vector(size, size, size));
    }

    public Offset(double x, double y, double z, float pitch, float yaw, Vector size) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.size = size;
    }

    public Vector toVector() {
        return new Vector(x, y, z);
    }

}
