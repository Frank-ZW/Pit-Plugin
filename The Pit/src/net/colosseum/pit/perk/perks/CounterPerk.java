package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerDamagePerk;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class CounterPerk extends PlayerDamagePerk {

    private final Collection<PotionEffect> effects = Arrays.asList(
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3 * 20, 0)
    );

    public CounterPerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    @Override
    public void handlePerk(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }

        Random random = new Random();
        Player player = (Player) e.getDamager();
        int randomNumber =random.nextInt(24) + 1;
        if (randomNumber == 1 || randomNumber == 25) {
            player.addPotionEffects(this.effects);
        }
    }
}
