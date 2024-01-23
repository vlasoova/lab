package creatures.humans;

import exceptions.CannotBeBuriedException;

public class BuriedHuman extends Human {
    public BuriedHuman(Human human) throws CannotBeBuriedException {
        super(human.getName(), human.getHealth(), human.getX(), human.getY());
        if (human.getHealth() != 0) throw new CannotBeBuriedException(String.format("Person %s is alive.", getName()));
    }
}
