package runnerspackage;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();

        int velocity1 = rand.nextInt()%101+350;

        Random rand2 = new Random();
        int velocity2 = rand2.nextInt()%101+350;

        Runner r1 = new Runner(0,velocity1,"Jano");
        Runner r2 = new Runner(0,velocity2,"Fero");

        List<Runner> runners = new LinkedList<Runner>();
        runners.add(r1);
        runners.add(r2);


        Run run = new Run(runners,10000);
        for (Runner r:run.getRunners()){r.printRunner();}

        while (!run.isFinished()){
            for (Runner r:run.getRunners()){
                r.move();
                if (r.isObstacle()){
                    r.setDistance(0);
                }
                r.updateVelocity();
                r.printRunner();
            }
            System.out.println();
        }

        run.printWinners(run.getWinners());
    }
}
