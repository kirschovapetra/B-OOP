package cv10;



import cv6.MyCanvas3;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MyFrame extends Frame implements ActionListener,KeyListener,MouseListener {
    private Button b1;
    private Button b2;
    private Button b3;
    private Panel panel;
    private MyCanvas3 myCanvas;
    private List<KeyEvent> pressedKeys;

    public MyFrame() throws HeadlessException {
        setSize(500,500);
        setLayout(new BorderLayout());

        panel = new Panel();
        panel.setLayout(new FlowLayout());
        myCanvas = new MyCanvas3();
        pressedKeys = new LinkedList<>();

        b1 = new Button("A");
        b2 = new Button("B");
        b3 = new Button("C");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        add(panel,BorderLayout.PAGE_START);
        add(myCanvas,BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        myCanvas.addKeyListener(this);
        myCanvas.addMouseListener(this);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if  (e.getSource() == b1){
            System.out.println(b1.getLabel());
        }
        else if(e.getSource() == b2){
            System.out.println(b2.getLabel());
        }
        else if(e.getSource() == b3){
            System.out.println(b3.getLabel());
            try {
                sleep(1000);
                dispose();
                System.exit(0);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isAltDown() || e.isControlDown() || e.isShiftDown()) {
            keyPressed(e);
        }


    }


    public void keyReleased(KeyEvent e){
        int size = pressedKeys.size();
        if (size>=2){
            twoKeysPressed(pressedKeys.get(size - 2), pressedKeys.get(size - 1));
        }
    }

    public void twoKeysPressed(KeyEvent previous,KeyEvent now){
        if (previous.isControlDown()){
            System.out.println("pressed: CTRL+"+now.getKeyChar());
        }
        else if (previous.isShiftDown()){
            System.out.println("pressed: SHIFT+"+now.getKeyChar());
        }
        else if (previous.isAltDown()){
            System.out.println("pressed: ALT+"+now.getKeyChar());
        }
        else{
            System.out.println("pressed: "+now.getKeyChar());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            System.out.print("LEFT: ");
        }
        else if (e.getButton() == MouseEvent.BUTTON3){
            System.out.print("RIGHT: ");
        }
        System.out.println("coords: ("+e.getX()+", "+e.getY()+")");
        myCanvas.drawCircle((Graphics2D) myCanvas.getGraphics(),new Point2D.Double(e.getX(),e.getY()),15);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
