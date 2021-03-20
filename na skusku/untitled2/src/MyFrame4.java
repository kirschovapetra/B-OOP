import java.awt.*;
import java.awt.event.*;

//choice, list
public class MyFrame4 extends Frame implements ItemListener{
    private Choice choice;
    private List list;
    private String[] strings = {"AAA","BBB","CCC"};
    private TextField textField;
    private TextField textField2;

    public MyFrame4(String title) throws HeadlessException {
        super(title);

        setSize(500, 500);
        setLayout(new FlowLayout());

        choice = new Choice();
        list = new List(10,false);

        choice.addItem(strings[0]);choice.addItem(strings[1]);choice.addItem(strings[2]);
        list.add(strings[0]);list.add(strings[1]);list.add(strings[2]);

        textField = new TextField(10);
        textField2 = new TextField(10);



        add(choice);
        add(list);
        add(textField);
        //add(textField2);

        choice.addItemListener(this);
        list.addItemListener(this);

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
        if (e.getSource() == choice) {
            list.select(2-choice.getSelectedIndex());
        }
        else if(e.getSource() == list){
            choice.select(2-list.getSelectedIndex());
        }
    }
}
