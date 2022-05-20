import java.io.FileNotFoundException;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        DecodesReader dr = new DecodesReader();
        dr.readFile("decodes.json");
    }
}
