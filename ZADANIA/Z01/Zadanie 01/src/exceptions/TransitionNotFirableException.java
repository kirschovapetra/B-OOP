package exceptions;

public class TransitionNotFirableException extends RuntimeException {

    public TransitionNotFirableException(long transition_id) {
        super("Prechod ["+transition_id+"] nie je spustitelny");
    }

}
