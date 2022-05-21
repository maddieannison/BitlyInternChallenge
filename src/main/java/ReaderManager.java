import org.json.simple.JSONArray;
import java.io.IOException;
import java.util.*;

/**
 * The ReaderManager deals with reading and handling the project files. It creates instances of the Reader classes and uses them along with
 * the object classes to extract data, perform comparative logic, and convert to JSON to be printed to the console.
 *
 * @author Madeline Annison
 */
public class ReaderManager {
    String eFile = "encodes.csv";
    String dFile = "decodes.json";

    /**
     * Constructor for ReaderManager class.
     * @throws IOException
     */
    public ReaderManager() throws IOException {
        run();
    }

    /**
     * Main function for ReaderManager class. Includes comparative logic to find matching bitlinks & timestamps in decodes.json file.
     * @throws IOException
     */
    private void run() throws IOException {
        ArrayList<Output> outputs = new ArrayList<>();

        DecodesReader dr = new DecodesReader();
        EncodesReader er = new EncodesReader();

        ArrayList<Encodes> encodesArrayList = er.getEncodesArrayList(eFile);
        ArrayList<Decodes> decodesArrayList = dr.getDecodeArrayList(dFile);

        int count = 0;

        //Iterate through array lists
        for (int i = 0; i < encodesArrayList.size(); i++) {
            for (int j = 0; j < decodesArrayList.size(); j++) {
                //Check for same bitlink
                if ((encodesArrayList.get(i).toURL().equals(decodesArrayList.get(j).getBitlink()))) {
                    //Check for correct timestamp
                    if (decodesArrayList.get(i).getTimestamp().startsWith("2021")){
                        //Increment click count
                        count++;
                    }
                }
            }
            //Add the long_url and click count to a JSON array
            addOutput(outputs, encodesArrayList.get(i).getLong_url(), count);
            //Reset the click count
            count = 0;
        }
        sort(outputs);
    }

    /**
     * Adds desired outputs to an ArrayList that will be sorted and converted to a JSONArray later.
     * @param outputs the ArrayList of outputs
     * @param long_url the long_url of the object in the ArrayList
     * @param count the click count of the object in the ArrayList
     */
    private void addOutput(ArrayList<Output> outputs, String long_url, int count) {
        outputs.add(new Output(long_url, count));
    }

    /**
     * Sorts the ArrayList based on the click count number
     * @param outputs the ArrayList of outputs
     */
    private void sort(ArrayList<Output> outputs) {
        Collections.sort(outputs, Comparator.comparing(Output::getCount));
        outputToJSON(outputs);
    }

    /**
     * Converts ArrayList to JSONArray and prints it to the console
     * @param outputs the ArrayList of outputs
     */
    private void outputToJSON(ArrayList<Output> outputs) {
        JSONArray jsonArray = new JSONArray();
        for (Output output : outputs) {
            jsonArray.add(output.toJSON());
        }
        System.out.println(jsonArray);
    }
}
