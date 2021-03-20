import java.awt.*;
import java.awt.event.*;
//checkbox group
public class MyFrame2 extends Frame implements ItemListener {
    private Checkbox check1;
    private Checkbox check2;
    private CheckboxGroup group;
    private TextField textField;
    private Panel panel;


    public MyFrame2(String title) throws HeadlessException {
        super(title);

        setSize(500,500);
        setLayout(new FlowLayout());

        group = new CheckboxGroup();
        check1 = new Checkbox("check1",group,true);
        check2 = new Checkbox("check2",group,true);

        check1.addItemListener(this);
        check2.addItemListener(this);

        textField = new TextField(10);
        panel = new Panel();

        panel.add(check1);
        panel.add(check2);
        add(panel);
        add(textField);


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
        if (e.getSource()==check1)
        {   textField.setText("AAA");
        }
        else if (e.getSource()==check2)
        {   textField.setText("BBB");
        }
    }
}
