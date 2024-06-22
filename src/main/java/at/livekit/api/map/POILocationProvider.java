package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

import at.livekit.api.providers.IPOILocationProvider;
import at.livekit.api.providers.Provider;

public abstract class POILocationProvider extends Provider implements IPOILocationProvider {

    public POILocationProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}