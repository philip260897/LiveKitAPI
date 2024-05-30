package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

import at.livekit.api.providers.IPOIInfoProvider;
import at.livekit.api.providers.Provider;

public abstract class POIInfoProvider extends Provider implements IPOIInfoProvider {

    public POIInfoProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}