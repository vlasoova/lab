package creatures.humans;

public enum Feeling {
    HORROR ("horror"),
    IRRITATION ("irritation"),
    PEACE ("peace");
    private String feeling;
    Feeling(String feeling) {
        this.feeling = feeling;
    }
}
