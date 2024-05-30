package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

public abstract class AsyncPOIInfoProvider extends POIInfoProvider {
    
    public AsyncPOIInfoProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}
