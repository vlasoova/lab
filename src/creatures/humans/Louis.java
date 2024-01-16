package creatures.humans;

import world.*;

import java.util.ArrayList;

public class Louis extends Human {
    public Brain louisBrain;
    public Hands louisHands;
    public Louis(String name, double health, int x, int y, double saturation) {
        super(name, health, x, y, saturation);
        louisBrain =new Brain();
        louisHands =new Hands();
    }
    public class Brain{
        ArrayList<String> Thoughts = new ArrayList<>();
        public void think(String thought){
            Thoughts.add(thought);
            int lastThought = Thoughts.size() - 1;
            System.out.printf("%n%s thought %s", getName(), Thoughts.get(lastThought));
        }
        public void feel(Feeling feeling){
            setFeeling(feeling);
            System.out.printf("%n%s now is feeling %s", getName(), getFeeling());
        }
    }
    public class Hands{
        ArrayList<Thing> hands = new ArrayList<>();
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
        public Drawing draw(Shape shape){
            System.out.printf("%n%s draw %s.", getName(), shape);
            return new Drawing(shape);
        }
        public Drawing erase(Drawing drawing){
            System.out.printf("%n%s erased %s.", getName(), drawing);
            return null;
        }
    }
    public void eat(Food food){
        if (getSaturation() < 100) {
            louisHands.hands.remove(food);
            setSaturation(getSaturation() + 20);
            System.out.printf("%n%s ate %s piece of %s.", getName(), food.getAmount(), food);
        } else {
            System.out.printf("%n%s doesn't want to eat.", getName());
        }
    }
    public void open(Box box){
        box.setStatus(Status.OPEN);
        System.out.printf("%n%s opened the box", getName());
    }
    public void throwAway(Thing item){
        louisHands.hands.remove(item);
        System.out.printf("%n%s threw away %s.", getName(), item);
    }
}
