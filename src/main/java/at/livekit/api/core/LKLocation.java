package at.livekit.api.core;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;


public class LKLocation {
    
    private final String world;
    private final int blockX;
    private final int blockY;
    private final int blockZ;

    private final double x, y, z;

    public LKLocation(String world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.blockX = (int) Math.floor(x);
        this.blockY = (int) Math.floor(y);
        this.blockZ = (int) Math.floor(z);
    }

    public String getWorld() {
        return world;
    }

    public int getBlockX() {
        return blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public int getBlockZ() {
        return blockZ;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double distance(LKLocation location) {
        return Math.sqrt(Math.pow((location.x - this.x), 2) + Math.pow((location.y - this.y), 2) + Math.pow((location.z - this.z), 2));
    }

    public Location toLocation() {
        return new Location(Bukkit.getWorld(world), blockX, blockX, blockZ);
    }

    public static LKLocation fromLocation(Location location) {
        return new LKLocation(location.getWorld().getName(), location.getX(), location.getY(), location.getZ());
    }
}
