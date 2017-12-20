package ua.nure.garmash.Practice7.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.garmash.Practice7.Constants;
import ua.nure.garmash.Practice7.entity.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser extends DefaultHandler {
    private String xmlFile;
    private String currentElement;
    private Pharmaceuticals pharmaceuticals;
    private Medicine medicine;
    private Versions versions;
    private Version version;
    private Certificate certificate;
    private MedPackage mPackage;

    public SaxParser(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public Pharmaceuticals getPharmaceuticals() {
        return pharmaceuticals;
    }

    public void parse(boolean validate) throws SAXException, IOException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setNamespaceAware(true);

        if (validate) {
            factory.setFeature(Constants.TURN_VALIDATION_ON, true);
            factory.setFeature(Constants.TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFile, this);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = localName;
        if (Constants.PHARMACY.equals(currentElement)) {
            pharmaceuticals = new Pharmaceuticals();
            return;
        }
        if (Constants.MEDICINE.equals(currentElement)) {
            medicine = new Medicine();
            if (attributes.getLength() > 0) {
                medicine.setId(Integer.parseInt(attributes
                        .getValue(uri, Constants.ID)));
            }
            return;
        }

        if (Constants.VERSIONS.equals(currentElement)) {
            versions = new Versions();
            return;
        }

        if (Constants.VERSION.equals(currentElement)) {
            version = new Version();
            if (attributes.getLength() > 0) {
                version.setVersionCount(Integer.parseInt(attributes
                        .getValue(uri, Constants.VER_N0)));
            }
        }
        if (Constants.CERTIFICATE.equals(currentElement)) {
            certificate = new Certificate();
            return;
        }
        if (Constants.MED_PACKAGE.equals(currentElement)) {
            mPackage = new MedPackage();
        }

    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String elementText = new String(ch, start, length).trim();
        if (elementText.isEmpty()) {
            return;
        }
        switch (currentElement) {
            case "name":
                medicine.setName(elementText);
                return;
            case "pharm":
                medicine.setPharm(elementText);
                return;
            case "group":
                medicine.setGroup(currentElement);
                return;
            case "analogs":
                medicine.getAnalogsList().add(elementText);
                return;
            case "drugType":
                version.setDrugType(elementText);
                return;
            case "pharmAnalog":
                version.setPharm(elementText);
                return;
            case "certificateNo":
                certificate.setCertificateNo(Integer.parseInt(elementText));
                return;
            case "validationDate":
                certificate.setValidationDate(elementText);
                return;
            case "validationExpire":
                certificate.setValidationExpire(elementText);
                return;
            case "organisation":
                certificate.setOrganisationName(elementText);
                return;
            case "type":
                mPackage.setType(elementText);
                return;
            case "amount":
                mPackage.setAmount(Integer.parseInt(elementText));
                return;
            case "price":
                mPackage.setPrice(Double.parseDouble(elementText));
                return;
            case "dosage":
                version.setDosage(elementText);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (localName) {
            case "Medicine":
                pharmaceuticals.getMedicines().add(medicine);
                return;
            case "Versions":
                medicine.setVersions(versions);
                return;
            case "Version":
                versions.getVersionList().add(version);
                return;
            case "Certificate":
                version.setCertificate(certificate);
                return;
            case "Package":
                version.setaPackage(mPackage);
                break;
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SaxParser saxParser = new SaxParser(Constants.XML_FILE);

        saxParser.parse(true);

        Pharmaceuticals pharmaceuticals = saxParser.getPharmaceuticals();
        System.out.println("XML parsed with SAX:\n");
        System.out.println(pharmaceuticals);
    }
}