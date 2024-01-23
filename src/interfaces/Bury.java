package interfaces;

import creatures.BuriedCat;
import creatures.Cat;
import creatures.humans.BuriedHuman;
import creatures.humans.Human;

public interface Bury {
    BuriedHuman bury(Human h);

    BuriedCat bury(Cat c);
}
