import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReaderManager {
    int count = 0;

    String eFile = "encodes.csv";
    String dFile = "decodes.json";

    DecodesReader dr = new DecodesReader();
    EncodesReader er = new EncodesReader();

    public ReaderManager() throws IOException {
        compareEAndD();
    }

    private void compareEAndD() throws IOException {
        ArrayList<String> urls = er.getUrls(eFile);
        dr.readFile(dFile);
        ArrayList<Decodes> decodesArrayList = dr.getDecodeArrayList();
        for (int i = 0; i < decodesArrayList.size(); i++) {
            System.out.println(decodesArrayList.get(i).getBitlink());
        }

//        for (int i = 0 ; i < urls.size(); i++) {
//            for (int j = 0; j < decodesArrayList.size(); j++) {
//                // if matching bitlinks
//                if (urls.get(i).equals(decodesArrayList.get(i).getBitlink()) && decodesArrayList.get(i).getTimestamp().substring(0,3).equals("2021")) {
//                    count++;
//                }
//            }
//        }
    }




}
