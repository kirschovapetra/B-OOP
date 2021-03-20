import java.awt.*;
import java.awt.event.*;

//checkbox
public class MyFrame3 extends Frame implements ItemListener {
    private Checkbox check1;
    private Checkbox check2;
    private TextField textField;
    private Panel panel;


    public MyFrame3(String title) throws HeadlessException {
        super(title);

        setSize(500, 500);
        setLayout(new FlowLayout());

        check1 = new Checkbox("check1", true);
        check2 = new Checkbox("check2", true);

        check1.addItemListener(this);
        check2.addItemListener(this);

        textField = new TextField(10);
        panel = new Panel();

        panel.add(check1);
        panel.add(check2);
        add(panel);
        add(textField);
        textField.setText(check1.getState() + " " + check2.getState());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }


    @Override
    public void itemStateChanged(ItemEvent e) {

        textField.setText(check1.getState() + " " + check2.getState());
    }

}
