package creatures.humans;

import creatures.Cat;
import exceptions.AlreadyAliveException;
import exceptions.AlreadyDeadException;
import exceptions.CannotBeBuriedException;
import interfaces.Bury;
import interfaces.Die;
import interfaces.Resurrect;
import world.Car;
import world.Place;
import world.Status;


public class Human implements Die, Resurrect, Bury {
    private final String name;
    private double health;
    private double saturation;
    private int x, y;
    private Feeling feeling;


    public Human(String name, double health, int x, int y, double saturation) {
        this.name = name;
        this.health = health;
        this.x = x;
        this.y = y;
        this.saturation = saturation;
        feeling = Feeling.PEACE;
    }

    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public double getSaturation() {
        return saturation;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public void setHealth(double health){
        this.health = health;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    @Override
    public void die() throws AlreadyDeadException {
        if (getHealth() == 0) throw new AlreadyDeadException(String.format("Person %s is already dead", name));
        setHealth(0);
        System.out.printf("%n%s now is dead.%n", name);
    }
    @Override
    public  void resurrect(Human h) throws AlreadyAliveException {
        if (h.getHealth() != 0) throw new AlreadyAliveException(String.format("Person %s is already alive", name));
        h.setHealth(100);
        System.out.printf("%n%s now is alive.%n", name);
    }
    @Override
    public void resurrect(Cat c) throws AlreadyAliveException{
        if (c.getHealth() != 0) throw new AlreadyAliveException(String.format("Person %s is already alive", name));
        c.setHealth(100);
        System.out.printf("%n%s now is alive.%n", name);
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
        saturation -= 5;
    }
    public void arrive(Place place){
        int xMoveTo = place.getCorner1X() + Math.abs((place.getCorner2X() - place.getCorner1X())/2);
        int yMoveTo = place.getCorner1Y() + Math.abs((place.getCorner2Y() - place.getCorner1Y())/2);
        move(xMoveTo, yMoveTo);
        System.out.printf("%n%s arrived to %s.%n", name, place);
    }
    public void carry(Human h, Place place){
        h.arrive(place);
        System.out.printf("%n%s carried %s to %s.", getName(), h.getName(), place);
    }
    public void carry(Cat c, Place place){
        c.arrive(place);
        System.out.printf("%n%s carried %s to %s.", getName(), c.getName(), place);
    }
    public void look(Human human) {
        if (x == human.getX() & y == human.getY()){
            System.out.printf("%n%s saw %s.", name, human.name);
        } else {
            System.out.printf("%n%s didn't seen %s.", name, human.name);
        }
    }
    public void look(Place place) {
        if (x > place.getCorner1X() & x < place.getCorner2X() & y > place.getCorner1Y() & y < place.getCorner2Y()){
            System.out.printf("%n%s looked at %s.", name, place.getPlaceName());
        } else {
            System.out.printf("%n%s didn't look at %s.", name, place.getPlaceName());
        }
    }
    public void open(Car.Windows window){
        window.setWindowStatus(Status.OPEN);
        System.out.printf("%n%s opened the window.", name);
    }
    public void close(Car.Windows window){
        window.setWindowStatus(Status.CLOSED);
        System.out.printf("%n%s closed the window.", name);
    }
    public void open(Car.Door door){
        door.setDoorStatus(Status.OPEN);
        System.out.printf("%n%s opened the door.", name);
    }
    public void close(Car.Door door){
        door.setDoorStatus(Status.CLOSED);
        System.out.printf("%n%s closed the door.", name);
    }
    public BuriedHuman bury(Human h) throws CannotBeBuriedException {
        return new BuriedHuman(h);
    }
    public void bury(Cat c) throws CannotBeBuriedException {

    }
}