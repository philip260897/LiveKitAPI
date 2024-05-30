package at.livekit.api.core;

import org.bukkit.OfflinePlayer;

import at.livekit.api.chat.ChatMessage;
import at.livekit.api.economy.IEconomyAdapter;
import at.livekit.api.map.POI;
import at.livekit.api.map.POIInfoProvider;
import at.livekit.api.map.PlayerInfoProvider;

/**
 * Provides acces to LiveKit API.
 */
public interface ILiveKit {

    /**
     * Registers a InfoProvider. InfoProviders are used to extends info for a certain Player.
     * @param provider A InfoProvider
     */
    void addPlayerInfoProvider(PlayerInfoProvider provider);

    /**
     * Removes a InfoProvider.
     * @param provider A InfoProvider
     */
    void removePlayerInfoProvider(PlayerInfoProvider provider);

    /**
     * Registers a POIInfoProvider. InfoProviders are used to extends info for a certain POIs.
     * @param provider A InfoProvider
     */
    void addPOIInfoProvider(POIInfoProvider provider);

    /**
     * Removes a InfoProvider.
     * @param provider A InfoProvider
     */
    void removePOIInfoProvider(POIInfoProvider provider);


    /**
     * Add a publicly displayed point of interest to the map
     * @param poi waypoint to be displayed
     */
    void addPointOfInterest(POI poi);

    /**
     * Remove a point of interest
     * @param poi waypoint to be removed
     */
    void removePointOfIntereset(POI poi);

    /**
     * Notifies clients who are looking at player of a data change. Clients will refresh players data
     * @param player Player whos data changed (locations or info)
     */
    void notifyPlayerInfoChange(OfflinePlayer player);

    /**
     * Notifies clients who are looking at poi of a data change. Client will refresh poi data
     * @param poi Poi whos data changed (info)
     */
    void notifyPOIInfoChange(POI poi);

    /**
     * Set a custom Economy adapter
     * @param adapter Economy Adapter implementation
     */
    void setEconomyAdapter(IEconomyAdapter adapter);

    /**
     * Transmits a ChatMessage to all LiveKit clients
     * @param message Message
     */
    void sendChatMessage(ChatMessage message);
}
