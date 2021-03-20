import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomFrame extends Frame implements ActionListener {


    public CustomFrame(String title) throws HeadlessException {
        super(title);
        setSize(500,500);
        setLayout(new BorderLayout());

        /*
        button1.addActionListener(this);
        button2.addActionListener(this);
        ...
        */

        /*
         add();
         add();
         add();
         ...
        */

        //exit
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
        /*
        if (e.getSource()==...) {
            ...
        }
        */
    }
}
