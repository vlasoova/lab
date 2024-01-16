package exceptions;

public class CannotBeBuriedException extends RuntimeException{
    public boolean isAlive;
    public CannotBeBuriedException(String message){
        super(message);
    }
}
