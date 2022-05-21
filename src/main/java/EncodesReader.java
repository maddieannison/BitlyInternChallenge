import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.List;

public class EncodesReader {
    char COMMA_DELIMETER = ',';
    ArrayList<String> urls = new ArrayList<>();

    public void encodesReader() {
    }

    private void readEFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            CSVParser parser = CSVFormat.DEFAULT.withDelimiter(COMMA_DELIMETER).withHeader().parse(br);
            {
                for (CSVRecord record : parser) {
                    urls.add("http://"+ record.get("domain") + "/" + record.get("hash"));
                }
            }
        }
    }

    public ArrayList<String> getUrls (String fileName) throws IOException {
        readEFile(fileName);
        return urls;
    }
}




