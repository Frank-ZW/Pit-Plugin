package net.colosseum.pit.perk;

import org.bukkit.entity.Player;

public interface IPerk<T> {

    void handlePerk(T paramT);
    Class<T> getType();
    boolean isEnabled();
    void setEnabled(boolean enabled);
}
