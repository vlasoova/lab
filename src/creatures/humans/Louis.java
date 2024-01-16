package creatures.humans;

import world.Box;
import world.Food;
import world.Status;
import world.Thing;

import java.util.ArrayList;

public class Louis extends Human {
    public Louis(String name, double health, int x, int y, double saturation) {
        super(name, health, x, y, saturation);
    }
    public class Brain{
        ArrayList<String> Thoughts = new ArrayList<>();
        public void think(String thought){
            Thoughts.add(thought);
            int lastThought = Thoughts.size() - 1;
            System.out.printf("%n%s thought %s", getName(), Thoughts.get(lastThought));
            saturation -= 5;
        }
    }
    public class Hands{
        static ArrayList<Thing> hands = new ArrayList<>();
        public void receive(Box box){
            hands.add(box);
            int lastReceivedItem = hands.size() - 1;
            System.out.printf("%n%s received %s", getName(), hands.get(lastReceivedItem));
        }

        public void receive(Food pizza) {
            hands.add(pizza);
            int lastReceivedItem = hands.size() -1;
            System.out.printf("%n%s received %s", getName(), hands.get(lastReceivedItem));
        }
    }
    public void eat(Food food){

        Hands.hands.remove(food);
        setSaturation(100);
        System.out.printf("%n%s ate %s piece of %s.", getName(), food.getAmount(), food);
    }
    public void open(Box box){
        box.setStatus(Status.OPEN);
        System.out.printf("%n%s opened the box", getName());
    }
    public void throwAway(Thing item){
        Hands.hands.remove(item);
        System.out.printf("%n%s threw away %s.", getName(), item);
    }
}
