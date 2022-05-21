import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

public class ReaderManager {
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
        System.out.println(urls);
    }


}
