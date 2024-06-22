package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

import at.livekit.api.providers.IPlayerLocationProvider;
import at.livekit.api.providers.Provider;

public abstract class PlayerLocationProvider extends Provider implements IPlayerLocationProvider {

    public PlayerLocationProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}


