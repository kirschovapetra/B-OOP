import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

class ColorScrollbar extends Panel implements AdjustmentListener {
    public int Value;
    ColorEdit CE;
    Scrollbar SB;

    public ColorScrollbar (ColorEdit ce, String s, int value)
    {   CE=ce;
        Value=value;
        setLayout(new GridLayout(1,0));
        add(new Label(s)); // links das Label
        add(SB=new Scrollbar(Scrollbar.HORIZONTAL,value,40,0,255));
        SB.addAdjustmentListener(this);
    }

    public void adjustmentValueChanged (AdjustmentEvent e)
    {   Value=SB.getValue(); // lies neuen Wert
        CE.setcolor();
    }

    public Dimension getPreferredSize ()
    // Damit der Scrollbar nicht zu knapp ist
    {   return new Dimension(400,40);
    }

    public int value () { return Value; }
}
