package at.livekit.api.providers;

import java.util.List;

import at.livekit.api.core.IIdentity;
import at.livekit.api.map.InfoEntry;
import at.livekit.api.map.POI;

public interface IPOILocationProvider {
    /**
     * Gets called when a user (@param identity) views the map in the LiveKit App, or a notify is triggered
     * 
     * @return List of waypoints for the @param world
     */
    List<POI> onResolvePOILocations(IIdentity identity);

    /**
     * Gets called whenever someone extends the poi bottom sheet in the LiveKit App.
     * @param identity The identity (Identified player) in the app viewing the current @param player
     * @param poi the waypoint (POI) being viewed on the map
     * 
     * @return List of Info entries for the @param poi
     */
    List<InfoEntry> onResolvePOIInfo(IIdentity identity, POI poi);
}
