import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ColorEdit extends Dialog  implements ActionListener{
    ColorScrollbar Red, Green, Blue;
    Color C,Cold;
    Panel CP;
    ColorEditListener CL;
    Button OK;
    Button Cancel;

    public ColorEdit (Frame F, ColorEditListener cl, Color c)
    {   super(F,"Edit Color", false);
        CL=cl;
        Cold=C=c;


        Panel p=new Panel();
        p.setLayout(new GridLayout(0,1));
        p.add(Red=new ColorScrollbar(this,"Red",C.getRed()));
        p.add(Green=new ColorScrollbar(this,"Green",C.getGreen()));
        p.add(Blue=new ColorScrollbar(this,"Blue",C.getBlue()));
        add("Center",p);


        Panel pb=new Panel();
        pb.add(OK=new Button("OK")); OK.addActionListener(this);
        pb.add(Cancel=new Button("Cancel")); Cancel.addActionListener(this);
        add("South",pb);


        CP=new Panel();
        CP.add(new Label("Your Color"));
        CP.setBackground(C);
        add("North",CP);

        pack();
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {   if (e.getSource() == Cancel)
    {   C=Cold; tell();
    }
        CL.close(); dispose();
    }

    public void setcolor ()
    {   C=new Color(Red.value(),Green.value(),Blue.value());
        CP.setBackground(C);
        CP.repaint();
        tell();
    }

    void tell ()
    {   CL.setColor(C);
    }
}
