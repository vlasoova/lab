package world;

public enum Shape {
    SPIRAL("spiral");
    private final String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return shape;
    }
}
