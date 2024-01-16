package world;

public class Place {
    private final String placeName;
    private int corner_1_x;
    private int corner_1_y;
    private int corner_2_x;
    private int corner_2_y;
    public Place(String placeName, int corner_1_x, int corner_1_y, int corner_2_x, int corner_2_y){
        this.placeName = placeName;
        this.corner_1_x = corner_1_x;
        this.corner_1_y = corner_1_y;
        this.corner_2_x = corner_2_x;
        this.corner_2_y = corner_2_y;
    }

    public int getCorner_1_x() {
        return corner_1_x;
    }

    public int getCorner_1_y() {
        return corner_1_y;
    }

    public int getCorner_2_x() {
        return corner_2_x;
    }

    public int getCorner_2_y() {
        return corner_2_y;
    }
    public String getPlaceName(){
        return placeName;
    }

    @Override
    public String toString(){
        return placeName;
    }
}
