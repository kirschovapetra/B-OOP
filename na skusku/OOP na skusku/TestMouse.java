import java.awt.*; 
import java.awt.event.*; 
class TestCanvas extends Canvas implements MouseListener, MouseMotionListener {
	public TestCanvas () {
		addMouseListener (this); 
		addMouseMotionListener(this);
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
		System.out.println( "Mauseklicked na suradnice "+e.getX()+","+e.getY()); 
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

public class TestMouse {
	public static void main (String args[]) {
		Frame f=new Frame(); 
		f.add(new TestCanvas()); 
		f.setSize(300,300); 
      f.setVisible(true); } } 
