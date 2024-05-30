package at.livekit.api.providers;

import java.util.List;

import org.bukkit.OfflinePlayer;

import at.livekit.api.map.InfoEntry;
import at.livekit.api.map.PersonalPin;

/**
 * Interface for providing custom Info entries for a specific Player.
 */
public interface IPlayerInfoProvider {
    /**
     * Gets called whenever someone extends the player bottom sheet in the LiveKit App.
     * @param player Player being viewed
     * @param entries List of collected InfoEntry objects. Add any InfoEntry to this list
     */
    void onResolvePlayerInfo(OfflinePlayer player, List<InfoEntry> entries);

    /**
     * Gets called whenever someone extends the player bottom sheet in the LiveKit App.
     * @param player Player being viewed
     * @param waypoints List of collected waypoints. Add any waypoints to this list
     */
    void onResolvePlayerLocation(OfflinePlayer player, List<PersonalPin> waypoints);
}
