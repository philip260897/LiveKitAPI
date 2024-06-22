package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

public abstract class AsyncPOILocationProvider extends POILocationProvider {

    public AsyncPOILocationProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}