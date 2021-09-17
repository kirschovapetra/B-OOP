package sk.stuba.fei.oop.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Importer {
    private Document document = new Document();  //generovana petriho siet z .xml

    //getter, setter
    public Document getDocument() {
        return document;
    }
    public void setDocument(Document document) {
        this.document = document;
    }

    public void importFromXML(String path) throws JAXBException, FileNotFoundException {

        InputStream resource = new FileInputStream(path);
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        document = (Document) unmarshaller.unmarshal(resource);
    }

}
