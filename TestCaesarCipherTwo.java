 
import edu.duke.*;

/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {

    CaesarBreaker cb = new CaesarBreaker();
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        String encrypted = cc.encrypt( message );
        System.out.println("ENCRYPTED MESSAGE:");
        System.out.println(encrypted + "\n-----------------");
        breakCaesarCipher(encrypted);
        
    }
    
    public void examTests() {
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/java/mysteryTwoKeysQuiz.txt");
        String Q8 = url.asString();
        
        breakCaesarCipher(Q8);
        
    }
    
    public void breakCaesarCipher(String input) {
        String firstHalf = cb.getHalfOfString(input, 0);
        String secondHalf = cb.getHalfOfString(input, 1);
        
        int key1 = 26 - cb.getKey(firstHalf);
        int key2 = 26 - cb.getKey(secondHalf);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(key2, key1);
        
        System.out.println("\nDECRYPTED MESSAGE (" +key1+","+key2+"):");
        System.out.println(cc.decrypt(input));
    }
    
    private String breakCaesar(String input) {
        String firstHalf = cb.getHalfOfString(input, 0);
        String secondHalf = cb.getHalfOfString(input, 1);
        
        int key1 = 26 - cb.getKey(firstHalf);
        int key2 = 26 - cb.getKey(secondHalf);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(key2, key1);
        System.out.println("\n[Key1 = " + key1 + "]   [Key2 = " + key2 + "]");
        return cc.decrypt(input);
    }
}
