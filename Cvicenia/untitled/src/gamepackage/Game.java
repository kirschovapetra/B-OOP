package gamepackage;

import java.util.LinkedList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Player<Sword> p1 = new Knight("Jano", new Sword(10), 100);
        Player<Axe> p2 = new Barbarian("Fero", new Axe(6), 100);

        List<Player> players = new LinkedList<Player>();
        players.add(p1);
        players.add(p2);

        for (Player p : players) {
            if (p.ask() == 0) {
                p.attack();
            } else {
                p.useSkill();
            }
        }


    }
}
