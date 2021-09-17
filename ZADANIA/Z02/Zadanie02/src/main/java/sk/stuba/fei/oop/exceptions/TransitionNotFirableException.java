package sk.stuba.fei.oop.exceptions;

public class TransitionNotFirableException extends RuntimeException {

    public TransitionNotFirableException(long transitionId) {
        super("Prechod ["+transitionId+"] nie je spustitelny");
    }

}
