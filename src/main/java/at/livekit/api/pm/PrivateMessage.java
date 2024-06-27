package at.livekit.api.pm;

import java.util.Date;
import java.util.UUID;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "livekit_messages")
public class PrivateMessage {
    
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(index = true, indexName = "sender_receiver")
    private UUID sender;

    @DatabaseField(index = true, indexName = "sender_receiver")
    private UUID receiver;

    @DatabaseField(dataType = com.j256.ormlite.field.DataType.LONG_STRING)
    private String message;

    @DatabaseField
    private long timestamp;

    @DatabaseField(width = 32)
    private String channel;

    protected PrivateMessage() {}

    public PrivateMessage(UUID sender, UUID receiver, String message, long timestamp, String channel) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
        this.channel = channel;
    }

    public UUID getSender() {
        return sender;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getChannel() {
        return channel;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("sender", sender);
        json.put("receiver", receiver);
        json.put("message", message);
        json.put("timestamp", timestamp);
        json.put("channel", channel);
        return json;
    }

    public static PrivateMessage fromJson(JSONObject json) {
        return new PrivateMessage(UUID.fromString(json.getString("sender")), UUID.fromString(json.getString("receiver")), json.getString("message"), json.getLong("timestamp"), json.getString("channel"));
    }

    @Override
    public String toString() {
        return "PrivateMessage [channel=" + channel + ", message=" + message + ", receiver=" + receiver + ", sender=" + sender + ", timestamp=" + timestamp + "]";
    }

    public static PrivateMessage create(UUID sender, UUID receiver, String message) {
        return new PrivateMessage(sender, receiver, message, (new Date()).getTime(), "default");
    }

    public static PrivateMessage create(UUID sender, MessageGroup receiver, String message) {
        return new PrivateMessage(sender, receiver.getUUID(), message, (new Date()).getTime(), "group");
    }
}
