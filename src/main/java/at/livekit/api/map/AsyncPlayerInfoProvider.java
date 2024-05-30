package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

public abstract class AsyncPlayerInfoProvider extends PlayerInfoProvider {

    public AsyncPlayerInfoProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}
