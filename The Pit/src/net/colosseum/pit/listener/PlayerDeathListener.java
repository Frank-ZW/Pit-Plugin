package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.IPerk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    public Pit p;
    private int experience = 10;
    private int gold = 12;

    public PlayerDeathListener(Pit p) {
        this.p = p;
    }

    /**
     * Without any modifiers, players will earn a base of 10 XP and 12 gold. For every
     * ten levels above, the reward increases by 1 XP and 2 gold. For every prestige,
     * the reward increases by 2 XP and 3 gold.
     */
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        Player victim = e.getEntity();

        PlayerData killerData = p.getPlayerDataManager().getPlayerData(killer);
        PlayerData victimData = p.getPlayerDataManager().getPlayerData(victim);

        if (victimData.getXP() - killerData.getXP() > 9) {
            this.experience += (victimData.getXP() - killerData.getXP()) / 10;
            this.gold += 2 * (victimData.getXP() - killerData.getXP()) / 10;
        }

        if (victimData.getPrestige() > killerData.getPrestige()) {
            this.experience += 2 * (victimData.getPrestige() - killerData.getPrestige());
            this.gold += 3 * (victimData.getPrestige() - killerData.getPrestige());
        }

        killerData.incrementBalance(this.gold);
        killerData.incrementXP(this.experience);
        killerData.incrementKillStreak(1);

        victimData.setKillStreak(0);

        e.getDrops().clear();
        e.setDroppedExp(0);

        for (Class<? extends IPerk> perkClass: PlayerData.PERKS) {
            IPerk perk = killerData.getPerk(perkClass);
            if (perk.isEnabled() && perk.getType() == PlayerDeathEvent.class) {
                perk.handlePerk(e);
            }
        }
    }
}
