public enum Color
{
    CRIMSON(0xDC143C),
    VIOLET(0x7F00FF),
    BEIGE(0xF5F5DC),
    SILVER(0xC0C0C0);

    private final int color;

    private Color(int color)
    {
        this.color = color;
    }

    public int asInt()
    {
        return color;
    }

    @Override
    public String toString()
    {
        return name() + " (0x" + Integer.toHexString(color).toUpperCase() + ")";
    }
}