package ru.isu.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

/**
 * Класс - singleton для записи в xml файл
 * @author Сергей
 */
public class XmlFileWriter {
    public static final XmlFileWriter INSTANCE = new XmlFileWriter();
    private final Root root;

    public XmlFileWriter() {
        root = new Root();
    }

    public Root getRoot() {
        return root;
    }

    public void writeXmlFile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ru.isu.xml.Root.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(root, new File("out.xml"));

    }
}
