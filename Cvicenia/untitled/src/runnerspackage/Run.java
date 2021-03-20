package runnerspackage;

import java.util.LinkedList;
import java.util.List;

public class Run {
    private List<Runner> runners;
    private int dist;

    public Run(List<Runner> runners, int dist) {
        this.runners = runners;
        this.dist = dist;
    }
    public List<Runner> getRunners() {
        return runners;
    }
    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }
    public int getDist() {
        return dist;
    }
    public void setDist(int dist) {
        this.dist = dist;
    }

    public List<Runner> getWinners(){
        List<Runner> winners = new LinkedList<Runner>();
        for (Runner r:runners){
            if (r.getDistance()>=dist){
                winners.add(r);
            }
        }
        return winners;
    }
    public void printWinners(List<Runner> winners){
        if (winners.size()>1){
            System.out.println("REMIZA:");
            for (Runner w:winners){w.printRunner();}
        }
        else if (winners.size()==1){
            System.out.println("VITAZOM SA STAVA:");
            winners.get(0).printRunner();
        }
        else{
            System.out.println("NIE JE ZIADNY VITAZ");
        }
    }
    public boolean isFinished(){
        for (Runner r:runners){
            if (r.getDistance()>=dist)
                return true;
        }
        return false;
    }
}
