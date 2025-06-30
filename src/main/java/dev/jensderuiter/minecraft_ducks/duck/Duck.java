package net.bingomc.spring_lobby_2025.quest.duck;

import lombok.Getter;
import lombok.Setter;
import net.bingomc.spring_lobby_2025.LobbyPlugin;
import net.bingomc.spring_lobby_2025.quest.duck.animation.DuckAnimation;
import net.bingomc.spring_lobby_2025.quest.duck.animation.Moveable;
import org.bukkit.*;
import org.bukkit.entity.Interaction;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Duck implements Moveable {

    public static HashMap<Integer, Duck> ducks = new HashMap<>();

    private final int TICK_DELAY = 4;

    public Location spawnLocation;

    private Interaction interaction;

    protected Location location;
    protected Location baseLocation;
    @Getter
    protected List<DuckPart> parts;
    protected List<DuckAnimation> animations;
    private BukkitRunnable task;

    protected double maxLocationOffset;
    private int maxLocationTicks;
    private int locationTick;
    private Vector locationVector;

    @Setter
    @Getter
    private Offset animationOffset;

    public Duck() {
        this.parts = new ArrayList<>();
        this.animations = new ArrayList<>();
        this.animationOffset = new Offset(0, 0, 0, 0, 0, 1);
        this.maxLocationOffset = 2.5d;
        this.maxLocationTicks = 24;
        this.locationTick = 0;
    }


    public void summon() {
        this.baseLocation = spawnLocation.clone();
        this.location = spawnLocation.clone();

        interaction = location.getWorld().spawn(location, Interaction.class);

        this.parts.forEach(part -> part.summon(location));
        this.parts.forEach(part -> part.getDisplay().setTeleportDuration(TICK_DELAY));
        this.parts.forEach(part -> part.move(location));

        this.chooseLocationTarget();

        this.task = new DuckRunnable(this);
        this.task.runTaskTimer(LobbyPlugin.getInstance(), 0, TICK_DELAY);
        ducks.put(interaction.getEntityId(), this);
    }

    public void tick() {
        this.animations.forEach(DuckAnimation::tick);
        Location tickLocation = this.location.clone().add(this.getAnimationOffset().toVector());
        this.parts.forEach(part -> part.move(tickLocation));
        interaction.teleport(tickLocation);

        if (this.locationTick == this.maxLocationTicks) {
            this.locationTick = 0;
            this.maxLocationTicks = new Random().nextInt(24) + 12;
            this.chooseLocationTarget();
        }

        this.location = this.location.add(locationVector);

        this.locationTick++;
    }

    private void chooseLocationTarget() {
        Location targetLocation = this.baseLocation.clone();
        Vector vector = new Vector(
                (new Random().nextDouble()-0.5) * 2 * maxLocationOffset,
                0,
                (new Random().nextDouble()-0.5) * 2 * maxLocationOffset
        );
        targetLocation.add(vector);
        this.locationVector = targetLocation
                .subtract(this.location.clone())
                .toVector()
                .multiply(1d/maxLocationTicks);
        this.location.setYaw((float) Math.toDegrees(Math.atan2(locationVector.getZ(), locationVector.getX())) - 90f);
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    public void remove() {
        this.task.cancel();
        this.parts.forEach(DuckPart::remove);
        this.interaction.remove();
    }

}
