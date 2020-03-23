package d.com.andsql;

public class Enterpr {
    public String enname;
    public String enpos;
    public String enbatch;
    public String endep;
    public String enurl;

    public Enterpr(){

    }

    public Enterpr(String enname, String enpos, String enbatch, String endep, String enurl) {
        this.enname = enname;
        this.enpos = enpos;
        this.enbatch = enbatch;
        this.endep = endep;
        this.enurl = enurl;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getEnpos() {
        return enpos;
    }

    public void setEnpos(String enpos) {
        this.enpos = enpos;
    }

    public String getEnbatch() {
        return enbatch;
    }

    public void setEnbatch(String enbatch) {
        this.enbatch = enbatch;
    }

    public String getEndep() {
        return endep;
    }

    public void setEndep(String endep) {
        this.endep = endep;
    }

    public String getEnurl() {
        return enurl;
    }

    public void setEnurl(String enurl) {
        this.enurl = enurl;
    }
}
