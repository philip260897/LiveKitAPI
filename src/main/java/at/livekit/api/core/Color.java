package at.livekit.api.core;

import org.bukkit.ChatColor;

/**
 * Holds color information, to be used to color something in the LiveKit App.
 */
public final class Color {

    static final int DEFAULT_ALPHA = 255;
    static final int DEFAULT_RED = 255;
    static final int DEFAULT_GREEN = 0;
    static final int DEFAULT_BLUE = 0;

    private int a = DEFAULT_ALPHA;
    private int r = DEFAULT_RED;
    private int g = DEFAULT_GREEN;
    private int b = DEFAULT_BLUE;

    private Color() {
    }

    /**
     * Gets Alpha channel value.
     * @return alpha
     */
    public int getAlpha() {
        return a;
    }

    /**
     * Gets Red channel value.
     * @return red
     */
    public int getRed() {
        return r;
    }

    /**
     * Gets Green channel value.
     * @return green
     */
    public int getGreen() {
        return g;
    }

    /**
     * Gets Blue channel value.
     * @return blue
     */
    public int getBlue() {
        return b;
    }

    /**
     * Gets this color as a hex string.
     * @return hex representation of this color
     */
    public String getHEX() {
        String alpha = pad(Integer.toHexString(getAlpha()));
        String red = pad(Integer.toHexString(getRed()));
        String green = pad(Integer.toHexString(getGreen()));
        String blue = pad(Integer.toHexString(getBlue()));
        return "#" + alpha + red + green + blue;
    }

    /**
     * Parses a LiveKit Color from ChatColor.
     * @param color Bukkit ChatColor
     * @return LiveKit Color
     */
    public static Color fromChatColor(ChatColor color) {
        if(color == ChatColor.BLACK) return Color.fromHEX("000000");
        if(color == ChatColor.DARK_BLUE) return Color.fromHEX("0000AA");
        if(color == ChatColor.DARK_GREEN) return Color.fromHEX("00AA00");
        if(color == ChatColor.DARK_AQUA) return Color.fromHEX("00AAAA");
        if(color == ChatColor.DARK_RED) return Color.fromHEX("AA0000");
        if(color == ChatColor.DARK_PURPLE) return Color.fromHEX("AA00AA");
        if(color == ChatColor.GOLD) return Color.fromHEX("FFAA00");
        if(color == ChatColor.GRAY) return Color.fromHEX("AAAAAA");
        if(color == ChatColor.DARK_GRAY) return Color.fromHEX("555555");
        if(color == ChatColor.BLUE) return Color.fromHEX("5555FF");
        if(color == ChatColor.GREEN) return Color.fromHEX("55FF55");
        if(color == ChatColor.AQUA) return Color.fromHEX("55FFFF");
        if(color == ChatColor.RED) return Color.fromHEX("FF5555");
        if(color == ChatColor.LIGHT_PURPLE) return Color.fromHEX("FF55FF");
        if(color == ChatColor.YELLOW) return Color.fromHEX("FFFF55");
        if(color == ChatColor.WHITE) return Color.fromHEX("FFFFFF");
        return Color.fromHEX("FF0000");
    }

    /**
     * Parses a LiveKit Color from a Hex-String (parses #ARGB).
     * @param hex Hex-String
     * @return LiveKit Color
     */
    public static Color fromHEX(String hex) {
        hex = hex.replace("#", "");
        switch (hex.length()) {
            case 6:
                return Color.fromRGB( Integer.valueOf(hex.substring(0, 2), 16), Integer.valueOf(hex.substring(2, 4), 16), Integer.valueOf(hex.substring(4, 6), 16));
            case 8:
                return Color.fromARGB( Integer.valueOf(hex.substring(0, 2), 16), Integer.valueOf(hex.substring(2, 4), 16), Integer.valueOf(hex.substring(4, 6), 16), Integer.valueOf(hex.substring(6, 8), 16));
        }
        return null;
    }

    /**
     * Parses a LiveKit Color from 8-bit rgb values (0-255).
     * @param r red
     * @param g green
     * @param b blue
     * @return LiveKit Color
     */
    public static Color fromRGB(int r, int g, int b) {
        return Color.fromARGB(Color.DEFAULT_ALPHA, r, g, b);
    }

    /**
     * Parses a LiveKit Color from 8-bit rgb values (0-255).
     * NOTE: Alpha channel is not always supported!
     * @param a alpha
     * @param r red
     * @param g green
     * @param b blue
     * @return
     */
    public static Color fromARGB(int a, int r, int g, int b) {
        Color color = new Color();
        color.a = a;
        color.r = r;
        color.g = g;
        color.b = b;
        return color;
    }

    /**
     * Utility method to pad string.
     * @param s string to pad
     * @return padded string
     */
    private static String pad(String s) {
        return (s.length() == 1) ? "0" + s : s;
    }
}
