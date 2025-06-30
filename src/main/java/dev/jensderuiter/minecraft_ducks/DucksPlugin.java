package dev.jensderuiter.minecraft_ducks;

import dev.jensderuiter.minecraft_ducks.command.SpawnDuckCommand;
import dev.jensderuiter.minecraft_ducks.duck.Duck;
import dev.jensderuiter.minecraft_ducks.duck.listener.DuckClickListener;
import dev.jensderuiter.minecraft_ducks.duck.listener.DuckDismountListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import static dev.jensderuiter.minecraft_ducks.duck.Duck.ducks;

public final class DucksPlugin extends JavaPlugin {

    @Getter
    private static DucksPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("spawnduck").setExecutor(new SpawnDuckCommand());

        getServer().getPluginManager().registerEvents(new DuckClickListener(), this);
        getServer().getPluginManager().registerEvents(new DuckDismountListener(), this);
    }

    @Override
    public void onDisable() {
        // clean up any ducks
        ducks.values().forEach(Duck::remove);
        ducks.clear();
    }
}
