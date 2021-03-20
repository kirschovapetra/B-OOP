package sk.stuba.fei.oop.exceptions;

public class IllegalIdException extends RuntimeException {

    public IllegalIdException(long id) {
        super("ID = "+id+"sa neda pouzit");
    }

}
