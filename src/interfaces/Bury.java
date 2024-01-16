package interfaces;

import creatures.Cat;
import creatures.humans.BuriedHuman;
import creatures.humans.Human;

public interface Bury {
    BuriedHuman bury(Human h);
    void bury(Cat c);
}
