package cv7;

import java.awt.*;


public class MainOld {
    public static void mainOld(String[] args){
        Frame frame = new Frame();
        frame.setSize(700,500);
        Panel panel = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Label label = new Label("Ako sa mas");
        MyCanvas5 myCanvas = new MyCanvas5();

        Button b1 = new Button("T1");
        Button b2 = new Button("T2");
        Button b3 = new Button("T3");
        Button b4 = new Button("T4");
        Button b5 = new Button("OK");
        Button b6 = new Button("Cancel");

        panel.setLayout(new FlowLayout());
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);

        frame.setLayout(new BorderLayout());

        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(myCanvas,BorderLayout.CENTER);

        panel2.setLayout(new BorderLayout());
        panel2.add(label,BorderLayout.PAGE_START);

        panel3.setLayout(new GridLayout(1,2));
        panel3.add(b5);
        panel3.add(b6);
        panel2.add(panel3,BorderLayout.PAGE_END);

        frame.add(panel2,BorderLayout.PAGE_END);


        frame.setVisible(true);

    }
}
