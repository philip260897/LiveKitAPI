package at.livekit.api.map;

import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.json.JSONObject;

import at.livekit.api.core.Color;
import at.livekit.api.core.LKLocation;
import at.livekit.api.core.Privacy;

@DatabaseTable(tableName = "livekit_pois")
public class POI extends Waypoint {

    @DatabaseField
    private boolean canedit = false;

    protected POI(){}

    /**
     * @param location Location of waypoint
     * @param name Name of POI
     * @param description Description of POI
     * @param color Map marker color
     * @param canTeleport Can players teleport here?
     */
    public POI(LKLocation location, String name, String description, Color color, boolean canTeleport, UUID uuid) {
        this(location, name, description, color, canTeleport, false, uuid);
    }

    /**
     * @param location Location of waypoint
     * @param name Name of POI
     * @param description Description of POI
     * @param color Map marker color
     * @param canTeleport Can players teleport here?
     */
    public POI(LKLocation location, String name, String description, Color color, boolean canTeleport, boolean canEdit, UUID uuid) {
        super(location, name, description, color, canTeleport, Privacy.PUBLIC, uuid);
        this.canedit = canEdit;
    }

    /**
     * @return Returns true if this poi can be edited/deleted by someone with the right priviliges
     */
    public boolean canEdit() {
        return canedit;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("editable", canedit);
        return json;
    }

    /**
     * Deserializes a json representation of this object
     * @param json serialized poi
     * @return POI
     */
    public static POI fromJson(JSONObject json) {
        LKLocation location = new LKLocation(json.getString("world"), json.getDouble("x"), json.getDouble("y"), json.getDouble("z"));
        POI waypoint = new POI(location, json.getString("name"), (json.has("description")&&!json.isNull("description")) ? json.getString("description") : null, Color.fromHEX(json.getString("color")), json.getBoolean("teleport"), json.getBoolean("editable"), UUID.fromString(json.getString("uuid")));
        return waypoint;
    }

    public static POI create(LKLocation location, String name, String description, Color color, boolean canTeleport, boolean canEdit) {
        UUID uuid = UUID.randomUUID();
        return new POI(location, name, description, color, canTeleport, canEdit, uuid);
    }
}
