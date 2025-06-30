package dev.jensderuiter.minecraft_ducks.duck;

import org.bukkit.util.Vector;

/**
 * Util class used to define the offset of a part from a Duck's center.
 */
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
