package at.livekit.api.pm;

import java.util.UUID;

import org.bukkit.OfflinePlayer;

public abstract class MessagingAdapter implements IMessagingInterface {
    
    public IMessagingInterface listener;

    public void registerMessagingService(IMessagingInterface listener) {
        this.listener = listener;
    }
    
    public void sendPrivateMessage(OfflinePlayer sender, OfflinePlayer receiver, String message) {
        sendPrivateMessage(sender.getUniqueId(), receiver.getUniqueId(), message);
    }

    @Override
    public void sendPrivateMessage(UUID sender, UUID receiver, String message) {
        if(listener != null) {
            listener.sendPrivateMessage(sender, receiver, message);
        }
    }

    public void sendPrivateMessage(OfflinePlayer sender, MessageGroup group, String message) {
        sendPrivateMessage(sender.getUniqueId(), group, message);
    }

    @Override
    public void sendPrivateMessage(UUID sender, MessageGroup group, String message) {
        if(listener != null) {
            listener.sendPrivateMessage(sender, group, message);
        }
    }
}
