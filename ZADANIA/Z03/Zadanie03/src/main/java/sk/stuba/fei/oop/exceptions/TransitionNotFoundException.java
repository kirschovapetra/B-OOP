package sk.stuba.fei.oop.exceptions;

public class TransitionNotFoundException extends RuntimeException{

    public TransitionNotFoundException(long transitionId) {
        super("Prechod s Id = "+transitionId+" neexistuje");
    }
}
