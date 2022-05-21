/**
 * The Decodes class holds object information, including getters and setters,
 * for objects created from the decodes.json file
 *
 * @author Madeline Annison
 */
public class Decodes {
    private String bitlink;
    private String timestamp;

    /**
     * Default constructor for Decodes.
     */
    public Decodes() {
    }

    /**
     * Constructor for Decodes.
     * @param bitlink the bitlink of the decode
     * @param timestamp the timestamp of the decodes
     */
    public Decodes(String bitlink, String timestamp) {
        this.bitlink = bitlink;
        this.timestamp = timestamp;
    }

    /**
     * Sets the bitlink of the decode.
     * @param bitlink of the decode
     */
    public void setBitlink(String bitlink) {
        this.bitlink = bitlink;
    }

    /**
      * @return the bitlink of the decode
     */
    public String getBitlink() {
        return bitlink;
    }

    /**
     * Sets the timestamp of the decode.
     * @param timestamp of the decode
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the timestamp of the decode
     */
    public String getTimestamp() {
        return timestamp;
    }
}
