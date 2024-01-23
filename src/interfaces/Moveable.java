package interfaces;

public interface Moveable {
    default void changeCoordinates(int x, int y, int xGoTo, int yGoTo) {
        while (x != xGoTo || y != yGoTo) {
            if (x != xGoTo) {
                x += (xGoTo > x) ? 1 : -1;
            }
            if (y != yGoTo) {
                y += (yGoTo > y) ? 1 : -1;
            }
        }
    }
}
