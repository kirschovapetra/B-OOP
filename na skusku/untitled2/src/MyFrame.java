import java.awt.*;
import java.awt.event.*;

//menuBar, popup menu,checkbox menu item, dialog
public class MyFrame extends Frame implements ActionListener, ItemListener,MouseListener {
    private MenuBar menuBar = new MenuBar();
    private Menu menu1 = new Menu("Menu1"),menu2 = new Menu("Menu2");

    private MenuItem menuItem1= new MenuItem("1"),menuItem2= new MenuItem("2"),
            menuItem3= new MenuItem("3"), menuItem4= new MenuItem("4");

    private CheckboxMenuItem checkboxMenuItem = new CheckboxMenuItem("check");
    private PopupMenu popupMenu = new PopupMenu("PopupMenu");;
    private Dialog dialog;
    private Label label;


    public MyFrame(String title) throws HeadlessException {
        super(title);
        setSize(500,500);
        setLayout(new BorderLayout());

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu2.add(menuItem3);
        menu2.add(checkboxMenuItem);
        popupMenu.add(menuItem4);

        menuBar.add(menu1);
        menuBar.add(menu2);

        add(popupMenu);
        setMenuBar(menuBar);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        checkboxMenuItem.addItemListener(this);

        dialog = new Dialog(this);
        label = new Label();
        dialog.add(label);
        dialog.setSize(200,100);

        addMouseListener(this);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setLayout(new FlowLayout());

        if (e.getSource()==menuItem1){
            dialog.setTitle(menuItem1.getLabel());
            label.setText(menuItem1.getLabel());
            dialog.setVisible(true);
        }
        if (e.getSource()==menuItem2){
            dialog.setTitle(menuItem2.getLabel());
            label.setText(menuItem2.getLabel());
            dialog.setVisible(true);
        }
        if (e.getSource()==menuItem3){
            dialog.setTitle(menuItem3.getLabel());
            label.setText(menuItem3.getLabel());
            dialog.setVisible(true);
        }
        if (e.getSource()==menuItem4){
            dialog.setTitle(menuItem4.getLabel());
            label.setText(menuItem4.getLabel());
            dialog.setVisible(true);
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("CHECK");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3){
            popupMenu.show(this,e.getX(),e.getY());
        }
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
