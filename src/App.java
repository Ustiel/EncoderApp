import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {

        // New encoder object
        Encoder encoder = new Encoder();
        encoder.populateReference();

        // User input validation to only allow the characters found in ref table
        String allowedPattern = "^[A-Z0-9 ()*,+\\-./]*$";;
        Pattern regex = Pattern.compile(allowedPattern);
        
        // Read plaintext input
        System.out.println("\n\nPlease enter string to encode/decode:");
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        String str = input.readLine();
        Matcher matcher = regex.matcher(str);

        while (!matcher.matches()) { //Prompt user to enter input again 
            System.out.println("Input should only contain uppercase A-Z, 0-9 or the following symbols ()*+,-./");
            System.out.println("\n\nPlease enter string to encode/decode:");
            input = new BufferedReader (new InputStreamReader(System.in));
            str = input.readLine();
            matcher = regex.matcher(str);
        }
        
        // Read option input
        System.out.println("\n\nTo encode input, enter 1. Else, enter 2 to decode input:");
        input = new BufferedReader (new InputStreamReader(System.in));
        String option = input.readLine();

        while (!(option.equals("1") || option.equals("2"))) { //Prompt user to enter input again 
            System.out.println("Invalid input.");
            System.out.println("\n\nTo encode input, enter 1. Else, enter 2 to decode input:");
            input = new BufferedReader (new InputStreamReader(System.in));
            option = input.readLine();
        }

        //encode / decode
        if(option.equals("1")){
            String encodedStr = encoder.encode(str);
            System.out.printf("\nEncoded string: %s", encodedStr);
        }
        else{
            String decodedStr = encoder.decode(str);
            System.out.printf("\nDecoded string: %s", decodedStr);
        }
    }
}
