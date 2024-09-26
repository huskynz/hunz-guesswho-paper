package nz.husky;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class StartGameCommand implements CommandExecutor {

    private GuessWhoGame guessWhoGame;

    public StartGameCommand(GuessWhoGame game) {
        this.guessWhoGame = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                Player target = player.getServer().getPlayer(args[0]);
                if (target != null) {
                    List<Player> players = player.getServer().getOnlinePlayers().stream()
                            .map(p -> (Player) p)  // Cast each element to Player
                            .collect(Collectors.toList());
                    guessWhoGame.startGame(target, players);
                    player.sendMessage("Game started! Guess the player!");
                    return true;
                } else {
                    player.sendMessage("Target player not found.");
                    return false;
                }
            } else {
                player.sendMessage("Usage: /startguesswho <targetPlayer>");
                return false;
            }
        }
        return false;
    }
}

