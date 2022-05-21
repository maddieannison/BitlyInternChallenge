public class Decodes {
    private String bitlink;
    private String timestamp;

    public Decodes() {

    }

    public Decodes(String bitlink, String timestamp) {
        this.bitlink = bitlink;
        this.timestamp = timestamp;
    }

    public void setBitlink(String bitlink) {
        this.bitlink = bitlink;
    }

    public String getBitlink() {
        return bitlink;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
