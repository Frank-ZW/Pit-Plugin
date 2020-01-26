package net.colosseum.pit.perk;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;

public abstract class AbstractPerk<T> implements IPerk<T> {

    protected final Pit p;
    protected final PlayerData playerData;
    private final Class<T> clazz;
    private boolean enabled;

    public AbstractPerk(Pit p, PlayerData playerData, Class<T> clazz) {
        this.p = p;
        this.playerData = playerData;
        this.clazz = clazz;
        this.enabled = false;
    }

    public PlayerData getPlayerData() {
        return this.playerData;
    }

    @Override
    public Class<T> getType() {
        return this.clazz;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
