import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomFrame extends Frame implements ActionListener, ItemListener {
    private CustomCanvas canvas = new CustomCanvas();
    private Choice choice = new Choice();
    private CheckboxGroup group = new CheckboxGroup();
    private Checkbox checkbox1,checkbox2,checkbox3;
    private Panel panel = new Panel();
    private MenuBar menuBar = new MenuBar();
    private Menu menu = new Menu("menu");
    private MenuItem menuItem1 = new MenuItem("open");
    private MenuItem menuItem2 = new MenuItem("save");
    private MenuItem menuItem3 = new MenuItem("exit");
    private TextArea textArea = new TextArea();

    private String[] colors = {"black","blue","red"};

    public CustomFrame() throws HeadlessException {
        setSize(1000,1000);
        setLayout(new BorderLayout());

        for (String c: colors){
            choice.addItem(c);
        }

        panel.add(choice);

        panel.add(new Label("background"));
        checkbox1 = new Checkbox("black",group,true);
        checkbox2 = new Checkbox("blue",group,true);
        checkbox3 = new Checkbox("red",group,true);
        panel.add(checkbox1);
        panel.add(checkbox2);
        panel.add(checkbox3);

        menu.add(menuItem1);menu.add(menuItem2);menu.add(menuItem3);
        menuBar.add(menu);
        setMenuBar(menuBar);

        add(panel,BorderLayout.PAGE_START);

        Panel panel2 = new Panel();
        panel2.add(canvas);
        panel2.add(textArea);
        add(panel2,BorderLayout.CENTER);


        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        checkbox1.addItemListener(this);
        checkbox2.addItemListener(this);
        checkbox3.addItemListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem1) {
            FileDialog OpDialog = new FileDialog(this, "Otvor", FileDialog.LOAD);
            OpDialog.setVisible(true);
            if (OpDialog.getFile() != null) {
                try {
                    FileInputStream fis = new FileInputStream(OpDialog.getDirectory() + OpDialog.getFile());
                    InputStreamReader in = new InputStreamReader(fis);
                    BufferedReader b = new BufferedReader(in);
                    String obsah_suboru = "";
                    while (true) {
                        String nacitana = b.readLine();
                        if (nacitana == null) break;
                        obsah_suboru = obsah_suboru + nacitana + "\n";
                    }
                    textArea.setText(obsah_suboru);
                    //Edit.append(obsah_suboru);
                    b.close();
                } catch (IOException exc)
                // Fängt IOException ab.
                {
                    System.out.println(exc);
                }
            }
        } else if (e.getSource() == menuItem2) {
            FileDialog SaveDialog = new FileDialog(this, "Uloz ako", FileDialog.SAVE);
            SaveDialog.setVisible(true);
            if (SaveDialog.getFile() != null) {
                try {
                    FileOutputStream fos = new FileOutputStream(SaveDialog.getDirectory() + SaveDialog.getFile());
                    OutputStreamWriter out = new OutputStreamWriter(fos);
                    PrintWriter p = new PrintWriter(out);
                    p.println(textArea.getText());
                    p.close();
                } catch (FileNotFoundException exc) {
                    System.out.println("Nie je taky subor");
                }


            } else if (e.getSource() == menuItem3) {
                dispose();
                System.exit(0);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        canvas.setColor(getColor(choice.getSelectedItem()));
        if (e.getSource() == checkbox1){
            canvas.setBgColor(getColor(checkbox1.getLabel()));
        }
        else if (e.getSource() == checkbox2){
            canvas.setBgColor(getColor(checkbox2.getLabel()));
        }
        else if (e.getSource() == checkbox3){
            canvas.setBgColor(getColor(checkbox3.getLabel()));
        }
        canvas.repaint();
    }

    public Color getColor(String col) {
        Color color = new Color(0,0,0);
        switch (col.toLowerCase()) {
            case "black":
                color = Color.BLACK;
                break;
            case "blue":
                color = Color.BLUE;
                break;
            case "cyan":
                color = Color.CYAN;
                break;
            case "darkgray":
                color = Color.DARK_GRAY;
                break;
            case "gray":
                color = Color.GRAY;
                break;
            case "green":
                color = Color.GREEN;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;
            case "lightgray":
                color = Color.LIGHT_GRAY;
                break;
            case "magneta":
                color = Color.MAGENTA;
                break;
            case "orange":
                color = Color.ORANGE;
                break;
            case "pink":
                color = Color.PINK;
                break;
            case "red":
                color = Color.RED;
                break;
            case "white":
                color = Color.WHITE;
                break;
        }
        return color;

    }
}
