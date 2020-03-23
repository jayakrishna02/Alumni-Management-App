package d.com.andsql;

public class Report {
    public String email;
    public String name;
    public String url;
    public Report()
    {

    }

    public Report(String email, String name, String url) {
        this.email = email;
        this.name = name;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

