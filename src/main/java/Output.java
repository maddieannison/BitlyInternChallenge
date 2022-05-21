import org.json.simple.JSONObject;

/**
 * The Output class holds object information, including getters and setters,
 * for objects created with the Encode and Decode information.
 * This can be adjusted to add/remove information, depending on the desired
 * output.
 *
 * @author Madeline Annison
 */
public class Output {
    private String long_url;
    int count;


    /**
     * Default constructor for Output class.
     */
    public Output() {
    }

    /**
     * Constructor for Output class.
      * @param long_url the long_url of the output
     * @param count the click count of the output
     */
    public Output(String long_url, int count) {
        this.long_url = long_url;
        this.count = count;
    }

    /**
     * @return the long_url of the ouput
     */
    public String getLong_url() {
        return long_url;
    }

    /**
     * Sets the long_url of the Output.
     * @param long_url of the output
     */
    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    /**
     * @return click count of the output
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the click count of the output.
     * @param count of the output
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Creates a JSON object from output information.
     * @return JSONObject
     */
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put(long_url, count);
        return obj;
    }
}
