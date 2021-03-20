//vlastna vynimkova trieda
/*
 ak extends Exception - checked - musia byt osetrene,treba throws,
 ak extends RuntimeException - unchecked - netreba osetrovat, netreba throws, ale try-catch pouziivat!
 */

public class IllegalNameException extends Exception {
    public IllegalNameException() {
        super("Nemozes nastavit prazdne  meno");
    }
}
