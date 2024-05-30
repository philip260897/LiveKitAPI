package at.livekit.api.core;

/**
 * Root Plugin interface implemented by the LiveKit plugin.
 */
public interface ILiveKitPlugin {

    /**
     * Gets the LiveKit instance.
     * @return LiveKit instance
     */
    ILiveKit getLiveKit();

}
