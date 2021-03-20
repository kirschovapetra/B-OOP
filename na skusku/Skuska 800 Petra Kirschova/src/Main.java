import gui.CustomFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            CustomFrame frame = new CustomFrame();
        }
        catch(HeadlessException e){
            System.out.println(e);
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
