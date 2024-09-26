package nz.husky;

import org.bukkit.plugin.java.JavaPlugin;
import nz.husky.StartGameCommand;
import nz.husky.GuessCommand;

public class hunzguesswho extends JavaPlugin {

    private GuessWhoGame guessWhoGame;

    @Override
    public void onEnable() {
        guessWhoGame = new GuessWhoGame();

        // Register commands
        if (getCommand("startguesswho") != null) {
            getCommand("startguesswho").setExecutor(new StartGameCommand(guessWhoGame));
        } else {
            getLogger().severe("Command 'startguesswho' is not defined in plugin.yml!");
        }

        if (getCommand("guess") != null) {
            getCommand("guess").setExecutor(new GuessCommand(guessWhoGame));
        } else {
            getLogger().severe("Command 'guess' is not defined in plugin.yml!");
        }

        getLogger().info("Guess Who plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Guess Who plugin has been disabled!");
    }
}
