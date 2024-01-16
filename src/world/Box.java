package world;

public class Box extends Thing{
    private Status status;

    public Box(String name, int amount, Status status){
        super(name, amount);
        this.status = status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
