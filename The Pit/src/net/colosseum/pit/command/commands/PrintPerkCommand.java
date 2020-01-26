package net.colosseum.pit.command.commands;

import net.colosseum.pit.Pit;
import net.colosseum.pit.command.ICommand;
import net.colosseum.pit.data.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrintPerkCommand implements ICommand {

    @Override
    public boolean onCommand(Pit p, CommandSender commandSender, Command command, String[] args) {

        PlayerData playerData = p.getPlayerDataManager().getPlayerData((Player) commandSender);
        commandSender.sendMessage(playerData.printPerks());

        return true;
    }
}
