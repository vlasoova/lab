package creatures;

import interfaces.Die;
import world.Place;

public class Cat implements Die{
    private final String name;
    private double  health;
    private int x, y;
    public Cat(String name, double health, int x, int y){
        this.name = name;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setHealth(double health){
        this.health = health;
    }
    @Override
    public void die(){
        setHealth(0);
        System.out.printf("%n%s now is dead.", name);
    }
    public void move(int xGoTo, int yGoTo){
        while (x != xGoTo || y != yGoTo) {
            if (x != xGoTo) {
                x += (xGoTo > x) ? 1 : -1;
            }
            if (y != yGoTo) {
                y += (yGoTo > y) ? 1 : -1;
            }
        }
    }
    public void arrive(Place place){
        int xMoveTo = place.getCorner1X() + Math.abs((place.getCorner2X() - place.getCorner1X())/2);
        int yMoveTo = place.getCorner1Y() + Math.abs((place.getCorner2Y() - place.getCorner1Y())/2);
        move(xMoveTo, yMoveTo);
        System.out.printf("%n%s arrived to %s%n", name, place);
    }
}
