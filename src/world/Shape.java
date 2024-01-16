package world;

public enum Shape {
    SPIRAL ("spiral");
    private String shape;
    Shape(String shape) {
        this.shape = shape;
    }
    @Override
    public String toString(){
        return shape;
    }
}
