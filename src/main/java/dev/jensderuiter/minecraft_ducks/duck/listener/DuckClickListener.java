package net.bingomc.spring_lobby_2025.quest.duck.listener;

import net.bingomc.spring_lobby_2025.quest.QuestManager;
import net.bingomc.spring_lobby_2025.quest.QuestType;
import net.bingomc.spring_lobby_2025.quest.duck.Duck;
import net.bingomc.spring_lobby_2025.quest.duck.DuckPart;
import net.bingomc.spring_lobby_2025.quest.duck.DuckSeat;
import net.bingomc.spring_lobby_2025.quest.npc.BingoNPC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Objects;

import static net.bingomc.spring_lobby_2025.quest.duck.Duck.ducks;

public class DuckClickListener implements Listener {

    @EventHandler
    public void onPlayerDuckInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!(event.getRightClicked() instanceof Interaction interaction)) return;

        Duck duck = ducks.get(interaction.getEntityId());
        if (duck == null) return;

        if (!player.getInventory().getItemInMainHand().getType().equals(Material.BREAD)) {
            duck.getParts().stream()
                    .filter(DuckSeat.class::isInstance)
                    .findAny()
                    .ifPresent(part -> {
                        player.getAttribute(Attribute.SCALE).setBaseValue(0.3);
                        ((DuckSeat) part).take(player);
                    });
        } else {
            player.getInventory().remove(Material.BREAD);

            player.sendMessage(ChatColor.YELLOW + "Quack Quack");

            if (QuestManager.hasCompletedQuest(player, QuestType.FEED_DUCKS)) return;
            QuestManager.completeQuestType(player, QuestType.FEED_DUCKS);
        }
    }
}
