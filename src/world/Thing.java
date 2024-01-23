package world;

public abstract class Thing {
    private final String name;
    private final int amount;

    public Thing(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name;
    }
}
