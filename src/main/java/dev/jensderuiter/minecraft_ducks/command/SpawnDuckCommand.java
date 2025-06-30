package dev.jensderuiter.minecraft_ducks.command;

import dev.jensderuiter.minecraft_ducks.duck.type.YellowDuck;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnDuckCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        if (!player.hasPermission("duck.spawn")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        };

        new YellowDuck(player.getLocation()).summon();

        return true;
    }

}
