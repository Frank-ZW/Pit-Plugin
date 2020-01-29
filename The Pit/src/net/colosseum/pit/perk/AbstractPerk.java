package net.colosseum.pit.perk;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;

public abstract class AbstractPerk<T> implements IPerk<T> {

    protected final Pit p;
    protected final PlayerData playerData;
    private final Class<T> clazz;

    public AbstractPerk(Pit p, PlayerData playerData, Class<T> clazz) {
        this.p = p;
        this.playerData = playerData;
        this.clazz = clazz;
    }

    public PlayerData getPlayerData() {
        return this.playerData;
    }

    @Override
    public Class<T> getType() {
        return this.clazz;
    }
}
