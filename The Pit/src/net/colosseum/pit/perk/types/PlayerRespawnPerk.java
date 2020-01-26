package net.colosseum.pit.perk.types;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.AbstractPerk;
import org.bukkit.event.player.PlayerRespawnEvent;

public abstract class PlayerRespawnPerk extends AbstractPerk<PlayerRespawnEvent> {

    public PlayerRespawnPerk(Pit p, PlayerData playerData) {
        super(p, playerData, PlayerRespawnEvent.class);
    }
}
