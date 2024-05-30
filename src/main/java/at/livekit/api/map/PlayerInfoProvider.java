package at.livekit.api.map;

import org.bukkit.plugin.Plugin;

import at.livekit.api.providers.IPlayerInfoProvider;
import at.livekit.api.providers.Provider;

/**
 * Provider skeleton for Info Provider.
 */
public abstract class PlayerInfoProvider extends Provider implements IPlayerInfoProvider {

    public PlayerInfoProvider(Plugin plugin, String name, String permission) {
        super(plugin, name, permission);
    }
}
