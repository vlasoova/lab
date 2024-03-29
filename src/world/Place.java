package world;

public class Place {
    private final String placeName;
    private final int corner1X;
    private final int corner1Y;
    private final int corner2X;
    private final int corner2Y;

    public Place(String placeName, int corner1X, int corner1Y, int corner2X, int corner2Y) {
        this.placeName = placeName;
        this.corner1X = corner1X;
        this.corner1Y = corner1Y;
        this.corner2X = corner2X;
        this.corner2Y = corner2Y;
    }

    public int getCorner1X() {
        return corner1X;
    }

    public int getCorner1Y() {
        return corner1Y;
    }

    public int getCorner2X() {
        return corner2X;
    }

    public int getCorner2Y() {
        return corner2Y;
    }

    public String getPlaceName() {
        return placeName;
    }

    @Override
    public String toString() {
        return placeName;
    }
}
