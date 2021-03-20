import java.awt.*;
import java.awt.event.*;

class TestCanvas extends Canvas implements KeyListener, MouseListener, MouseMotionListener {
    public TestCanvas () {
        addKeyListener(this);
        addMouseListener (this);
        addMouseMotionListener(this);
    }
    public void keyPressed (KeyEvent e){
        if (e.isActionKey())
            System.out.println("keyPressed zavolane - Action-Key : "+e.getKeyCode());
        if (e.isShiftDown()){
            System.out.println("twoKeysPressed zavolane Shift + "+e.getKeyChar());
        }
        if (e.isAltDown()){
            System.out.println("twoKeysPressed zavolane Alt ohrrf+ "+e.getKeyChar());
        }
        if (e.isControlDown()){
            System.out.println("twoKeysPressed zavolane Ctrl + "+e.getKeyChar());
        }
    }
    public void keyReleased (KeyEvent e){
        System.out.println("keyReleased zavolane - Released code: " +e.getKeyCode()+ "\n");
    }
    public void keyTyped (KeyEvent e){
        System.out.println("keyTyped zavolane - Character : "+e.getKeyChar());
    }

    // Metody MouseListener
    public void mousePressed (MouseEvent e) {
        System.out.println(e);
    }
    public void mouseReleased (MouseEvent e)  {
        System.out.println(e);
    }
    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
        if (e.getButton() == MouseEvent.BUTTON1){
            System.out.println( "Mauseklicked LEFT na suradnice "+e.getX()+","+e.getY());
        }
        else if (e.getButton() == MouseEvent.BUTTON2){
            System.out.println( "Mauseklicked KOLECKO na suradnice "+e.getX()+","+e.getY());
        }
        else if (e.getButton() == MouseEvent.BUTTON3){
            System.out.println( "Mauseklicked RIGHT na suradnice "+e.getX()+","+e.getY());
        }
    }
    public void mouseEntered (MouseEvent e) {
        System.out.println(e);
    }
    public void mouseExited (MouseEvent e) {
        System.out.println(e);
    }
    public void mouseMoved (MouseEvent e) {
        System.out.println("hybem sa");
    }
    public void mouseDragged (MouseEvent e) {
        System.out.println("som stlaceny a sa hybem");
    }
}