package programs;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Date date, date2, date3;
        try {
            date = new Date(28, 1, 1998);
            date2 = new Date(27, 2, 1005);
            date3 = new Date(30, 4, 2019);
            date.printDate();
            date2.printDate();
            date3.printDate();




        } catch (IllegalArgumentException msg) {
            System.out.println(msg);
        }

    }
}
