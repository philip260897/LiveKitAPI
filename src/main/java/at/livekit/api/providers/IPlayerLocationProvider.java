package at.livekit.api.providers;

import java.util.List;

import org.bukkit.OfflinePlayer;

import at.livekit.api.core.IIdentity;
import at.livekit.api.map.PersonalPin;

public interface IPlayerLocationProvider {
    /**
     * Gets called whenever someone extends the player bottom sheet in the LiveKit App.
     * @param identity The identity (Identified player) in the app viewing the current @param player
     * @param player The player being viewed
     * 
     * @return List of waypoints for the @param player
     */
    List<PersonalPin> onResolvePlayerLocation(IIdentity identity, OfflinePlayer player);
}
