import java.awt.*;
import java.awt.event.*;

class TestFrame extends Frame implements ItemListener
{
    Panel FontPanel;
    Choice FontName;
    Choice FontType;
    Choice FontSize;
    String[] fonts;
    String[] types = {"Plain", "Bold", "Italic", "Bold & Italic"}; ;
    String[] sizes = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "34"};
    String FontNameSelected;
    int FontTypeSelected;
    int FontSizeSelected;

    public TestFrame ()
    {	super("Font Test");
        setLayout(new BorderLayout());
        setSize(500,400);

        fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        FontPanel = new Panel();
        FontName = new Choice();
        FontType = new Choice();
        FontSize =  new Choice();

        FontName.addItemListener(this);
        FontType.addItemListener(this);
        FontSize.addItemListener(this);

        for (int i=0; i<fonts.length; i++)
        {
            FontName.add(fonts[i]);
        }

        for (int i=0; i<types.length; i++)
        {
            FontType.add(types[i]);
        }

        for (int i=0; i<sizes.length; i++)
        {
            FontSize.add(sizes[i]);
        }

        FontName.select(0);
        FontNameSelected = FontName.getSelectedItem();

        FontType.select(0);
        FontTypeSelected = FontType.getSelectedIndex();

        FontSize.select(0);
        FontSizeSelected = Integer.parseInt(FontSize.getSelectedItem());

        FontPanel.add(FontName);
        FontPanel.add(FontType);
        FontPanel.add(FontSize);

        add("North", FontPanel);
        setVisible(true);

    }

    public void itemStateChanged (ItemEvent e)
    {
        if (e.getSource()==FontName)
        {
            FontNameSelected = FontName.getSelectedItem();
        }

        if (e.getSource()==FontType)
        {
            FontTypeSelected = FontType.getSelectedIndex();
        }

        if (e.getSource()==FontSize)
        {
            FontSizeSelected = Integer.parseInt(FontSize.getSelectedItem());
        }

        repaint();
    }

    public void paint(Graphics g)
    {
        int x = 200;
        int y = 200;

        Font font = new Font(FontNameSelected, FontTypeSelected, FontSizeSelected);
        g.setFont(font);
        g.drawString(FontNameSelected + " " + types[FontTypeSelected] + " " + FontSizeSelected, x, y);
    }
}
