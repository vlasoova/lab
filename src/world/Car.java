package world;
import creatures.humans.Human;

import java.util.ArrayList;

public class Car {
    private final ArrayList<Human> humansInCar;
    private int x, y;

    public Car(int x, int y) {
        humansInCar = new ArrayList<>();
        this.x = x;
        this.y = y;
    }
    public class Door {
        public void setDoorStatus(Status status){
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
        while (x != xGoTo || y != yGoTo) {
            if (x != xGoTo) {
                x += (xGoTo > x) ? 1 : -1;
            }
            if (y != yGoTo) {
                y += (yGoTo > y) ? 1 : -1;
            }
        }
    }

    public void drive(Human human, Place fromPlace, Place toPlace) {
        int xMoveTo = toPlace.getCorner_1_x() + Math.abs((toPlace.getCorner_2_x() - toPlace.getCorner_1_x()) / 2);
        int yMoveTo = toPlace.getCorner_1_y() + Math.abs((toPlace.getCorner_2_y() - toPlace.getCorner_1_y()) / 2);
        human.move(xMoveTo, yMoveTo);
        move(xMoveTo, yMoveTo);
        System.out.printf("%n%s drove from %s to %s", human.getName(), fromPlace.getPlaceName(), toPlace.getPlaceName());
    }

}


