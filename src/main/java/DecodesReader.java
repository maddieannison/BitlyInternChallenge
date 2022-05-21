import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class DecodesReader {
    int counter = 0;

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
            System.out.println(decodesList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseDecObj(JSONObject dec) {
    //get bitlink, get timestamp
        String bitlink = (String) dec.get("bitlink");
        String timestamp = (String) dec.get("timestamp");
    }



}
