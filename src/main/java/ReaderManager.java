import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReaderManager {
    int count = 0;

    String eFile = "encodes.csv";
    String dFile = "decodes.json";

    DecodesReader dr = new DecodesReader();
    EncodesReader er = new EncodesReader();
    JSONArray jsonArray;
    List<JSONArray> sortedJsonArray;
    JSONObject jsonObject;
    JSONObject sortedJsonObject;




    public ReaderManager() throws IOException {
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();
        sortedJsonObject = new JSONObject();
        sortedJsonArray = new ArrayList<>();
        compareEAndD();
        print();
    }

    private void compareEAndD() throws IOException {
        ArrayList<Encodes> encodesArrayList = er.getEncodesArrayList(eFile);
        dr.readFile(dFile);
        ArrayList<Decodes> decodesArrayList = dr.getDecodeArrayList();

//        for (int i = 0; i < decodesArrayList.size(); i++) {
//            System.out.println(decodesArrayList.get(i).getTimestamp());
//        }

        for (int i = 0; i < encodesArrayList.size(); i++) {
            for (int j = 0; j < decodesArrayList.size(); j++) {
                //Check for same bitlink
                if (("http://" + encodesArrayList.get(i).getDomain() + "/" + encodesArrayList.get(i).getHash()).equals(decodesArrayList.get(i).getBitlink())) {
                    //Check for correct timestamp
                    if (decodesArrayList.get(i).getTimestamp().substring(0,4).equals("2021")){
                        //Increment click count
                        count++;
                    }
                    //Add the long_url and click count to a JSON array
                addToJSONArray(encodesArrayList.get(i).getLong_url(), count);
                }
            }
            //Reset the click count
            count = 0;
        }
    }

    private void addToJSONArray(String long_url, int count) {
        jsonArray.add(long_url);
        jsonArray.add(count);
        jsonObject.put(jsonArray, null);
    }

    private void print() {
        System.out.println(jsonObject);
    }
    private void sortJSONObject() {
    }
}
