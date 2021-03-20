import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public MyFrame() {
        setSize(500,500);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu menu = new Menu("Menu");

        MenuItem menuItem = new MenuItem("menuItem");

        menu.add(menuItem);
        menuBar.add(menu);

        addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    dispose();
                                    System.exit(0);
                                }
                            }
        );
    }
}
