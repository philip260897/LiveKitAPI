package at.livekit.api.providers;

import org.bukkit.plugin.Plugin;

/**
 * Base Interface for an external provider. Providers are used to PROVIDE
 * additional information (e.g. Locations for specific player, Locations for
 * worlds etc). Don't use this provider interace, extend the respective
 * provider.
 */
public abstract class Provider {

    private String name;
    private Plugin plugin;
    private String permission;

    /**
     * ctor for Provider.
     * @param plugin plugin creating this Provider
     * @param name a friendly name for this provider. Can't be null
     */
    public Provider(Plugin plugin, String name) {
        this(plugin, name, null);
    }

    /**
     * ctor for Provider.
     * @param plugin plugin creating this Provider
     * @param name a friendly name for this provider. Can't be null
     * @param permission access permission for this provider. Used to check if app clients have access to this provider
     */
    public Provider(Plugin plugin, String name, String permission) {
        this.name = name;
        this.plugin = plugin;
        this.permission = permission;
    }

    /**
     * Returns the plugin which registered this provider.
     * @return plugin
     */
    public Plugin getRegisteringPlugin() {
        return this.plugin;
    }

    /**
     * Returns the name of the provider.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns provider permission. 
     * @return permission
     */
    public String getPermission() {
        return permission;
    }
}
