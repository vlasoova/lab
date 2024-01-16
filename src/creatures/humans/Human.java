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
    double saturation;
    private int x, y;


    public Human(String name, double health, int x, int y, double saturation) {
        this.name = name;
        this.health = health;
        this.x = x;
        this.y = y;
        this.saturation = saturation;
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

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    @Override
    public void die() throws AlreadyDeadException {
        if (getHealth() > 0) {
            setHealth(0);
            System.out.printf("%n%s now is dead.%n", name);
        } else {
            throw new AlreadyDeadException("Person is already dead.");
        }
    }
    @Override
    public  void resurrect(Human h) throws AlreadyAliveException {
        if (h.getHealth() == 0) {
            h.setHealth(100);
            System.out.printf("%n%s now is alive.%n", name);
        } else {
            throw new AlreadyAliveException("Person is already alive.");
        }
    }
    @Override
    public void resurrect(Cat c) throws AlreadyAliveException{
        if (c.getHealth() == 0) {
            c.setHealth(100);
            System.out.printf("%n%s now is alive", name);
        } else {
            throw new AlreadyAliveException("Cat is already alive.");
        }
    }
    public void move(int x_go_to, int y_go_to){
        while (x != x_go_to || y != y_go_to) {
            if (x != x_go_to) {
                x += (x_go_to > x) ? 1 : -1;
            }
            if (y != y_go_to) {
                y += (y_go_to > y) ? 1 : -1;
            }
        }

    }
    public void arrive(Place place){
        int x_move_to = place.getCorner_1_x() + Math.abs((place.getCorner_2_x() - place.getCorner_1_x())/2);
        int y_move_to = place.getCorner_1_y() + Math.abs((place.getCorner_2_y() - place.getCorner_1_y())/2);
        move(x_move_to, y_move_to);
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
    public void bury(Human h) throws CannotBeBuriedException {
        try{
            
            System.out.printf("%n%s buried %s", name, h.getName());
        } catch (CannotBeBuriedException e){
            System.err.printf("%n%s cannot be buried.", h.name);
        }
    }
    public void bury(Cat c) throws CannotBeBuriedException {
        try {
            //h.getHealth() != 0
            System.out.printf("%n%s buried %s", name, c.getName());
        } catch (CannotBeBuriedException e) {
            System.err.printf("%s cannot be buried.", c.getName());
        }
    }
}