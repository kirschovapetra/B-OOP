import sk.oop.pr2.*;

public class HelloWorld {
    public static int porovnaj(Integer x, Integer y){
        if (x>y){
            return 1;
        }
        else if (x==y){
            return 0;
        }
        else{
            return -1;
        }
    }
    public static void horoskop(Integer d, Integer m){
        switch (m) {
            case 1:
                if (d<=20){
                    System.out.println("Kozorozec");
                }
                else{
                    System.out.println("Vodnar");
                }
                break;
            case 2:
                if (d<=18){
                    System.out.println("Vodnar");
                }
                else{
                    System.out.println("Ryby");
                }
                break;
            case 3:
                if (d<=20){
                    System.out.println("Ryby");
                }
                else{
                    System.out.println("Baran");
                }
                break;
            case 4:
                if (d<=20){
                    System.out.println("Baran");
                }
                else{
                    System.out.println("Byk");
                }
                break;
            case 5:
                if (d<=20){
                    System.out.println("Byk");
                }
                else{
                    System.out.println("Blizenci");
                }
                break;
            case 6:
                if (d<=20){
                    System.out.println("Blizenci");
                }
                else{
                    System.out.println("Rak");
                }
                break;
            case 7:
                if (d<=22){
                    System.out.println("Rak");
                }
                else{
                    System.out.println("Lev");
                }
                break;
            case 8:
                if (d<=22){
                    System.out.println("Lev");
                }
                else{
                    System.out.println("Panna");
                }
                break;
            case 9:
                if (d<=22){
                    System.out.println("Panna");
                }
                else{
                    System.out.println("Vahy");
                }
                break;
            case 10:
                if (d<=23){
                    System.out.println("Vahy");
                }
                else{
                    System.out.println("Skorpion");
                }
                break;
            case 11:
                if (d<=22){
                    System.out.println("Skorpion");
                }
                else{
                    System.out.println("Strelec");
                }
                break;
            case 12:
                if (d<=21){
                    System.out.println("Strelec");
                }
                else{
                    System.out.println("Kozorozec");
                }
                break;
        }
    }


    public static void main(String  []args){
        System.out.println("Hello worlddd!");
        Integer x = Zklavesnice.readInt("Napis x");
        Integer y = Zklavesnice.readInt("Napis y");
        Integer je = porovnaj(x,y);
        if (je==1){
            System.out.println(x);
        }
        Integer d = Zklavesnice.readInt("Napis d");
        Integer m = Zklavesnice.readInt("Napis m");
        horoskop(d,m);
    }
}
