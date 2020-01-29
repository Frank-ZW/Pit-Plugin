package net.colosseum.pit.perk;

public interface IPerk<T> {

    void handlePerk(T paramT);
    Class<T> getType();
}
