
package ua.nure.garmash.Practice7.entity;

public class Certificate {
    private int certificateNo;
    private String validationDate;
    private String validationExpire;
    private String organisationName;

    public int getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(int certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(String validationDate) {
        this.validationDate = validationDate;
    }

    public String getValidationExpire() {
        return validationExpire;
    }

    public void setValidationExpire(String validationExpire) {
        this.validationExpire = validationExpire;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    @Override
    public String toString() {
        return "Certificate {" +
                "Certificate №: " + certificateNo +
                ", Release date: '" + validationDate + '\'' +
                ", Valid till: '" + validationExpire + '\'' +
                ", Organisation name: '" + organisationName + '\'' +
                '}';
    }
}
