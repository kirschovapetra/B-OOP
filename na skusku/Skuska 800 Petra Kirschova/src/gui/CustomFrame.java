package gui;

import buttons.ChangeColorButton;
import buttons.CrossButton;
import buttons.LineButton;
import listeners.ChangeColorListener;
import listeners.CrossButtonListener;
import listeners.LineButtonListener;

import java.awt.*;
import java.awt.event.*;

public class CustomFrame extends Frame implements ActionListener, ItemListener {
    private LineButton lineButton;
    private CrossButton crossButton;
    private ChangeColorButton changeColorButton;
    private CustomCanvas canvas;
    private Panel panel;
    private Choice colorChoice;
    private Label label;

    private String colors[] = {"black","red","green","blue"};

    public CustomFrame() throws HeadlessException {
        super("Kreslenie");
        setSize(500,500);
        setLayout(new BorderLayout());

        //vytvorenie objektov
        canvas = new CustomCanvas();
        lineButton = new LineButton(new LineButtonListener(canvas));
        crossButton = new CrossButton(new CrossButtonListener(canvas));
        changeColorButton = new ChangeColorButton(new ChangeColorListener(canvas));
        panel = new Panel(new GridLayout(1,4));
        label = new Label();

        colorChoice = new Choice();
        for (String color: colors){
            colorChoice.addItem(color);
        }
        label.setBackground(assignColor(colorChoice.getSelectedItem()));

        panel.add(crossButton);
        panel.add(lineButton);
        panel.add(colorChoice);
        panel.add(label);



         add(panel,BorderLayout.PAGE_START);
         add(canvas,BorderLayout.CENTER);
         add(changeColorButton,BorderLayout.PAGE_END);



        lineButton.addActionListener(this);
        crossButton.addActionListener(this);
        changeColorButton.addActionListener(this);
        colorChoice.addItemListener(this);
        //exit
        addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       dispose();
                                       System.exit(0);
                                   }
                               }
        );

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==crossButton) {
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(crossButton.getCrossButtonListener());
            canvas.addMouseMotionListener(crossButton.getCrossButtonListener());
        }
        else if (e.getSource()==lineButton) {
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(lineButton.getLineButtonListener());
            canvas.addMouseMotionListener(lineButton.getLineButtonListener());
        }
        else if (e.getSource()==changeColorButton) {
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(changeColorButton.getChangeColorListener());
            canvas.addMouseMotionListener(changeColorButton.getChangeColorListener());
        }


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String selectedColor = colorChoice.getSelectedItem();
        canvas.setColor(assignColor(selectedColor));
        label.setBackground(assignColor(selectedColor));
    }


    public Color assignColor(String colorName) {
        Color color = new Color(0,0,0);
        switch (colorName.toLowerCase()) {
            case "black":
                color = Color.BLACK;
                break;
            case "blue":
                color = Color.BLUE;
                break;
            case "cyan":
                color = Color.CYAN;
                break;
            case "darkgray":
                color = Color.DARK_GRAY;
                break;
            case "gray":
                color = Color.GRAY;
                break;
            case "green":
                color = Color.GREEN;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;
            case "lightgray":
                color = Color.LIGHT_GRAY;
                break;
            case "magneta":
                color = Color.MAGENTA;
                break;
            case "orange":
                color = Color.ORANGE;
                break;
            case "pink":
                color = Color.PINK;
                break;
            case "red":
                color = Color.RED;
                break;
            case "white":
                color = Color.WHITE;
                break;
        }
        return color;
    }
}
