package d.com.andsql;

public class Placement {
   public String companyname;
    public String uploadtime;
    public String drivedate;
    public String eligiblebranch;
    public String eligibleyear;
    public Placement()
    {

    }

    public Placement(String companyname, String uploadtime, String drivedate, String eligiblebranch, String eligibleyear) {
        this.companyname = companyname;
        this.uploadtime = uploadtime;
        this.drivedate = drivedate;
        this.eligiblebranch = eligiblebranch;

    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getDrivedate() {
        return drivedate;
    }

    public void setDrivedate(String drivedate) {
        this.drivedate = drivedate;
    }

    public String getEligiblebranch() {
        return eligiblebranch;
    }

    public void setEligiblebranch(String eligiblebranch) {
        this.eligiblebranch = eligiblebranch;
    }

    public String getEligibleyear() {
        return eligibleyear;
    }

    public void setEligibleyear(String eligibleyear) {
        this.eligibleyear = eligibleyear;
    }

}
