package nz.husky;

import nz.husky.GuessWhoGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuessCommand implements CommandExecutor {

    private GuessWhoGame guessWhoGame;

    public GuessCommand(GuessWhoGame game) {
        this.guessWhoGame = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (guessWhoGame.isGameActive()) {
                if (args.length == 1) {
                    String guessedName = args[0];
                    boolean correct = guessWhoGame.guess(player, guessedName);
                    if (correct) {
                        player.sendMessage("Correct! " + guessedName + " was the target!");
                        return true;
                    } else {
                        player.sendMessage("Incorrect guess. Try again!");
                        return false;
                    }
                } else {
                    player.sendMessage("Usage: /guess <playerName>");
                    return false;
                }
            } else {
                player.sendMessage("No game is currently active.");
                return false;
            }
        }
        return false;
    }
}