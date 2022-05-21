public class Encodes {

    private String long_url;
    private String domain;
    private String hash;

    public Encodes() {

    }

    public Encodes(String long_url, String domain, String hash) {
        this.long_url = long_url;
        this.domain = domain;
        this.hash = hash;
    }


    public void setLong_url (String long_url) {
        this.long_url = long_url;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }
}
