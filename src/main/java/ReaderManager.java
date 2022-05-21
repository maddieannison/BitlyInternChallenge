import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.*;


public class ReaderManager {
    int count = 0;
    String clickCount;

    String eFile = "encodes.csv";
    String dFile = "decodes.json";


    public ReaderManager() throws IOException {
        run();
    }

    private void run() throws IOException {
        ArrayList<Output> outputs = new ArrayList<>();
        ArrayList<Output> test = new ArrayList<>();

        DecodesReader dr = new DecodesReader();
        EncodesReader er = new EncodesReader();

        ArrayList<Encodes> encodesArrayList = er.getEncodesArrayList(eFile);
        ArrayList<Decodes> decodesArrayList = dr.getDecodeArrayList(dFile);

//        for (int i  = 0; i < encodesArrayList.size(); i++) {
//            System.out.println(encodesArrayList.get(i).toURL());
//            addOutput(test, encodesArrayList.get(i).getLong_url(), clickCount);
//        }




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
            //Convert count int to count string
            clickCount = Integer.toString(count);
            //Add the long_url and click count to a JSON array
            addOutput(outputs, encodesArrayList.get(i).getLong_url(), clickCount);
            //Reset the click count
            count = 0;
        }
        sort(outputs);
    }

    private void addOutput(ArrayList<Output> outputs, String long_url, String count) {
        outputs.add(new Output(long_url, count));
    }

    private void sort(ArrayList<Output> outputs) {
        Collections.sort(outputs, Comparator.comparing(Output::getCount));

        outputToJSON(outputs);
    }

    private void outputToJSON(ArrayList<Output> outputs) {
        JSONArray jsonArray = new JSONArray();
        for (Output output : outputs) {
            jsonArray.add(output.toJSON());
//            System.out.println(output.toJSON());
        }
        System.out.println(jsonArray);
    }


}
