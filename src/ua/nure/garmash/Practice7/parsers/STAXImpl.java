package ua.nure.garmash.Practice7.parsers;

import org.xml.sax.SAXException;
import ua.nure.garmash.Practice7.Constants;
import ua.nure.garmash.Practice7.entity.*;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class STAXImpl {
    private String XMLFile;
    private Pharmaceuticals pharmacy;

    private Pharmaceuticals getPharmacy() {
        return pharmacy;
    }

    public STAXImpl(String XMLFile) {
        this.XMLFile = XMLFile;

    }

    public void parse() throws ParserConfigurationException, SAXException,
            IOException, XMLStreamException {
        Medicine meds = null;
        MedPackage mPackage = null;
        Versions versions = null;
        Version version = null;
        Certificate certificate = null;

        String currentElement = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        XMLEventReader reader = factory.createXMLEventReader(
                new StreamSource(XMLFile));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
                continue;
            }

            //start tags
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();
                if (Constants.PHARMACY.equals(currentElement)) {
                    pharmacy = new Pharmaceuticals();
                    continue;
                }

                if (Constants.MEDICINE.equals(currentElement)) {
                    meds = new Medicine();
                    Attribute attribute = startElement.getAttributeByName(
                            new QName(Constants.ID));
                    if (attribute != null) {
                        meds.setId(Integer.parseInt(attribute.getValue()));
                    }

                }

                if (Constants.VERSIONS.equals(currentElement)) {
                    versions = new Versions();

                    continue;
                }
                if (Constants.VERSION.equals(currentElement)) {
                    version = new Version();
                    Attribute attribute = startElement.getAttributeByName(
                            new QName(Constants.VER_N0));
                    if (attribute != null) {
                        version.setVersionCount(Integer.parseInt(attribute.getValue()));
                    }

                    continue;
                }
                if (Constants.CERTIFICATE.equals(currentElement)) {
                    certificate = new Certificate();
                    continue;
                }
                if (Constants.MED_PACKAGE.equals(currentElement)) {
                    mPackage = new MedPackage();
                }

            }

            if (event.isCharacters()) {
                Characters characters = event.asCharacters();
                switch (currentElement) {
                    case "name":
                        meds.setName(characters.getData());
                        break;
                    case "pharm":
                        meds.setPharm(characters.getData());
                        break;
                    case "group":
                        meds.setGroup(currentElement);
                        break;
                    case "analogs":
                        meds.getAnalogsList().add(characters.getData());
                        break;
                    case "drugType":
                        version.setDrugType(characters.getData());
                        break;
                    case "pharmAnalog":
                        version.setPharm(characters.getData());
                        break;
                    case "certificateNo":
                        certificate.setCertificateNo(Integer.parseInt(characters.getData()));
                        break;
                    case "validationDate":
                        certificate.setValidationDate(characters.getData());
                        break;
                    case "validationExpire":
                        certificate.setValidationExpire(characters.getData());
                        break;
                    case "organisation":
                        certificate.setOrganisationName(characters.getData());
                        break;
                    case "type":
                        mPackage.setType(characters.getData());
                        break;
                    case "amount":
                        mPackage.setAmount(Integer.parseInt(characters.getData()));
                        break;
                    case "price":
                        mPackage.setPrice(Double.parseDouble(characters.getData()));
                        break;
                    case "dosage":
                        version.setDosage(characters.getData());
                        break;
                }

            }


            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                String endElementName = endElement.getName().getLocalPart();

                switch (endElementName) {
                    case "Medicine":
                        pharmacy.getMedicines().add(meds);
                        break;
                    case "Versions":
                        meds.setVersions(versions);
                        break;
                    case "Version":
                        versions.getVersionList().add(version);
                        break;
                    case "Certificate":
                        version.setCertificate(certificate);
                        break;
                    case "Package":
                        version.setaPackage(mPackage);
                        break;
                }
            }
        }
        reader.close();
    }

    public static void main(String[] args) throws XMLStreamException, IOException, SAXException, ParserConfigurationException {
        STAXImpl stax = new STAXImpl(Constants.XML_FILE);
        stax.parse();
        Pharmaceuticals phar = stax.getPharmacy();
        System.out.println("XML parsed using StAX");
        System.out.println(phar);

    }
}
