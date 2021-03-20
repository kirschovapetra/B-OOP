import java.awt.*;
import java.awt.event.*;

class TestFrame2 extends Frame  implements ColorEditListener  {
    ColorEdit CE = null;
    Color C;

    public TestFrame2 ()
    {   addWindowListener(
            new WindowAdapter ()
            {   public void windowClosing (WindowEvent e)
            {   dispose(); System.exit(0);
            }
            }
    );
        addMouseListener(
                new MouseAdapter ()
                {   public void mousePressed (MouseEvent e)
                {   coloredit();
                }
                }
        );

        C=Color.gray;
        setSize(400,400);
    }

    public void paint (Graphics g)
    {
        g.setColor(C);
        g.fillRect(0,0,getSize().width-1,getSize().height-1);
    }

    public void update (Graphics g)
    {   paint(g);
    }

    public void coloredit ()    {
        if (CE==null)
            CE=new ColorEdit(this,this,C);
    }


    public void setColor (Color c)
    {   C=c;
        repaint();
    }

    public void close ()
    {   CE=null;
    }
}


