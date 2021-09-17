package sk.stuba.fei.oop.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Exporter {

    public void exportToXml(String path, Document document) throws JAXBException, FileNotFoundException {

        OutputStream outputStream = new FileOutputStream(path);
        JAXBContext context = JAXBContext.newInstance(Document.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(document,outputStream);

    }
}
