import creatures.Cat;
import creatures.humans.*;
import world.*;



public class Main {
    public static void main(String[] args){
        Time day = new Time(19);
        Louis louis = new Louis("Louis",100, 0, 0, 100);
        Human pizzaman = new Human("Bob", 100, 3, 3, 100);
        Human gadge = new Human("Gadge", 100, 0, 0, 100);
        Human bill = new Human("Bill Butterman", 100, 1, 1, 100);
        Human timmy = new Human("Timmy Butterman", 100, 0, 0, 100);
        Human margory = new Human("Margory Washburn", 100, 7,1, 100);
        Human rachel = new Human("Rachel", 100, 7, 3, 100);
        Cat cherch = new Cat("Cherch", 100,7,3);
        Box box = new Box("box for pizza", 1, Status.CLOSED);
        Food pizza = new Food("Margarita", 1);

        Place graveyard = new Place("Old Indian graveyard", 0, 2, 2, 4);
        Place gadgeGrave = new Place("Gadge grave", 1, 4, 1, 4);
        Place pizzeria = new Place("Pizzeria", 2, 2, 4, 4);
        Place bangorStreet = new Place("street in Bangor", 0, 0, 4, 2);
        Place ludlowStreet = new Place("street in Ludlow", 6, 0, 8, 2);
        Place roadBangorLudlow = new Place("road from Ludlow to Bangor", 4, 0, 6, 4);
        Place home = new Place("home", 6, 2, 8, 4);
        Place roadToChicago = new Place("road to Chicago", 8, 0, 10, 4);
        Place chicagoStreet = new Place("Chicago", 10, 0, 14, 4);

        Car rachelCar = new Car(7, 1);
        Car.Door rachelCarDoor = rachelCar.new Door();
        Car louisCar = new Car(2, 1);
        Car.Windows louisCarWindows = louisCar.new Windows();
        Car.Door louisCarDoor = louisCar.new Door();

        day.go();
        timmy.die();

        day.go();
        day.go();

        day.go();
        bill.arrive(graveyard);
        bill.arrive(gadgeGrave);
        bill.carry(timmy, graveyard);
        bill.bury(timmy);
        bill.arrive(bangorStreet);

        day.go();
        rachelCar.addHuman(rachel);
        rachelCar.drive(rachel, ludlowStreet, roadToChicago);
        rachelCar.drive(rachel, roadToChicago, chicagoStreet);
        rachelCar.removeHuman(rachel);
        cherch.die();
        louis.arrive(graveyard);
        louis.carry(cherch, graveyard);
        louis.bury(cherch);
        louis.arrive(bangorStreet);

        day.go();
        gadge.die();

        day.go();
        bill.arrive(graveyard);
        bill.resurrect(timmy);

        day.go();
        timmy.arrive(ludlowStreet);
        margory.arrive(ludlowStreet);
        margory.look(timmy);

        day.go();
        louis.arrive(graveyard);
        louis.resurrect(cherch);

        day.go();
        rachel.open(rachelCarDoor);
        rachelCar.addHuman(rachel);
        rachel.close(rachelCarDoor);
        rachelCar.drive(rachel, chicagoStreet, ludlowStreet);
        rachel.open(rachelCarDoor);
        rachelCar.removeHuman(rachel);
        rachel.close(rachelCarDoor);
        rachel.arrive(home);

        day.go();
        louis.open(louisCarDoor);
        louisCar.addHuman(louis);
        louis.close(louisCarDoor);
        louisCar.drive(louis, ludlowStreet, roadBangorLudlow);
        louisCar.drive(louis, roadBangorLudlow, bangorStreet);
        louis.open(louisCarDoor);
        louisCar.removeHuman(louis);
        louis.close(louisCarDoor);
        louis.arrive(graveyard);
        louis.look(graveyard);
        louis.louisBrain.feel(Feeling.HORROR);
        Drawing drawing = louis.louisHands.draw(Shape.SPIRAL);
        drawing = louis.louisHands.erase(drawing);
        pizzaman.arrive(pizzeria);
        louis.arrive(bangorStreet);
        louis.arrive(pizzeria);
        louis.louisHands.receive(box);
        louis.arrive(bangorStreet);
        louis.open(louisCarDoor);
        louisCar.addHuman(louis);
        louis.close(louisCarDoor);
        louis.open(box);
        louis.louisHands.receive(pizza);
        louis.eat(pizza);
        louis.louisBrain.feel(Feeling.IRRITATION);
        louis.open(louisCarWindows);
        louis.throwAway(box);
        louis.close(louisCarWindows);
        louisCar.drive(louis, bangorStreet, roadBangorLudlow);
        louisCar.drive(louis, roadBangorLudlow, ludlowStreet);
        louis.louisBrain.think("about time");
    }
}
