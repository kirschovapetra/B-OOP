//exceptions

public class Main {
    public static void main(String[] args) {
        //ArrayIndexOutOfBoundsException
        //String tmp = args[10];

        //NullPointerException
        //String b = null;
        //b.length();

        try {
            multiply_matrices(null, null);
        }
        //vykonava sa catch v pripade vynimky
        catch(IllegalArgumentException exception){
            //vypis
            exception.printStackTrace();
        }

        //checked
        try{
            setName(args[0]);
        }
        catch(IllegalNameException exception){
            exception.printStackTrace();
        }

    }
    public static void setName(String name) throws IllegalNameException {
        if (name==null  || name.length() == 0){
            //vlastna trieda
            throw new IllegalNameException();
        }
    }
    public static void multiply_matrices(int[][] first, int[][] second){
        //pocet riadkov prvej = pocet stlpcov druhej!

        if (first.length!=second[0].length){
            throw new IllegalArgumentException("Matice sa nedaju nasobit");
        }

    }
}
