package net.colosseum.pit.command;

import net.colosseum.pit.Pit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements CommandExecutor {

    private Pit p;
    private Map<String, ICommand> COMMANDS = new HashMap<>();

    public CommandHandler(Pit p) {
        this.p = p;
    }

    public void register(String name, ICommand command) {
        this.COMMANDS.put(name, command);
    }

    public boolean containsCommand(String name) {
        return this.COMMANDS.containsKey(name);
    }

    public ICommand getExecutor(String name) {
        return this.COMMANDS.get(name);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        if (strings.length == 0) {
            commandSender.sendMessage(ChatColor.WHITE + "Received!");
        } else {
            if (!containsCommand(strings[0])) {
                commandSender.sendMessage(ChatColor.RED + "This command does not exist.");
                return true;
            }

            if (strings[0].equalsIgnoreCase("addperk")) {
                getExecutor("addperk").onCommand(p, commandSender, command, strings);
                return true;
            }

            if (strings[0].equalsIgnoreCase("printperks")) {
                getExecutor("printperks").onCommand(p, commandSender, command, strings);
                return true;
            }

            if (strings[0].equalsIgnoreCase("get")) {
                getExecutor("get").onCommand(p, commandSender, command, strings);
                return true;
            }

            if (strings[0].equalsIgnoreCase("removeperk")) {
                getExecutor("removeperk").onCommand(p, commandSender, command, strings);
                return true;
            }
        }

        return true;
    }
}
