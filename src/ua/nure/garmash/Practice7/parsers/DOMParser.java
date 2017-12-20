package ua.nure.garmash.Practice7.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.nure.garmash.Practice7.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    private String xmlFileName;
    private Pharmaceuticals pharmaceuticals = new Pharmaceuticals();

    public DOMParser(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Pharmaceuticals getPharmaceuticals() {
        return pharmaceuticals;
    }


    public void parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //setting factory to xml that contains namespaces
        dbf.setNamespaceAware(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        //parsing xmlFile
        Document document = db.parse(xmlFileName);

        // creating root element
        Element root = document.getDocumentElement();

        //creating main container


        //Obtaining Medicine Nodes
        NodeList medicineNodes = root.getElementsByTagName("Medicine");

        for (int i = 0; i < medicineNodes.getLength(); i++) {
            Medicine medicine = getMedicine(medicineNodes.item(i));
            pharmaceuticals.getMedicines().add(medicine);
        }
    }

    private MedPackage getPackageAttributes(Node packNode) {
        MedPackage aPackage = new MedPackage();
        Element packElement = (Element) packNode;
        //Setting package type
        String type = packElement.getElementsByTagName("type").item(0).getTextContent();
        aPackage.setType(type);

        //setting quantity of drugs in a Package
        String amount = packElement.getElementsByTagName("amount").item(0).getTextContent();
        aPackage.setAmount(Integer.parseInt(amount));

        //setting price for a package of drugs
        String price = packElement.getElementsByTagName("price").item(0).getTextContent();
        aPackage.setPrice(Double.parseDouble(price));
        return aPackage;
    }

    private Certificate getCertificateAttributes(Node certNode) {
        Certificate certificate = new Certificate();
        Element certElement = (Element) certNode;

        //setting the # of certificate
        String certificateNo = certElement.getElementsByTagName("certificateNo").item(0).getTextContent();
        certificate.setCertificateNo(Integer.parseInt(certificateNo));

        //validation date
        String validationDate = certElement.getElementsByTagName("validationDate").item(0).getTextContent();
        certificate.setValidationDate(validationDate);

        //expirationDate
        String expirationDate = certElement.getElementsByTagName("validationExpire").item(0).getTextContent();
        certificate.setValidationExpire(expirationDate);

        // getting and setting org. name
        String ortName = certElement.getElementsByTagName("organisation").item(0).getTextContent();
        certificate.setOrganisationName(ortName);

        return certificate;
    }

    private Version getVersion(Node versNode) {
        Version version = new Version();
        Element versElement = (Element) versNode;

        //get version #
        String versNo = versElement.getAttribute("versionNo");
        version.setVersionCount(Integer.parseInt(versNo));
        //getting and setting drugType
        String drugType = versElement.getElementsByTagName("drugType").item(0).getTextContent();
        version.setDrugType(drugType);

        //setting pharm organisation
        String pharm = versElement.getElementsByTagName("pharmAnalog").item(0).getTextContent();
        version.setPharm(pharm);

        //getting and setting certificate Node
        Node certifNode = versElement.getElementsByTagName("Certificate").item(0);
        version.setCertificate(getCertificateAttributes(certifNode));

        //getting and setting package Node
        Node packageNode = versElement.getElementsByTagName("Package").item(0);
        version.setaPackage(getPackageAttributes(packageNode));

        //getting and setting dosage
        String dosage = versElement.getElementsByTagName("dosage").item(0).getTextContent();
        version.setDosage(dosage);

        return version;
    }

    private Versions getVersions(Node versionsNode) {
        Versions versions = new Versions();
        Element versionsElement = (Element) versionsNode;

        NodeList versNodeList = versionsElement.getElementsByTagName("Version");
        for (int i = 0; i < versNodeList.getLength(); i++) {
            Version version = getVersion(versNodeList.item(i));
            versions.getVersionList().add(version);
        }
        return versions;
    }

    private Medicine getMedicine(Node medNode) {
        Medicine meds = new Medicine();
        Element medElement = (Element) medNode;

        //getting id
        String id = medElement.getAttribute("id");
        meds.setId(Integer.parseInt(id));
        //getting name
        String name = medElement.getElementsByTagName("name").item(0).getTextContent();
        meds.setName(name);
        //getting pharm org
        String pharm = medElement.getElementsByTagName("pharm").item(0).getTextContent();
        meds.setPharm(pharm);
        //getting group
        String group = medElement.getElementsByTagName("group").item(0).getTextContent();
        meds.setGroup(group);
        //getting analogs list
        NodeList medNodeList = medElement.getElementsByTagName("analogs");
        for (int i = 0; i < medNodeList.getLength(); i++) {
            Node analog = medNodeList.item(i);
            meds.getAnalogsList().add(analog.getTextContent());
        }
        Node versionsNode = medElement.getElementsByTagName("Versions").item(0);
        meds.setVersions(getVersions(versionsNode));

        return meds;
    }

    public static void main(String[] args) throws Exception {
        DOMParser domContr = new DOMParser("input.xml");

        domContr.parse();
        System.out.println("XML parsed with DOM:\n");
        System.out.println(domContr.getPharmaceuticals());
    }
}
