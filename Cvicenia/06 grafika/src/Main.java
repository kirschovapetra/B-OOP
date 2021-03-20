import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("Okno");
        frame.setSize(400,400);

        frame.setLayout(new BorderLayout());

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        Button button5 = new Button("OK");
        Button button6 = new Button("Cancel");

        Label label = new Label("Ahoj ako sa mas");

        Panel panel = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();

        panel2.setLayout(new GridLayout(1,1));
        panel3.setLayout(new GridLayout(1,2));
        panel4.setLayout(new GridLayout(2,1));
       // panel.setBackground(new Color(255,255,0));

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        panel2.add(label);
        panel3.add(button5);
        panel3.add(button6);

        panel4.add(panel2);
        panel4.add(panel3);

        //Canvas canvas = new Canvas();
        Canvas canvas = new CustomCanvas2();
        canvas.setBackground(new Color(255, 255,255));








        frame.add(canvas,BorderLayout.CENTER);


        frame.add(panel,BorderLayout.NORTH);
        frame.add(panel4,BorderLayout.SOUTH);










        frame.setVisible(true);


    }
}
