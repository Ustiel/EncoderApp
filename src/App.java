import java.io.BufferedReader;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws Exception {

        // New encoder object
        Encoder encoder = new Encoder();
        encoder.populateReference();
        
        System.out.println("\n\nPlease enter string to encode:");
        
        // Read input
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        String str = input.readLine();


        String encodedStr = encoder.encode(str);
        
        System.out.printf("\nEncoded string: %s", encodedStr);
    }
}
