import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("Animacia");
        Canvas canvas = new MyCanvas();
        frame.setSize(500,500);

        frame.add(canvas);

        frame.setVisible(true);
    }
}
