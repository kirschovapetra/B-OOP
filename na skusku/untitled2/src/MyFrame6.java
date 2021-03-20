import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyFrame6 extends Frame implements ItemListener, ActionListener {
    private String[] fonts;
    String[] styles = {"Normal", "Bold", "Italic", "B+I"};
    private Label label = new Label();
    private Choice choice1 = new Choice();
    private Choice choice2 = new Choice();
    private TextField textField = new TextField();
    private int size = 12;
    private Font f;

    private Panel panel = new Panel();

    public MyFrame6(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setLayout(new BorderLayout());


        panel.add(new Label("font:"));
        panel.add(choice1);
        panel.add(new Label("style:"));
        panel.add(choice2);
        panel.add(new Label("size:"));
        panel.add(textField);

        add(panel, BorderLayout.PAGE_START);
        add(label, BorderLayout.CENTER);

        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            choice1.addItem(font);
        }

        for (String style : styles) {
            choice2.addItem(style);
        }

        textField.addActionListener(this);
        choice1.addItemListener(this);
        choice2.addItemListener(this);

        f = new Font(choice1.getSelectedItem(),choice2.getSelectedIndex(),size);
        label.setFont(f);


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        f = new Font(choice1.getSelectedItem(), choice2.getSelectedIndex(), size);
        label.setFont(f);
        label.setText("I am a text: " + label.getFont().getName() + " " + styles[label.getFont().getStyle()] + " " + label.getFont().getSize());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            size = Integer.parseInt(textField.getText());
            f = new Font(choice1.getSelectedItem(), choice2.getSelectedIndex(), size);
            label.setFont(f);
            label.setText("I am a text: " + label.getFont().getName() + " " + styles[label.getFont().getStyle()] + " " + label.getFont().getSize());

        }
        catch (NumberFormatException ex) {
            size = 12;
            f = new Font(choice1.getSelectedItem(), choice2.getSelectedIndex(), size);
            label.setFont(f);
            label.setText("I am a text: " + label.getFont().getName() + " " + styles[label.getFont().getStyle()] + " " + label.getFont().getSize());

        }
    }
}
