import org.json.simple.JSONObject;

public class Output {
    private String long_url;
    private String count;

    public Output() {

    }

    public Output(String long_url, String count) {
        this.long_url = long_url;
        this.count = count;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put(long_url, count);
        return obj;
    }

    @Override
    public String toString() {
        return "{\"" +
                 long_url + "\": " +
                 count +
                '}';
    }
}
