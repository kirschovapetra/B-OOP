import java.io.*;

public class FileTest1 {
    public static void main (String args[])
    {   // get the file.txt file
        File file=new File("file.txt");
        if (file.exists() && !file.isDirectory())
        {   System.out.println("Subor "+file.getName()+" najdeny");
            System.out.println("Cela cesta: "+file.getAbsolutePath());
        }
    }
}
