package exceptions;

public class AlreadyAliveException extends RuntimeException{
    public AlreadyAliveException (String message){
        super(message);
    }
}
