 
import edu.duke.*;

/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    CaesarBreaker cb = new CaesarBreaker();
    
    private int[] countLetters(String message) {
        return cb.getLetters(message);
    }
    
    private int maxIndex(int[] counts) {
        int tmp = cb.getMaxIndex(counts);
        
        return tmp;
    }
    
    private String breakCaesarCipher(String input) {
        int[] freq = countLetters(input);
        int maxDex = maxIndex(freq);
        int key = (maxDex - 4) < 4 ? (26 - (4 - maxDex)) : maxDex - 4;
        
        CaesarCipher cc = new CaesarCipher(key);
        
        return cc.decrypt(input);
    }
    
    public void simpleTests() {
        // Read a file as a string
        FileResource fr = new FileResource();
        String data = fr.asString();
        // Create a CaesarCipher object, with key 18
        CaesarCipher cc = new CaesarCipher(18);
        // Encrypt the string using the created cipher
        String encryptedData = cc.encrypt(data);
        // Print the encrypted string
        System.out.println("Encrypted: " + encryptedData);
        // Decrypt the string using the decrypt method
        System.out.println("Decrypted: " + cc.decrypt(encryptedData));
        // Decrypt a string with an unknown key
        System.out.println(breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!"));
    }
}
