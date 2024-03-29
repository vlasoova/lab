package world;

import creatures.humans.Human;
import interfaces.Moveable;

import java.util.ArrayList;

public class Car implements Moveable {
    private final ArrayList<Human> humansInCar;
    private final int x, y;

    public Car(int x, int y) {
        humansInCar = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public class Door {
        private Status status;

        public void setDoorStatus(Status status) {
            this.status = status;
        }
    }

    public class Windows {
        private Status status;

        public void setWindowStatus(Status status) {
            this.status = status;
        }
    }


    public void addHuman(Human h) {
        humansInCar.add(h);
        System.out.printf("%n%s sit in car.", h.getName());
    }

    public void removeHuman(Human h) {
        humansInCar.remove(h);
        System.out.printf("%n%s went out of car.", h.getName());
    }

    public void move(int xGoTo, int yGoTo) {
        changeCoordinates(this.x, this.y, xGoTo, yGoTo);
    }

    public void drive(Human human, Place fromPlace, Place toPlace) {
        int xMoveTo = toPlace.getCorner1X() + Math.abs((toPlace.getCorner2X() - toPlace.getCorner1X()) / 2);
        int yMoveTo = toPlace.getCorner1Y() + Math.abs((toPlace.getCorner2Y() - toPlace.getCorner1Y()) / 2);
        human.move(xMoveTo, yMoveTo);
        move(xMoveTo, yMoveTo);
        System.out.printf("%n%s drove from %s to %s", human.getName(), fromPlace.getPlaceName(), toPlace.getPlaceName());
    }

}


