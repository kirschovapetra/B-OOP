package pack1;

public class Main {
    public static void main(String[] args){
        try{
            Datum datum = new Datum(2,8,1998);
            System.out.println(datum.getDen() + " "+datum.getMesiac() +" "+ datum.getRok());
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
