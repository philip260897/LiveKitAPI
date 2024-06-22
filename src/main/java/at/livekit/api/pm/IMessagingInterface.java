package at.livekit.api.pm;

import java.util.UUID;

import org.bukkit.OfflinePlayer;

public interface IMessagingInterface {

    /**
     * Send a private message from one player to another
     * @param sender who sends the @param message
     * @param receiver who receives the @param message
     * @param message the message to send
     */
    public void sendPrivateMessage(UUID sender, UUID receiver, String message);

    /**
     * Send a private message from one player to a group
     * @param sender who sends the @param message
     * @param group the group to send the @param message to
     * @param message the message to send
     */
    public void sendPrivateMessage(UUID sender, MessageGroup group, String message);

    /**
     * Send a private message from one player to another
     * @param sender who sends the @param message
     * @param receiver who receives the @param message
     * @param message the message to send
     */
    public void onPrivateMessageReceived(OfflinePlayer sender, OfflinePlayer receiver, String message);

    /**
     * Send a private message from one player to a group
     * @param sender who sends the @param message
     * @param group the group to send the @param message to
     * @param message the message to send
     */
    public void onGroupMessageReceived(OfflinePlayer sender, MessageGroup group, String message);
}
