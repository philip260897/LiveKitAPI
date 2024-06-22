package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

public abstract class AsyncPlayerLocationProvider extends PlayerLocationProvider {

    public AsyncPlayerLocationProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}
