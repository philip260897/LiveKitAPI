package at.livekit.api.map;

import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.json.JSONObject;

import at.livekit.api.core.Color;
import at.livekit.api.core.LKLocation;
import at.livekit.api.core.Privacy;

@DatabaseTable(tableName = "livekit_personalpins")
public class PersonalPin extends Waypoint {

    @DatabaseField(index = true)
    private UUID playeruuid;

    protected PersonalPin(){}

   /**
     * @param location Location of waypoint
     * @param name Name of POI
     * @param description Description of POI
     * @param color Map marker color
     * @param canTeleport Can players teleport here?
     */
    public PersonalPin(OfflinePlayer player, LKLocation location, String name, boolean canTeleport, Privacy privacy, UUID uuid) {
        this(player, location, name, null, Color.fromChatColor(ChatColor.RED), canTeleport, privacy, uuid);
    }

    /**
     * @param location Location of waypoint
     * @param name Name of POI
     * @param description Description of POI
     * @param color Map marker color
     * @param canTeleport Can players teleport here?
     */
    public PersonalPin(OfflinePlayer player, LKLocation location, String name, String description, Color color, boolean canTeleport, Privacy privacy, UUID uuid) {
        super(location, name, description, color, canTeleport, Privacy.PUBLIC, uuid);
        this.playeruuid = player.getUniqueId();
    }

    /**
     * @return Returns true if this poi can be edited/deleted by someone with the right priviliges
     */
    public UUID getPlayerUUID() {
        return playeruuid;
    }

    @Override
    public JSONObject toJson() {
        return super.toJson();
        //json.put("playeruuid", playerUUID);
        //return json;
    }

    /**
     * Deserializes a json representation of this object
     * @param json serialized poi
     * @return POI
     */
    public static PersonalPin fromJson(JSONObject json, String playerUUID) {
        LKLocation location = new LKLocation(json.getString("world"), json.getDouble("x"), json.getDouble("y"), json.getDouble("z"));
        Privacy privacy = json.has("privacy")&&!json.isNull("privacy") ? Privacy.valueOf(json.getString("privacy")) : Privacy.PRIVATE;
        return new PersonalPin(
            Bukkit.getOfflinePlayer(UUID.fromString(playerUUID)),
            location, json.getString("name"),  
            (json.has("description")&&!json.isNull("description")) ? json.getString("description") : null, 
            Color.fromHEX(json.getString("color")), 
            json.getBoolean("teleport"), 
            privacy,
            UUID.fromString(json.getString("uuid"))
        );
    }

    /**
     * Deserializes a json representation of this object
     * @param json serialized poi
     * @return POI
     */
    public static PersonalPin fromJson(JSONObject json) {
        return PersonalPin.fromJson(json, json.getString("playeruuid"));
    }

    public static PersonalPin create(OfflinePlayer player, LKLocation location, String name, String description, Color color, boolean canTeleport, Privacy privacy) {
        UUID uuid = UUID.randomUUID();
        return new PersonalPin(player, location, name, description, color, canTeleport, privacy, uuid);
    }
}
