package net.colosseum.pit.perk.types;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.AbstractPerk;
import org.bukkit.event.entity.PlayerDeathEvent;

public abstract class PlayerDeathPerk extends AbstractPerk<PlayerDeathEvent> {

    public PlayerDeathPerk(Pit p, PlayerData playerData) {
        super(p, playerData, PlayerDeathEvent.class);
    }
}
