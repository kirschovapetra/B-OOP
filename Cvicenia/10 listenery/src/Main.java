import java.awt.*;

public class Main {
    public static void main (String args[]) {

        //new TestFrame();
        Frame f=new Frame();
        f.add(new MyCanvas());
        f.setSize(500,500);
        f.setVisible(true);
    }
}
