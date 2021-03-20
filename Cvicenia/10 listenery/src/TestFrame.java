import java.awt.*;
import java.awt.event.*;

class TestFrame extends Frame implements ActionListener {
    String close="Close";
    Button b;
    Button b2;
    Button b3;

    public TestFrame(){
        super("Test Frame");
        setSize(300,300);

        Panel p=new Panel(new FlowLayout()); // Panel pre Button
        b=new Button(close);
        b2=new Button("A");
        b3=new Button("B");

        b.addActionListener(this); // Sam je Event-Listener
        b2.addActionListener(this);
        b3.addActionListener(this);
        p.add(b); // Button in Panel
        p.add(b2);
        p.add(b3);
        add(p); // Panel v Okne
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == b) {
            dispose();
            System.exit(0); // Koniec
        }
        if (e.getSource() == b2) {
            System.out.println(e.getActionCommand());
        }
        if (e.getSource() == b3) {
            System.out.println(e.getActionCommand());
        }
    }
}

