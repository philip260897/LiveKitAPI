package at.livekit.api.providers;

import java.util.List;

import org.bukkit.OfflinePlayer;

import at.livekit.api.core.IIdentity;
import at.livekit.api.map.InfoEntry;

/**
 * Interface for providing custom Info entries for a specific Player.
 */
public interface IPlayerInfoProvider {
    /**
     * Gets called whenever someone extends the player bottom sheet in the LiveKit App.
     * @param identity The identity (Identified player) in the app viewing the current @param player
     * @param player The player being viewed
     * 
     * @return List of Info entries for the @param player
     */
    List<InfoEntry> onResolvePlayerInfo(IIdentity identity, OfflinePlayer player);
}
