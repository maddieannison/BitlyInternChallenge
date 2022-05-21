import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * The EncodesReader class uses the Apache Commons CSV Library to parse the encodes.csv file
 * and creates an ArrayList of the encode objects
 *
 * @author Madeline Annnison
 */
public class EncodesReader {
    char COMMA_DELIMETER = ',';
    ArrayList<Encodes> encodesArrayList = new ArrayList<>();

    /**
     * Default constructor for the EncodesReader.
     */
    public void encodesReader() {
    }

    /**
     * Reads the encodes.csv file and adds the values into an ArrayList of Encode Objects
     * @param fileName the name of the file to be read
     * @throws IOException
     */
    private void readEFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            CSVParser parser = CSVFormat.DEFAULT.withDelimiter(COMMA_DELIMETER).withHeader().parse(br);
            {
                for (CSVRecord record : parser) {
                    encodesArrayList.add(new Encodes(record.get("long_url"), record.get("domain"), record.get("hash")));
                }
            }
        }
    }

    /**
     * Triggers the readFile function.
     * @param fileName name of the file to be read
     * @return the ArrayList of encode objects.
     * @throws IOException
     */
    public ArrayList<Encodes> getEncodesArrayList(String fileName) throws IOException {
        readEFile(fileName);
        return encodesArrayList;
    }
}




