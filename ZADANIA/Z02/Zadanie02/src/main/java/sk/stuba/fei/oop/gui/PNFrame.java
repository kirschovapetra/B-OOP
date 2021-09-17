package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.generated.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;


public class PNFrame extends Frame implements ActionListener {

    private PNCanvas pnCanvas;
    private Button importButton;
    private Panel panel;
    private Importer importer;                          //importovanie Documentu z .xml
    private PetriNetTransformer petriNetTransformer;    //transformacia Documentu do PetriNet
    private GraphicsTransformer graphicsTransformer;    //transformacia Documentu+PetriNet na graficke elementy

    //konstruktor
    public PNFrame() throws HeadlessException {
        super("PNFrame");

        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        importButton = new Button("Import");
        pnCanvas = new PNCanvas();
        panel = new Panel(new FlowLayout());

        //sleduje sa stlacenie buttonu
        importButton.addActionListener(this);

        //button na panel
        panel.add(importButton);

        //panel, canvas na frame
        this.add(panel, BorderLayout.PAGE_START);
        this.add(pnCanvas, BorderLayout.CENTER);

        importer = new Importer();
        petriNetTransformer = new PetriNetTransformer();
        graphicsTransformer = new GraphicsTransformer();

        //exit
        this.addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       dispose();
                                       System.exit(0);
                                   }
                               }
        );
    }

    //po stlaceni tlacidla sa nacita petriho siet zo suboru .xml nacitaneho z file dialogu
    public void actionPerformed(ActionEvent e) {
        FileDialog fileDialog = new FileDialog(this,"Nacitaj subor",FileDialog.LOAD);
        fileDialog.setVisible(true);

        //ak bol vybrany subor
        if (fileDialog.getFile()!= null) {
            //cesta k suboru
            String path = fileDialog.getDirectory() + fileDialog.getFile();

            try {
                //pri kazdom nacitani novej petriho siete sa canvas vyprazdni
                pnCanvas.clear();

                //nacitanie do Documentu
                importer.importFromXML(path);
                Document document = importer.getDocument();

                //transformacia na PetriNet + ulozenie do canvas
                petriNetTransformer.transform(document);
                pnCanvas.setPetriNet(petriNetTransformer.getPetriNet());

                //transformacia na graficku podobu siete + ulozenie do canvas
                graphicsTransformer.transform(document,pnCanvas.getPetriNet());
                pnCanvas.setPnElements(graphicsTransformer.getElements());

                pnCanvas.repaint();

            } catch (JAXBException exception) {
                System.out.println(exception);
            } catch (FileNotFoundException exception) {
                System.out.println(exception);
            }
        }
    }
}
