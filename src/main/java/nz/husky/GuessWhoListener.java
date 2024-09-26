package nz.husky;

import nz.husky.GuessWhoGame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.Player;

public class GuessWhoListener implements Listener {

    private GuessWhoGame game;

    // This constructor takes a GuessWhoGame object as an argument
    public GuessWhoListener(GuessWhoGame game) {
        this.game = game;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        if (game.isGameActive()) {
            Player player = event.getPlayer();
            if (event.getRightClicked() instanceof Player) {
                Player target = (Player) event.getRightClicked();
                if (game.getTargetPlayer().equals(target)) {
                    player.sendMessage("You found the correct player: " + target.getName() + "!");
                    game.stopGame();
                } else {
                    player.sendMessage(target.getName() + " is not the target. Keep guessing!");
                }
            }
        }
    }
}
