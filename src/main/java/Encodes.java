/**
 * The Encodes class holds object information, including getters and setters,
 * for objects created from the encodes.csv file
 *
 * @author Madeline Annison
 */
public class Encodes {

    private String long_url;
    private String domain;
    private String hash;

    /**
     * Default constructor for the Encodes class.
     */
    public Encodes() {
    }

    /**
     * Constructor for the Encodes class
     * @param long_url the long url value
     * @param domain the domain value
     * @param hash the hash value
     */
    public Encodes(String long_url, String domain, String hash) {
        this.long_url = long_url;
        this.domain = domain;
        this.hash = hash;
        }

    /**
     * Sets the long url of the encode
     * @param long_url of the encode
     */
    public void setLong_url (String long_url) {
        this.long_url = long_url;
    }

    /**
     * @return long_url of the encode
     */
    public String getLong_url() {
        return long_url.trim();
    }

    /**
     * Sets the domain of the encode
     * @param domain of the encode
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return domain of the encode
     */
    public String getDomain() {
        return domain.trim();
    }

    /**
     * Sets the hash of the encode.
     * @param hash of the encode
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the hash of the encode
     */
    public String getHash() {
        return hash.trim();
    }

    /**
     * Transforms the domain and hash to a complete URL.
     * @return the url as a String
     */
    public String toURL(){
        String s;
        return s = ("http://" + getDomain() + "/" + getHash());
    }
}
