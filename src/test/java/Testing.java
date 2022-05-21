import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Testing {



    @Before
    public void setUp() throws IOException {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEncodeReader() throws IOException {
        EncodesReader er = new EncodesReader();
        ArrayList<Encodes> testEncodesArray = new ArrayList<>();
        testEncodesArray = er.getEncodesArrayList("test.csv");

        int expected = 2;
        assertEquals(expected, testEncodesArray.size());
    }

    @Test
    public void testEncodesHash() throws IOException {
        EncodesReader er = new EncodesReader();
        ArrayList<Encodes> testEncodesArray = new ArrayList<>();
        testEncodesArray = er.getEncodesArrayList("test.csv");

        String expected = "123";
        assertEquals(expected, testEncodesArray.get(0).getHash());
    }

    @Test
    public void testDecodeReader() throws FileNotFoundException {
        DecodesReader dr = new DecodesReader();
        ArrayList<Decodes> testDecodesArray = new ArrayList<>();
        testDecodesArray = dr.getDecodeArrayList("test.json");

        int expected = 2;
        assertEquals(testDecodesArray.size(), 2);
    }

    @Test
    public void testDecodesTimestamp() throws FileNotFoundException {
        DecodesReader dr = new DecodesReader();
        ArrayList<Decodes> testDecodesArray = new ArrayList<>();
        testDecodesArray = dr.getDecodeArrayList("test.json");

        String expected = "2021";
        assertEquals(expected, testDecodesArray.get(0).getTimestamp().substring(0, 4));
    }

    @Test
    public void testReaderManager() throws IOException {
        ReaderManager r = new ReaderManager("test.csv", "test.json");
    }


}
