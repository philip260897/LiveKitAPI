package at.livekit.api.map;

import at.livekit.api.core.Color;
import at.livekit.api.core.LKLocation;
import at.livekit.api.core.Privacy;
import at.livekit.api.datapersistors.ColorPersistor;
import at.livekit.api.datapersistors.LKLocationPersistor;

import java.util.UUID;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import org.bukkit.ChatColor;

import org.json.JSONObject;

/**
 * Stores all information a Waypoint needs to be displayed on a map.
 */
public abstract class Waypoint {

    @DatabaseField(id = true)
    private UUID uuid;
    
    @DatabaseField(dataType = DataType.ENUM_NAME, unknownEnumName = "PRIVATE")
    private Privacy privacy = Privacy.PRIVATE;
    
    @DatabaseField(width = 32)
    private String name;
    
    @DatabaseField(dataType = DataType.LONG_STRING)
    private String description;
    
    @DatabaseField(persisterClass = ColorPersistor.class)
    private Color color;

    @DatabaseField(persisterClass = LKLocationPersistor.class)
    private LKLocation location;

    @DatabaseField
    private boolean canteleport = false;

    protected Waypoint(){}

    /**
     * ctor for new Waypoint.
     * @param location
     * @param name
     * @param canTeleport
     * @param privacy
     */
    public Waypoint(LKLocation location, String name, boolean canTeleport, Privacy privacy, UUID uuid) {
        this(location, name, null, Color.fromChatColor(ChatColor.RED), canTeleport, privacy, uuid);
    }

    /**
     * ctor for new Waypoint.
     * @param location location
     * @param name name
     * @param description description
     * @param color icon color
     * @param canTeleport if players can teleport to this waypoint
     * @param privacy who sees this waypoint. If belonging to a player, and private, only the player sees it. If belonging to a POI, privacy is ignored, everyone can see it
     */
    public Waypoint(LKLocation location, String name, String description, Color color, boolean canTeleport, Privacy privacy, UUID uuid) {
        this.uuid = uuid;
        this.location = location;
        this.name = name;
        this.description = description;
        this.color = color;
        this.privacy = privacy;
        this.canteleport = canTeleport;
    }

    /**
     * Name of the Waypoint.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Description of the Waypoint.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * The Color the Waypoint has when it's being displayed in the App.
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * The Location of the Waypoint.
     * @return location
     */
    public LKLocation getLocation() {
        return location;
    }

    /**
     * Privacy of this waypoint
     * @return privacy of this waypoint
     */
    public Privacy getPrivacy() {
        return privacy;
    }

    /**
     * If players can teleport to this waypoint
     * @return true if players can teleport here
     */
    public boolean canTeleport() {
        return canteleport;
    }

    /**
     * Returns random waypoint UUID. Used for identifiying waypoints between client and server
     * @return uuid
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Serializes this object
     * @return JSON representation of this object
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("uuid", this.getUUID().toString());
        json.put("name", this.getName());
        json.put("description", this.getDescription());
        json.put("x", this.getLocation().getBlockX());
        json.put("y", this.getLocation().getBlockY());
        json.put("z", this.getLocation().getBlockZ());
        json.put("color", this.getColor().getHEX());
        json.put("world", this.getLocation().getWorld());
        json.put("teleport", this.canTeleport());
        json.put("privacy", this.getPrivacy().name());
        return json;
    }

    /**
     * Deserializes a json representation of this object
     * @param json serialized waypoint
     * @return Waypoint
     */
    /*public static Waypoint fromJson(JSONObject json) {
        LKLocation location = new LKLocation(json.getString("world"), json.getDouble("x"), json.getDouble("y"), json.getDouble("z"));
        Privacy privacy = json.has("privacy")&&!json.isNull("privacy") ? Privacy.valueOf(json.getString("privacy")) : Privacy.PRIVATE;
        Waypoint waypoint = new Waypoint(
            location, json.getString("name"),  
            (json.has("description")&&!json.isNull("description")) ? json.getString("description") : null, 
            Color.fromHEX(json.getString("color")), 
            json.getBoolean("teleport"), 
            privacy,
            UUID.fromString(json.getString("uuid"))
        );
        return waypoint;
    }*/

    /*public static Waypoint create(LKLocation location, String name, String description, Color color, boolean canTeleport, Privacy privacy) {
        UUID uuid = UUID.randomUUID();
        return new Waypoint(location, name, description, color, canTeleport, privacy, uuid);
    }*/
}
