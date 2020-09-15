import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder (message);
        String result = "";
        for(int k = whichSlice; k < sb.length(); k+=totalSlices) {
            result += sb.charAt(k);
        }
        return result   ;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        int aKey = 0;
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int k = 0; k < klength; k++) { 
            aKey = cc.getKey(sliceString(encrypted, k, klength));
            key[k] = aKey;
        }
        /*
         * for (int i = 0; i < klength; i++) {
            String slicedMessage = sliceString(encrypted, i, klength);
            CaesarCracker cc = new CaesarCracker();
            key[i] = cc.getKey(slicedMessage);
        }
         */
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource("messages/secretmessage2.txt");
        String readFr = fr.asString();
        FileResource lang = new FileResource("dictionaries/English");
        int[] key = tryKeyLength(readFr, 38, 'e');
        HashSet<String> dictionary = readDictionary(lang);
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = breakForLanguage(readFr, dictionary);
        //String decrypted = vc.decrypt(readFr);
        System.out.println(decrypted);
        System.out.println("Key: " + key );
    }
    
    public HashSet<String> readDictionary (FileResource fr){
        HashSet<String> cad = new HashSet<String>();
        for(String s : fr.lines()){
            String input = s.toLowerCase(); 
            cad.add(input);
        }
        return cad;
    }
    
    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        ArrayList<String> MsgWord = new ArrayList<String>(Arrays.asList(message.split("\\W")));
        for(int k = 0; k < MsgWord.size(); k++) {
            if(dictionary.contains(MsgWord.get(k).toLowerCase())){
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage (String encrypted, HashSet<String> dictionary ) {
        int max = 0;
        int[] key = new int [100];
        int keyLength = 0;
        String msg = "";
        String description = "";
        String[] decryted = new String[100];
        
        for ( int k = 1; k < 100; k++){ 
            key = tryKeyLength(encrypted, k, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            msg = vc.decrypt(encrypted);
            int count = countWords(msg, dictionary);
            if(count > max){
                max = count;
                description = msg;
                keyLength = k;
            }
        }
        
        System.out.println("Max counts: " + max);
        System.out.println("Proper key: " + keyLength);
        return description;        
    }
    
    public void mostCommonCharIn(HashSet<String> dictionary) {
        
    }
}
