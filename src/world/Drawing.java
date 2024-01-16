package world;

public class Drawing {
    private Shape shape;
    public Drawing(Shape shape){
        this.shape = shape;
    }
    @Override
    public String toString(){
        return String.format("%s", shape);
    }
}
