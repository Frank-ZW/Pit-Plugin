package net.colosseum.pit.command;

import net.colosseum.pit.Pit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ICommand {

    boolean onCommand(Pit p, CommandSender commandSender, Command command, String[] args);
}
