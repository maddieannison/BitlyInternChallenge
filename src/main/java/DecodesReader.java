import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DecodesReader {
    String fileName;
    int counter = 0;
//    HashMap<String, String> decodes = new HashMap<>();
    ArrayList<Decodes> decodesArrayList = new ArrayList<>();

    /**
     * Default constructor for DecodesReader.
     */
    public DecodesReader(){}

    public void readFile(String fileName) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        String line = null;
        JSONArray decodesList = null;
        ArrayList<Object> decodes = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            //Read JSON File
            Object obj = jsonParser.parse(fileReader);
            decodesList = (JSONArray) obj;

            //Iterate over array
            decodesList.forEach(dec -> parseDecObj((JSONObject) dec));
//            System.out.println(decodesList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseDecObj(JSONObject dec) {
    //get bitlink, get timestamp
        String bitlink = (String) dec.get("bitlink");
        bitlink = bitlink.trim();
        String timestamp = (String) dec.get("timestamp");
        timestamp = timestamp.trim();
        Decodes decode = new Decodes(bitlink, timestamp);
        decodesArrayList.add(decode);
    }

    public ArrayList<Decodes> getDecodeArrayList (String fileName) throws FileNotFoundException {
        readFile(fileName);
        return decodesArrayList;
}



}
