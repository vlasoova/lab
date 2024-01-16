package creatures;

import exceptions.CannotBeBuriedException;

public class BuriedCat extends Cat{
    public BuriedCat(Cat cat) throws CannotBeBuriedException {
        super(cat.getName(), cat.getHealth(), cat.getX(), cat.getY());
        if (cat.getHealth() != 0) throw new CannotBeBuriedException(String.format("Cat %s is alive.", getName()));
    }
}
