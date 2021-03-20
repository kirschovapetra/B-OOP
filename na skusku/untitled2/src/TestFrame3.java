import java.awt.*;

import java.awt.event.*;



class TestFrame3 extends Frame implements ActionListener

{

    Panel ButtonPanel;



    Button Crosshair;

    Button Wait;

    Button Custom; //*******************************

    Button Text;

    Button Hand;



    Cursor PanelCursor;

    Cursor FrameCursor;





    public TestFrame3 ()

    {   super("Font Test");

        setLayout(new BorderLayout());

        setSize(700,400);



        ButtonPanel = new Panel();



        Crosshair = new Button("CROSSHAIR_CURSOR");

        Wait = new Button("WAIT_CURSOR");

        Custom = new Button("Co tu bude?"); //*********************

        Text = new Button("TEXT_CURSOR");

        Hand = new Button("HAND_CURSOR");



        Crosshair.addActionListener(this);

        Wait.addActionListener(this);

        Custom.addActionListener(this);

        Text.addActionListener(this);

        Hand.addActionListener(this);



        ButtonPanel.add(Crosshair);

        ButtonPanel.add(Wait);

        ButtonPanel.add(Custom);

        ButtonPanel.add(Text);

        ButtonPanel.add(Hand);





        PanelCursor = new Cursor(Cursor.DEFAULT_CURSOR); //***************

        FrameCursor = new Cursor(Cursor.DEFAULT_CURSOR); //***************



        ButtonPanel.setCursor(PanelCursor);

        this.setCursor(FrameCursor);



        add("North", ButtonPanel);

        setVisible(true);

    }



    public void actionPerformed (ActionEvent e)

    {



        if (e.getSource()==Crosshair)

        {   FrameCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

            this.setCursor(FrameCursor);

        }

        if (e.getSource()==Wait)

        {   FrameCursor = new Cursor(Cursor.WAIT_CURSOR);

            this.setCursor(FrameCursor);

        }

        if (e.getSource()==Custom) //******************************

        {

            Point Size =  new Point(getToolkit().getBestCursorSize(30,30).width / 2, getToolkit().getBestCursorSize(30,30).height / 2);

            //Point Size = new Point(15,15);

            FrameCursor = getToolkit().createCustomCursor(getToolkit().getImage("mycursor.gif"),Size, "My cursor");

            this.setCursor(FrameCursor);

        }

        if (e.getSource()==Text)

        {   FrameCursor = new Cursor(Cursor.TEXT_CURSOR);

            this.setCursor(FrameCursor);

        }

        if (e.getSource()==Hand)

        {   FrameCursor = new Cursor(Cursor.HAND_CURSOR);

            this.setCursor(FrameCursor);

        }



    }

}

