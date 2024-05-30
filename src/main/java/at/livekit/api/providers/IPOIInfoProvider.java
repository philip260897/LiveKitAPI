package at.livekit.api.providers;

import java.util.List;

import at.livekit.api.map.InfoEntry;
import at.livekit.api.map.POI;

public interface IPOIInfoProvider {
    
    /**
     * Gets called whenever someone extends the poi bottom sheet in the LiveKit App.
     * @param poi POI being viewed
     * @param entries List of collected InfoEntry objects. Add any InfoEntry to this list
     */
    void onResolvePOIInfo(POI poi, List<InfoEntry> entries);


}
