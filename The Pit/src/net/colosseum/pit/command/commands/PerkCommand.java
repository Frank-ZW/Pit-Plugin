package net.colosseum.pit.command.commands;

import net.colosseum.pit.Pit;
import net.colosseum.pit.command.ICommand;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.perks.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerkCommand implements ICommand {

    @Override
    public boolean onCommand(Pit p, CommandSender commandSender, Command command, String[] args) {

        PlayerData playerData = p.getPlayerDataManager().getPlayerData((Player) commandSender);
        if (args[1].equalsIgnoreCase("ghead")) {
            playerData.enablePerk(GHeadPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("rod")) {
            playerData.enablePerk(FishingRodPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("knight")) {
            playerData.enablePerk(KnightPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("scavenger")) {
            playerData.enablePerk(ScavengerPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("snowman")) {
            playerData.enablePerk(SnowmanPerk.class);
            return true;
        }

        commandSender.sendMessage("This perk does not exist!");
        return true;
    }
}
