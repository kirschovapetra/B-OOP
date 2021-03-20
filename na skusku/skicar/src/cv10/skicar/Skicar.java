package cv10.skicar;

import cv10.skicar.buttons.LineButton;
import cv10.skicar.buttons.EllipseButton;
import cv10.skicar.buttons.EraseButton;
import cv10.skicar.buttons.RectangleButton;
import cv10.skicar.listeners.LineAdapter;
import cv10.skicar.listeners.EllipseAdapter;
import cv10.skicar.listeners.EraseAdapter;
import cv10.skicar.listeners.RectangleAdapter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Skicar extends Frame implements ActionListener {
    private SkicarCanvas canvas;
    private LineButton lineButton;
    private EraseButton eraseButton;
    private RectangleButton rectangleButton;
    private EllipseButton ellipseButton;
    private Button resetButton;
    private Panel panel;

    public Skicar() throws HeadlessException {
        setSize(700,700);
        setLayout(new BorderLayout());

        canvas = new SkicarCanvas();
        panel = new Panel();

        panel.setLayout(new FlowLayout());

        lineButton = new LineButton("Draw",new LineAdapter(canvas));
        eraseButton = new EraseButton("Erase",new EraseAdapter(canvas));
        ellipseButton = new EllipseButton("Ellipse",new EllipseAdapter(canvas));
        rectangleButton = new RectangleButton("Rectangle",new RectangleAdapter(canvas));
        resetButton = new Button("Reset");


        panel.add(lineButton);
        panel.add(eraseButton);
        panel.add(ellipseButton);
        panel.add(rectangleButton);
        panel.add(resetButton);

        add(panel,BorderLayout.PAGE_START);
        add(canvas,BorderLayout.CENTER);


        lineButton.addActionListener(this);
        eraseButton.addActionListener(this);
        ellipseButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        resetButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       dispose();
                                       System.exit(0);
                                   }
                               }
        );

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lineButton){
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(lineButton.getLineAdapter());
        }
        if (e.getSource() == eraseButton){
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(eraseButton.getEraseAdapter());
        }
        if (e.getSource() == ellipseButton){
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(ellipseButton.getEllipseAdapter());
        }
        if (e.getSource() == rectangleButton){
            canvas.removeAllMouseListeners();
            canvas.addMouseListener(rectangleButton.getRectangleAdapter());
        }
        if (e.getSource() == resetButton){
            canvas.removeAllMouseListeners();
            canvas.reset();
        }

    }
}
