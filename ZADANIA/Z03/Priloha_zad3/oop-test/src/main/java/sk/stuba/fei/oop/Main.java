package sk.stuba.fei.oop;

import sk.stuba.fei.oop.generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream xmlFileStream = ClassLoader.getSystemResourceAsStream("xml/insurance_demo.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Document document = (Document) jaxbUnmarshaller.unmarshal(xmlFileStream);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(document, new File("output.xml"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
