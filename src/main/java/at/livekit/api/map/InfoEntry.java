package at.livekit.api.map;

import at.livekit.api.core.Privacy;

public class InfoEntry {

    private Privacy privacy;
    private String name;
    private String value;

    public InfoEntry(String name, String value) {
        this(name, value, Privacy.PRIVATE);
    }

    public InfoEntry(String name, String value, Privacy privacy) {
        this.name = name;
        this.value = value;
        this.privacy = privacy;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
