package dev.jensderuiter.minecraft_ducks.duck.type;

import dev.jensderuiter.minecraft_ducks.duck.Duck;
import dev.jensderuiter.minecraft_ducks.duck.DuckPart;
import dev.jensderuiter.minecraft_ducks.duck.DuckSeat;
import dev.jensderuiter.minecraft_ducks.duck.Offset;
import dev.jensderuiter.minecraft_ducks.duck.animation.WaveAnimation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

/**
 * Simple implementation of Duck that looks like a rubber bath duck.
 */
public class YellowDuck extends Duck {
    public YellowDuck(Location location) {
        super();
        spawnLocation = location;

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0, 0, 0, 0, 0, new Vector(0.45, 0.3, 0.45)))
                .material(Material.YELLOW_CONCRETE)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0, 0.045, 0, 0, 0, new Vector(0.495, 0.18, 0.3)))
                .material(Material.YELLOW_WOOL)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0, 0.27, 0.21, 0, 0, new Vector(0.3, 0.3, 0.33)))
                .material(Material.YELLOW_CONCRETE)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0, 0.1575, 0.39, 0, 0, new Vector(0.24, 0.075, 0.15)))
                .material(Material.ORANGE_CONCRETE)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(-0.075, 0.27, 0.36, 0, 0, new Vector(0.06, 0.09, 0.06)))
                .material(Material.BLACK_CONCRETE)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0.075, 0.27, 0.36, 0, 0, new Vector(0.06, 0.09, 0.06)))
                .material(Material.BLACK_CONCRETE)
                .build()
        );

        this.parts.add(DuckPart.builder()
                .offset(new Offset(0, 0.15, -0.225, 0, 0, new Vector(0.24, 0.09, 0.09)))
                .material(Material.YELLOW_CONCRETE)
                .build()
        );

        this.parts.add(new DuckSeat(spawnLocation));

        this.animations.add(new WaveAnimation(this, 0.5, 1));
    }
}
