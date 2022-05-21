import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The DecodesReader uses the JSON Simple Library to parse the decodes.json file
 * and creates an ArrayList of the decode objects
 *
 * @author Madeline Annnison
 */
public class DecodesReader {
    String fileName;
    int counter = 0;
//    HashMap<String, String> decodes = new HashMap<>();
    ArrayList<Decodes> decodesArrayList = new ArrayList<>();

    /**
     * Default constructor for DecodesReader.
     */
    public DecodesReader(){}

    /**
     * Reads the json file and creates an ArrayList.
     * @param fileName name of the file to be parsed
     * @throws FileNotFoundException
     */
    public void readFile(String fileName) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();

        JSONArray decodesList = null;
        ArrayList<Object> decodes = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            //Read JSON File
            Object obj = jsonParser.parse(fileReader);
            decodesList = (JSONArray) obj;

            //Iterate over array
            decodesList.forEach(dec -> parseDecObj((JSONObject) dec));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the decode line to find desired information
     * @param dec the decode object to be added to the ArrayList
     */
    private void parseDecObj(JSONObject dec) {
    //get bitlink, get timestamp
        String bitlink = (String) dec.get("bitlink");
        bitlink = bitlink.trim();
        String timestamp = (String) dec.get("timestamp");
        timestamp = timestamp.trim();
        Decodes decode = new Decodes(bitlink, timestamp);
        decodesArrayList.add(decode);
    }

    /**
     * @param fileName the name of the file to be parse
     * @return the ArrayList of Decodes
     * @throws FileNotFoundException
     */
    public ArrayList<Decodes> getDecodeArrayList (String fileName) throws FileNotFoundException {
        readFile(fileName);
        return decodesArrayList;
}



}
