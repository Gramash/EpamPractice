package ua.nure.garmash.Practice7.entity;

public class Version {
    private int versionCount;
    private Certificate certificate;
    private MedPackage aPackage;
    private String drugType;
    private String pharm;
    private String dosage;

    public void setVersionCount(int versionCount) {
        this.versionCount = versionCount;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Certificate getCertificate() {
        if (certificate == null) {
            certificate = new Certificate();
        }
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public MedPackage getaPackage() {
        if (aPackage == null) {
            aPackage = new MedPackage();
        }
        return aPackage;
    }

    public void setaPackage(MedPackage aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Version #: ")
                .append(".").append(versionCount).append('\n');
        sb.append("Drug type: " + drugType).append('\n')
                .append("Pharmacy organization: ").append(pharm).append('\n')
                .append(certificate).append('\n')
                .append(aPackage).append('\n')
                .append("Dosage: ").append(dosage);
        return  sb.toString();
    }
}
