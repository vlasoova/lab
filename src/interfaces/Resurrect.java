package interfaces;

import creatures.Cat;
import creatures.humans.Human;

public interface Resurrect {
    void resurrect(Human h);

    void resurrect(Cat c);
}
