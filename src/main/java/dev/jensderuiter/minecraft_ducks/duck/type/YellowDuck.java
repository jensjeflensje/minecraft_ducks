package net.bingomc.spring_lobby_2025.quest.duck.type;

import net.bingomc.spring_lobby_2025.quest.duck.Duck;
import net.bingomc.spring_lobby_2025.quest.duck.DuckPart;
import net.bingomc.spring_lobby_2025.quest.duck.DuckSeat;
import net.bingomc.spring_lobby_2025.quest.duck.Offset;
import net.bingomc.spring_lobby_2025.quest.duck.animation.WaveAnimation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class YellowDuck extends Duck {
    public YellowDuck() {
        super();
        spawnLocation = new Location(Bukkit.getWorld("world"), -42.3, 17.9, -92.5);

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

        this.parts.add(new DuckSeat());

        this.animations.add(new WaveAnimation(this, 0.5, 1));
    }
}
