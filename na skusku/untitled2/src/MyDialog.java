import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyDialog extends Dialog implements AdjustmentListener {
    private Frame frame;
    private Panel redPanel = new Panel(),greenPanel = new Panel(),bluePanel = new Panel();
    private Scrollbar redBar = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
    private Scrollbar greenBar = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
    private Scrollbar blueBar = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,255);
    private Label redLabel = new Label(),greenLabel = new Label(),blueLabel = new Label();

    public MyDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        frame = owner;
        setSize(700, 200);
        setLayout(new GridLayout(3,1));
        redPanel.setLayout(new GridLayout(1,1));
        greenPanel.setLayout(new GridLayout(1,1));
        bluePanel.setLayout(new GridLayout(1,1));

        redBar.setSize(400,40);
        redPanel.add(new Label("RED"));
        redPanel.add(redBar);
        redPanel.add(redLabel);

        greenBar.setSize(400,40);
        greenPanel.add(new Label("GREEN"));
        greenPanel.add(greenBar);
        greenPanel.add(greenLabel);

        blueBar.setSize(400,40);
        bluePanel.add(new Label("BLUE"));
        bluePanel.add(blueBar);
        bluePanel.add(blueLabel);

        add(redPanel);add(greenPanel);add(bluePanel);

        redBar.addAdjustmentListener(this);
        greenBar.addAdjustmentListener(this);
        blueBar.addAdjustmentListener(this);



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource()==redBar){
            redLabel.setText(String.valueOf(redBar.getValue()));
        }
        if (e.getSource()==greenBar){
            greenLabel.setText(String.valueOf(greenBar.getValue()));
        }
        if (e.getSource()==blueBar){
            blueLabel.setText(String.valueOf(blueBar.getValue()));
        }
        frame.setBackground(new Color(redBar.getValue(),greenBar.getValue(),blueBar.getValue()));
        frame.repaint();
    }
}
