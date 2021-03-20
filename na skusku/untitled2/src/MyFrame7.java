import sun.awt.CustomCursor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame7 extends Frame implements MouseListener {
    private MyDialog dialog;
    private Cursor cursor;
    private Cursor cursor2;

    public MyFrame7(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setLayout(new BorderLayout());

        dialog = new MyDialog(this,"Choose color",false);

        addMouseListener(this);
        cursor=new Cursor(Cursor.CROSSHAIR_CURSOR);

        setCursor(cursor);

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
    public void mouseClicked(MouseEvent e) {
        dialog.setVisible(true);
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
