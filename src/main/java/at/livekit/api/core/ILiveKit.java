package at.livekit.api.core;

import org.bukkit.OfflinePlayer;

import at.livekit.api.chat.ChatMessage;
import at.livekit.api.economy.IEconomyAdapter;
import at.livekit.api.map.POI;
import at.livekit.api.map.PlayerInfoProvider;
import at.livekit.api.map.PlayerLocationProvider;
import at.livekit.api.pm.MessagingAdapter;
import at.livekit.api.map.POILocationProvider;

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
     * Registers a PlayerLocationProvider. LocationProviders are used to provide waypoints (POIs) for a certain Player.
     * @param provider A LocationProvider
     */
    void addPlayerLocationProvider(PlayerLocationProvider provider);

    /**
     * Removes a LocationProvider.
     * @param provider A LocationProvider
     */
    void removePlayerLocationProvider(PlayerLocationProvider provider);

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

    /**
     * Registers a WorldLocationProvider. LocationProviders are used to provide waypoints (POIs) for a certain World.
     * @param provider A LocationProvider
     */
    void addPOILocationProvider(POILocationProvider provider);

    /**
     * Removes a LocationProvider.
     * @param provider A LocationProvider
     */
    void removePOILocationProvider(POILocationProvider provider);

    /**
     * Notifies clients who of data change for this particular @param provider. Clients will refresh data
     * @param provider WorldLocationProvider whos data changed (locations)
     */
    void notifyPOIChange(POILocationProvider provider);

    /**
     * Set a custom Messaging adapter used to handle private messages from ingame to LiveKit App clients
     * @param adapter Messaging Adapter implementation
     */
    void setMessagingAdapter(MessagingAdapter adapter);
}
