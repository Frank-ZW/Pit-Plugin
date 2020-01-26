package net.colosseum.pit.perk.types;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.AbstractPerk;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public abstract class PlayerDamagePerk extends AbstractPerk<EntityDamageByEntityEvent> {

    public PlayerDamagePerk(Pit p, PlayerData playerData) {
        super(p, playerData, EntityDamageByEntityEvent.class);
    }
}
