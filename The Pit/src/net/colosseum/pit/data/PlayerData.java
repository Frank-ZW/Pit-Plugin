package net.colosseum.pit.data;

import net.colosseum.pit.Pit;
import net.colosseum.pit.perk.IPerk;
import net.colosseum.pit.perk.perks.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerData {

    public static final Class<? extends IPerk>[] PERKS = new Class[] {
            GHeadPerk.class,
            SnowmanPerk.class,
            FishingRodPerk.class,
            KnightPerk.class,
            ScavengerPerk.class,
            CursePerk.class,
            CounterPerk.class
    };
    private static final Map<Class<? extends IPerk>, Constructor<? extends IPerk>> CONSTRUCTORS = new ConcurrentHashMap<>();
    private final Map<Class<? extends IPerk>, IPerk> perkMap = new HashMap<>();
    private Set<IPerk> ACTIVEPERKS = new HashSet<IPerk>();

    private int balance;
    private int experience;
    private int prestige;
    private int killStreak;

    private boolean online;
    private boolean build;

    static {
        for (Class<? extends IPerk> perkClass: PERKS) {
            try {
                CONSTRUCTORS.put(perkClass, perkClass.getConstructor(Pit.class, PlayerData.class));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public PlayerData(Pit p) {
        this.online = true;

        for (Class<? extends IPerk> perkClass: PERKS) {
            Constructor constructor = CONSTRUCTORS.get(perkClass);

            try {
                this.perkMap.put(perkClass, (IPerk) constructor.newInstance(p, this));
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public <T extends IPerk> IPerk getPerk(Class<T> clazz) {
        return this.perkMap.get(clazz);
    }

    public int getBalance() {
        return this.balance;
    }

    public int getXP() {
        return this.experience;
    }

    public int getPrestige() {
        return this.prestige;
    }

    public boolean isOnline() {
        return this.online;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setXP(int experience) {
        this.experience = experience;
    }

    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void incrementBalance(int amount) {
        this.balance += amount;
    }

    public void decrementBalance(int amount) {
        this.balance -= amount;
    }

    public void incrementXP(int amount) {
        this.experience += amount;
    }

    public void decrementXP(int amount) {
        this.experience -= amount;
    }

    public void incrementPrestige(int amount) {
        this.prestige += amount;
    }

    public void decrementPrestige(int amount) {
        this.prestige -= amount;
    }

    public int getKillStreak() {
        return this.killStreak;
    }

    public void setKillStreak(int killStreak) {
        this.killStreak = killStreak;
    }

    public void incrementKillStreak(int amount) {
        this.killStreak += amount;
    }

    public boolean canBuild() {
        return this.build;
    }

    public void setBuild(boolean build) {
        this.build = build;
    }

    /**
     * The two methods enablePerk and printPerks are temporary and should be deleted once we actually implement
     * the plugin into the server. The commands and methods are there just to verify that the plugin is working.
     */
    public <T> void enablePerk(Class<T> clazz) {
        this.ACTIVEPERKS.add(this.perkMap.get(clazz));
    }

    public <T> void disablePerk(Class<T> clazz) {
        this.ACTIVEPERKS.remove(this.perkMap.get(clazz));
    }

    public void disableAllPerks() {
        this.ACTIVEPERKS.clear();
    }

    public <T> boolean hasEnabledPerk(Class<T> clazz) {
        return this.ACTIVEPERKS.contains(this.perkMap.get(clazz));
    }

    public String printPerks() {
        StringBuilder result = new StringBuilder();
        for (Class<? extends IPerk> perkClass: PERKS) {
            IPerk perk = perkMap.get(perkClass);
            result.append("\nType: ").append(perk.getType().toString()).append(", Enabled: ").append(this.ACTIVEPERKS.contains(perk)).append("\n");
        }

        return result.toString();
    }
}
