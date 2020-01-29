package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerDeathPerk;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collection;

public class CursePerk extends PlayerDeathPerk {

    private final Collection<PotionEffect> effects = Arrays.asList(
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 6 * 20, 0),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6 * 20, 0),
            new PotionEffect(PotionEffectType.SLOW, 6 * 20, 0)
    );

    public CursePerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    @Override
    public void handlePerk(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        killer.addPotionEffects(this.effects);
    }
}
