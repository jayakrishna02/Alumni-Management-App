package d.com.andsql;

public class ImageUploadInfo {

        public String imageName;

        public String imageURL;
    public String uploadtime;
    public String drivedate;
    public String eligiblebranch;
    public String eligibleyear;

        public ImageUploadInfo() {

        }


    public ImageUploadInfo(String imageName, String imageURL, String uploadtime, String drivedate, String eligiblebranch, String eligibleyear) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.uploadtime = uploadtime;
        this.drivedate = drivedate;
        this.eligiblebranch = eligiblebranch;
        this.eligibleyear = eligibleyear;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
