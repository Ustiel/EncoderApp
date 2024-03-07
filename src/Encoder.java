import java.util.HashMap;

public class Encoder {

    //Reference table 
    private static final HashMap<Integer, Character> referenceGetChar = new HashMap<Integer, Character>(){};
    private static final HashMap<Character, Integer> referenceGetIdx = new HashMap<Character, Integer>(){};

    // to populate reference table without offset
    public void populateReference (){
        int idx = 0;
        
        // ascii A-Z : 65-90 
        for(int i= 65; i<=90; i++){
            referenceGetChar.put(idx, (char) i);
            referenceGetIdx.put((char) i, idx++);
        }

        // ascii 0-9 : 48-57
        for(int i= 48; i<=57; i++){
            referenceGetChar.put(idx, (char) i);
            referenceGetIdx.put((char) i, idx++);
        }

        // ascii symbols: 40-47
        for(int i= 40; i<=47; i++){
            referenceGetChar.put(idx, (char) i);
            referenceGetIdx.put((char) i, idx++);
        }

        System.out.println(referenceGetIdx); //print reference     
        System.out.println(referenceGetChar); //print reference   
    }

    // Encode plaintext based on random offset char
    public String encode (String plainText){

        int offset = (int)(Math.random() * 44); // generate the index of offset
        String str = String.valueOf(referenceGetChar.get(offset)); // add offset char in string.
        System.out.println(offset + " " + str);
        
        for(int i=0; i<plainText.length(); i++){
            char ch = plainText.charAt(i);

            if (ch == ' '){
                str += " ";
            }
            else{             
                int refIdx = referenceGetIdx.get(ch);
                System.out.println("\nrefidx: " + refIdx);
                int diff = refIdx - offset;
                
                System.out.println("\nSUM " + diff);
                int temp = diff < 0? 44+diff: diff;
                char encodedChar = referenceGetChar.get(temp);
                str += String.valueOf(encodedChar);
            }            
        }

        return str;
    }

    public String decode (String encodedText){
        System.out.println("Encoded text: " + encodedText);
        return "decoded";
    } 
}
