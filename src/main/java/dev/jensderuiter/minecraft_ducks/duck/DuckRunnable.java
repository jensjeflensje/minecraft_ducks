package dev.jensderuiter.minecraft_ducks.duck;

import lombok.AllArgsConstructor;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Runnable that calls the Duck#tick() function every tick.
 * The Duck needs this to keep moving.
 */
@AllArgsConstructor
public class DuckRunnable extends BukkitRunnable {

    private Duck duck;

    @Override
    public void run() {
        duck.tick();
    }

}
