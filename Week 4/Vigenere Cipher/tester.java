
/**
 * Write a description of class tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class tester {
    
    CaesarCipher cc = new CaesarCipher(15);
    FileReader fr = new FileReader("titus-small.txt");
    StringBuilder sb = new StringBuilder(fr);
    String input = sb.asString();
    cc.encrypt(input); 

}
