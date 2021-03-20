package sk.stuba.fei.oop.gui;

import sk.stuba.fei.oop.generated.*;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class PNFrame extends Frame implements ActionListener {

    private PNCanvas pnCanvas;
    private Panel panel;
    private Importer importer;                          //importovanie Documentu z .xml
    private Exporter exporter;                          //exportovanie Documentu do .xml
    private PetriNetTransformer petriNetTransformer;    //transformacia Documentu do PetriNet
    private GraphicsTransformer graphicsTransformer;    //transformacia Documentu + PetriNet na graficke elementy
    private DocumentTransformer documentTransformer;    //transformacia List<Drawable> + PetriNet na Document
    //buttony
    private Button importButton;
    private Button exportButton;
    private Button addPlaceButton;
    private Button addTransitionButton;
    private Button addRegularEdgeButton;
    private Button addResetEdgeButton;
    private Button removeButton;
    private Button simulationButton;

    private static final int SIZE = 25;

    //konstruktor
    public PNFrame() throws HeadlessException {
        super("PNFrame");

        this.setSize(700, 500);
        this.setLayout(new BorderLayout());

        //buttony
        importButton = new Button("Import");
        exportButton = new Button("Export");
        addPlaceButton = new Button("Place");
        addTransitionButton = new Button("Transition");
        addRegularEdgeButton = new Button("Regular Edge");
        addResetEdgeButton = new Button("Reset Edge");
        removeButton = new Button("Remove");
        simulationButton = new Button("Simulation");

        pnCanvas = new PNCanvas();
        panel = new Panel(new FlowLayout());

        //sleduje sa stlacenie buttonu
        importButton.addActionListener(this);
        exportButton.addActionListener(this);
        addPlaceButton.addActionListener(this);
        addTransitionButton.addActionListener(this);
        addRegularEdgeButton.addActionListener(this);
        addResetEdgeButton.addActionListener(this);
        removeButton.addActionListener(this);
        simulationButton.addActionListener(this);

        //buttony na panel
        panel.add(importButton);
        panel.add(exportButton);
        panel.add(addPlaceButton);
        panel.add(addTransitionButton);
        panel.add(addRegularEdgeButton);
        panel.add(addResetEdgeButton);
        panel.add(removeButton);
        panel.add(simulationButton);

        //panel, canvas na frame
        this.add(panel, BorderLayout.PAGE_START);
        this.add(pnCanvas, BorderLayout.CENTER);

        //import/export
        importer = new Importer();
        exporter = new Exporter();
        //transform
        petriNetTransformer = new PetriNetTransformer();
        graphicsTransformer = new GraphicsTransformer();
        documentTransformer = new DocumentTransformer();

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

    //stlacenie tlacidla
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == importButton) {
            importFromFileDialog();
        }

        if (e.getSource() == exportButton){
            exportToFileDialog();
        }

        if (e.getSource() == addPlaceButton){
            pnCanvas.setClickedButton(ButtonAction.ADD_PLACE);
        }

        if (e.getSource() == addTransitionButton){
            pnCanvas.setClickedButton(ButtonAction.ADD_TRANSITION);
        }

        if (e.getSource() == addRegularEdgeButton){
            pnCanvas.clearClicks();
            pnCanvas.setClickedButton(ButtonAction.ADD_REGULAR_EDGE);
        }

        if (e.getSource() == addResetEdgeButton){
            pnCanvas.clearClicks();
            pnCanvas.setClickedButton(ButtonAction.ADD_RESET_EDGE);
        }

        if (e.getSource() == removeButton){
            pnCanvas.setClickedButton(ButtonAction.REMOVE);
        }

        if (e.getSource() == simulationButton){
            pnCanvas.setClickedButton(ButtonAction.SIMULATION);
        }
    }

    public void importFromFileDialog(){
        FileDialog fileDialog = new FileDialog(this, "Nacitaj subor", FileDialog.LOAD);
        fileDialog.setVisible(true);

        //ak bol vybrany subor
        if (fileDialog.getFile() != null) {
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
                graphicsTransformer.transform(document, pnCanvas.getPetriNet());
                pnCanvas.setPnElements(graphicsTransformer.getElements());

                pnCanvas.repaint();

            } catch (JAXBException exception) {
                System.out.println(exception);
            } catch (FileNotFoundException exception) {
                System.out.println(exception);
            }
        }
    }
    public void exportToFileDialog(){
        FileDialog fileDialog = new FileDialog(this, "Nacitaj subor", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!=null) {
            String path = fileDialog.getDirectory() + fileDialog.getFile();
            try{
                documentTransformer.clear();
                documentTransformer.transform(pnCanvas.getPnElements(),pnCanvas.getPetriNet());
                exporter.exportToXml(path,documentTransformer.getDocument());

            } catch (JAXBException exception) {
                System.out.println(exception);
            } catch (FileNotFoundException exception) {
                System.out.println(exception);
            }

        }
    }


}
