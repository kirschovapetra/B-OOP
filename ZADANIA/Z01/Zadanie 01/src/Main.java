import exceptions.TransitionNotFirableException;
import exceptions.TransitionNotFoundException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException, TransitionNotFirableException, TransitionNotFoundException, UnsupportedOperationException {

        try {
            PetriNet petrinet = new PetriNet(); //vytvorenie prazdnej PS
            petrinet.makePetriNet(); //naplnenie PS podla obrazku v zadani
            //petrinet.show(); //vypis;
        }

        catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }

        catch (TransitionNotFirableException exception) {
            System.out.println(exception);
        }

        catch (TransitionNotFoundException exception) {
            System.out.println(exception);
        }

        catch (UnsupportedOperationException exception) {
            System.out.println(exception);
        }
    }
}
