package sk.stuba.fei.oop.cv3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Player player1;
    private Player player2;
    double lastHealth;

    private Player createRandomPlayer(int unwantedGameCharacter, String myName){
        int rnd=0;
        while(rnd != unwantedGameCharacter) {
            rnd = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        }
        return createPlayer(rnd,myName);
    }

    private Player createPlayer(int myGameCharacter, String myName){
        if(myGameCharacter==1){
            return new Knight(myName,new Sword(0.5,0.5));
        }
        else if (myGameCharacter==2){
            return new Barbarian(myName,new Axe(0.8));
        }
        else {
            return new Ranger(myName, new Bow(0.3, 0.9));
        }
    }

    private int chooseCharacterFromKeyb(){
        System.out.print("Vyberte si postavu: [1]Knight [2]Barbarian [3]Ranger > ");
        Scanner keyb = new Scanner(System.in);
        return keyb.nextInt();
    }

    private String chooseNameFromKeyb(){
        String name;
        System.out.print("Napiste meno pre Vasu postavu >");
        Scanner keyb = new Scanner(System.in);
        return keyb.next();
    }

    private int attackWithCoice(int choice, Player attacker, Player opponent){
        switch (choice){
            case 1:attacker.attackWithWeapon(opponent);
                return 1;
            case 2:attacker.attackWithSkill(opponent);
                return 2;
            case 'q':
                return -1;
            default:
                return 0;
        }
    }

    private void updateLastHealth(Player player){
        lastHealth=player.getHealth();
    }
    private double computeHealthLossPlayer(Player player){
        return lastHealth - player.getHealth();
    }

    public void getPlayerInfo(Player player){
        System.out.println("Name\t"+player.getName());
        System.out.println("Health\t"+player.getHealth());
        System.out.println("Weapon\t"+player.getWeapon());
        System.out.println("");
    }

    public void getInfoAfterCombat(Player player){
        System.out.println("Name\t"+player.getName());
        System.out.println("Health\t"+player.getHealth());
        System.out.println("");
    }


    public void start(){
        player1= createPlayer(chooseCharacterFromKeyb(),chooseNameFromKeyb());
        player2= createRandomPlayer(0,"Player2");
        getPlayerInfo(player1);
        getPlayerInfo(player2);

        int rnd;
        int choice=0;
        Scanner keyb = new Scanner(System.in);

        while (notFinished(choice)) {
            //taha player1
            System.out.print("utok[1] skill[2] quit[q] >");
            choice = keyb.nextInt();
            attack(choice, player1, player2);

            //taha player2
            rnd = ThreadLocalRandom.current().nextInt(1, 2 + 1);
            attack(choice, player2, player1);
        }
    }

    private boolean notFinished(int choice) {
        return (player1.getHealth()>0 && player2.getHealth()>0) || choice != 'q';
    }

    private void attack(int choice, Player player2, Player player1) {
        updateLastHealth(player2);
        attackWithCoice(choice, player2, player1);
        System.out.println("Utok ta stal:" + computeHealthLossPlayer(player1) + "% zivota");
        getInfoAfterCombat(player2);
    }
/*
        char choice=0;
        Sword sword = new Sword(0.5,0.8);
        Axe axe = new Axe(0.5);
        Knight knight = new Knight("Artus",sword);
        Barbarian barbarian = new Barbarian("Konan",axe);
        Random rnd = new Random();
        int count=0;
        while ((knight.getHealth()>0 && barbarian.getHealth()>0) || choice != 'q'){
            //taha player1
            System.out.println(count+". kolo");
            System.out.print(knight.getName() + " utoci: ");
            choice=Zklavesnice.readChar("utok[1] skill[2] quit[q]");
            switch (choice){
                case '1':knight.attackWithWeapon(barbarian);
                break;
                case '2':knight.attackWithSkill(barbarian);
                break;
                case 'q':
                    System.out.println("K O N I E C");
                    return;
            }
            System.out.format("%s=%1.2f%n",knight.getName(),knight.getHealth());
            System.out.format("%s=%1.2f%n",barbarian.getName(),barbarian.getHealth());
            System.out.println();

            //taha player2
            choice= (char) ((char)rnd.nextInt(('2'-'1')+1)+'1');
            System.out.println(barbarian.getName() + " utoci:["+choice+"]");

            switch (choice){
                case '1':barbarian.attackWithWeapon(knight);
                    break;
                case '2':barbarian.attackWithSkill(knight);
                    break;
                case 'q':
                    System.out.println("K O N I E C");
                    return;
            }
            System.out.format("%s=%1.2f%n",knight.getName(),knight.getHealth());
            System.out.format("%s=%1.2f%n",barbarian.getName(),barbarian.getHealth());
            System.out.println();

            count++;
        }

*/


}
