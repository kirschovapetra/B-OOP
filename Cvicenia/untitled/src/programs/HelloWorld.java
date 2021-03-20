package programs;

import java.util.Scanner;

public class HelloWorld {
    public static int compare(int x, int y){
        if (x==y)
            return 0;
        return x>y? 1: -1;
    }


    public static void main(String[] args){
        System.out.println("Hello world!");
        System.out.println(compare(1,2));
        Scanner number = new Scanner(System.in);
        System.out.println("Zadaj 2 cisla:");
        int x = number.nextInt();
        int y = number.nextInt();
        System.out.println(x>y? x: y);

    }
}
