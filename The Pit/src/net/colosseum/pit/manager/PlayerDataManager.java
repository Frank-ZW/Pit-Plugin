package net.colosseum.pit.manager;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private Map<UUID, PlayerData> DATAMAP = new HashMap<>();
    private Pit p;

    public PlayerDataManager(Pit p) {
        this.p = p;
    }

    public void addPlayer(Player player) {
        this.DATAMAP.put(player.getUniqueId(), new PlayerData(p));
    }

    public PlayerData getPlayerData(Player player) {
        return this.DATAMAP.get(player.getUniqueId());
    }

    public boolean containsPlayer(Player player) {
        return this.DATAMAP.containsKey(player.getUniqueId());
    }

    public void logOnlinePlayers() {
        this.DATAMAP.clear();

        for (Player player: Bukkit.getOnlinePlayers()) {
            this.DATAMAP.put(player.getUniqueId(), new PlayerData(p));
        }
    }
}
