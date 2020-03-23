package d.com.andsql;

public class Contact1 {
    public String name1;
    public String phone1;
    public String email1;
    public String designation;
    public String profileurl;
    public Contact1(){

    }



    public Contact1(String name1, String phone1, String email1, String designation, String profileurl) {
        this.name1 = name1;
        this.phone1 = phone1;
        this.email1 = email1;
        this.designation = designation;
        this.profileurl = profileurl;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }
}

