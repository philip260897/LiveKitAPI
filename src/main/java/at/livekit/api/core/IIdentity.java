package at.livekit.api.core;

public interface IIdentity {
    
    public boolean hasPermission(String permission);

    public String getName();

    public String getUuid();

    public boolean isAnonymous();

    public String getGroup(String world);

    public String getCurrentViewingWorld();
}
