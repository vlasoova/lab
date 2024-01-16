package world;
public class Time {
    private int date;
    public Time(int date){
        this.date = date;
    }

    public void go(){
        int day = date++;
        System.out.println("Day " + day);
    }
}
