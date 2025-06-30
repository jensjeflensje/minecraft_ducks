package net.bingomc.spring_lobby_2025.quest.duck;

import lombok.AllArgsConstructor;
import org.bukkit.scheduler.BukkitRunnable;

@AllArgsConstructor
public class DuckRunnable extends BukkitRunnable {

    private Duck duck;

    @Override
    public void run() {
        duck.tick();
    }

}
