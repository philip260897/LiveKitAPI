package at.livekit.api.chat;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.json.JSONObject;

public class ChatMessage {
    
    private UUID uuid;
    private String displayName;
    private String prefix;

    private String message;
    private long timestamp;

    public ChatMessage(OfflinePlayer player, String message) {
        this.uuid = player.getUniqueId();
        this.displayName = player.getName();
        this.prefix = ChatColor.GREEN+"Online";
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ChatMessage(String displayName, String message) {
        this.uuid = null;
        this.displayName = displayName;
        this.prefix = "";
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        if(uuid != null) json.put("uuid", uuid.toString());
        json.put("displayName", displayName);
        json.put("prefix", prefix);
        json.put("message", message);
        json.put("timestamp", timestamp);
        return json;
    }
}
