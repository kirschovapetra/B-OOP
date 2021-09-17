package exceptions;

public class TransitionNotFoundException extends RuntimeException{

    public TransitionNotFoundException(long transition_id) {
        super("Prechod s Id = "+transition_id+" neexistuje");
    }
}
