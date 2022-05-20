import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class DecodesReader {
    String fileName;

    /**
     * Default constructor for DecodesReader.
     */
    public DecodesReader(){}

    public DecodesReader(String fileName) {
        this.fileName = fileName;
    }


    public void readFile(String fileName) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            //Read JSON File
            Object obj = jsonParser.parse(fileReader);
            JSONArray decodesList = (JSONArray) obj;
            System.out.println(decodesList);
            //Iterate over array
            decodesList.forEach(dec -> parseDecObj((JSONObject)dec));

        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e ) {
            e.printStackTrace();
        }
    }

    private static void parseDecObj(JSONObject dec) {
    //get bitlink, get timestamp
        String bitlink = (String) dec.get("bitlink");
        String timestamp = (String) dec.get("timestamp");
        System.out.println("Bitlink: " + bitlink);
        System.out.println("Timestamp: " + timestamp);
    }
}
