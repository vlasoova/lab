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

    public void setHealth(double health){
        this.health = health;
    }
    @Override
    public void die(){
        setHealth(0);
        System.out.printf("%n%s now is dead.", name);
    }
    public void move(int x_go_to, int y_go_to){
        if (x<x_go_to && y<y_go_to){
            while (x < x_go_to)
                x++;
            while (y < y_go_to)
                y++;
        } else {
            while (x != x_go_to)
                x--;
            while (y != y_go_to)
                y--;
        }
    }
    public void arrive(Place place){
        int x_move_to = place.getCorner_1_x() + Math.abs((place.getCorner_2_x() - place.getCorner_1_x())/2);
        int y_move_to = place.getCorner_1_y() + Math.abs((place.getCorner_2_y() - place.getCorner_1_y())/2);
        move(x_move_to, y_move_to);
        System.out.printf("%n%s arrived to %s%n", name, place);
    }
}
