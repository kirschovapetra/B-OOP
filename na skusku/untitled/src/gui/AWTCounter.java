package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame implements ActionListener {
    private Button buttonUp;
    private Button buttonDown;
    private Button buttonFact;

    private Label label;
    private Label label2;
    private Label label3;

    private TextField textField;
    private TextField textFieldFact;
    private TextField textFieldSum;

    private Panel panel;
    private Panel panel2;
    private Panel panel3;

    private int num = 0;
    private int sum = 0;

    public AWTCounter(String title) throws HeadlessException {
        super(title);
        setSize(400,200);
        buttonUp = new Button("Up");
        buttonDown = new Button("Down");
        buttonFact = new Button("Factorial");

        label = new Label("Num");
        label2 = new Label("Fact");
        label3 = new Label("Sum");

        textField = new TextField(5);
        textFieldFact = new TextField(5);
        textFieldFact.setEditable(false);
        textFieldSum = new TextField(5);
        textFieldSum.setEditable(false);

        panel = new Panel();
        panel2 = new Panel();
        panel3 = new Panel();

        panel.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());

        buttonUp.addActionListener(this);
        buttonDown.addActionListener(this);
        buttonFact.addActionListener(this);
        textField.addActionListener(this);

        //exit
        this.addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       dispose();
                                       System.exit(0);
                                   }
                               }
        );

        panel.add(label);
        panel.add(textField);
        panel.add(buttonUp);
        panel.add(buttonDown);

        panel2.add(label2);
        panel2.add(textFieldFact);
        panel2.add(buttonFact);

        panel3.add(label3);
        panel3.add(textFieldSum);

        setLayout(new GridLayout(3,1));
        add(panel);
        add(panel2);
        add(panel3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonUp) {
            num++;
            sum+=num;
            textField.setText(String.valueOf(num));
        }
        if (e.getSource()==buttonDown){
            num--;
            sum+=num;
            textField.setText(String.valueOf(num));
        }
        if (e.getSource()==buttonFact){
            textFieldFact.setText(String.valueOf(factorial(num)));
        }
        if (e.getSource() == textField){
            num = Integer.parseInt(textField.getText());
            sum+=num;
        }
        label3.setText(String.valueOf(sum));
    }

    public double factorial(int n){
        if (n==1){
            return n;
        }
        else{
            return n*factorial(n-1);
        }
    }
}
