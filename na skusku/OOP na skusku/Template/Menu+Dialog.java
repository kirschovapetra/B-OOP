import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ActionListener {
    private MenuBar menuBar;
    private Menu menu1,menu2;
    private MenuItem menuItem1,menuItem2,menuItem3, menuItem4;
    private Dialog dialog;
    private Label label;


    public MyFrame(String title) throws HeadlessException {
        super(title);

        setSize(500,500);

        menuBar = new MenuBar();
        setMenuBar(menuBar);

        menu1 = new Menu("Menu1");
        menu2 = new Menu("Menu2");

        menuItem1 = new MenuItem("1");
        menuItem2 = new MenuItem("2");
        menuItem3 = new MenuItem("3");
        menuItem4 = new MenuItem("4");

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu2.add(menuItem3);
        menu2.add(menuItem4);

        menuBar.add(menu1);
        menuBar.add(menu2);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        dialog = new Dialog(this);
        label = new Label();
        dialog.add(label);
        dialog.setSize(200,100);

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


}
