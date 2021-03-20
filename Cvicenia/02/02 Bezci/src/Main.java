import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        List<Runner> runners = new LinkedList<>();
        runners.add(new Runner("Jozef"));
        runners.add(new Runner("Fero"));

        for (Runner current:runners){
            current.set_velocity(Math.abs(new Random().nextInt(101)+350));
        }


        while (true) {
            for (Runner current:runners) {

                if (current.get_distance() % 50 == 0 &&
                        current.get_distance() > 0 &&
                        current.get_distance() < 400) {
                    current.set_velocity(0);
                }
                if (current.isFinished()) {
                    break;
                }
            }

        }
    }
}
