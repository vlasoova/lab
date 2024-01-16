package world;

public enum Status {
    OPEN("opened"),
    CLOSED("closed");
    private final String description;
    Status(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return this.description;
    }
}
