 
import edu.duke.*;

/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {

    private int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] letters = new int[26];
        
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            
            if( dex != -1 ) {
                letters[dex] += 1;
            }
        }
        
        return letters;
    }
    
    public int[] getLetters(String message) {
        return countLetters(message);
    }
    
    private int maxIndex(int[] counts) {
        int maxDex = 0;
        
        for (int i = 0; i < counts.length; i++) {
            if ( counts[i] > counts[maxDex] ) {
                maxDex = i;
            }
        }
        
        return maxDex;
    }
    
    public int getMaxIndex(int[] counts) {
        return maxIndex(counts);
    }
    
    private String halfOfString(String message, int start) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = start; i < message.length(); i += 2) {
            builder.append(message.charAt(i));
        }
        
        return builder.toString();
    }
    
    public String getHalfOfString(String message, int start) {
        return halfOfString(message, start);
    }
    
    public int getKey (String s) {
        int[] freq = countLetters(s);
        int maxIndex = maxIndex(freq);
        int key = maxIndex - 4;
        
        if (maxIndex < 4 ) {
            key = 26 - ( 4 - maxIndex );
        }
        
        return key;
    }
    
    private String decrypt(String encrypted, int key) {
        CaesarCipher cc = new CaesarCipher(key);
        String message = cc.decryptThis(encrypted, key);
        
        return message;
    }
    
    private String decryptTwoKeys( String encrypted ) {
        // Calculate a string of every other char starting with the 1st char of encrypted by calling 'halfOfString'
        String firstHalf = halfOfString(encrypted, 0);
        // Calculate a string of every other char starting with the 2nd char of encrypted by calling 'halfOfString'
        String secondHalf = halfOfString(encrypted, 1);
        // Calculate the key used to encrypt each halfOfString
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        
        // Print the cracked keys
        System.out.println("Key1: " + key1 + "\nKey2: " + key2);
        
        // Calculate and return the decrypted string using the 'encryptTwoKeys' method
        CaesarCipher cc = new CaesarCipher(key1);
        return cc.decryptThis(encrypted, key1, key2);
    }
    
    private String decryptTwoKeys( String encrypted, int key1, int key2 ) {
        // Calculate a string of every other char starting with the 1st char of encrypted by calling 'halfOfString'
        String firstHalf = halfOfString(encrypted, 0);
        // Calculate a string of every other char starting with the 2nd char of encrypted by calling 'halfOfString'
        String secondHalf = halfOfString(encrypted, 1);
        // Calculate the key used to encrypt each halfOfString
        
        // Print the cracked keys
        System.out.println("Key1: " + key1 + "\nKey2: " + key2);
        
        // Calculate and return the decrypted string using the 'encryptTwoKeys' method
        CaesarCipher cc = new CaesarCipher(key1);
        return cc.decryptThis(encrypted, key1, key2);
    }
    
    private String decryptTwoKeys( URLResource fr) {
        String encrypted = fr.asString();
        // Calculate a string of every other char starting with the 1st char of encrypted by calling 'halfOfString'
        String firstHalf = halfOfString(encrypted, 0);
        // Calculate a string of every other char starting with the 2nd char of encrypted by calling 'halfOfString'
        String secondHalf = halfOfString(encrypted, 1);
        // Calculate the key used to encrypt each halfOfString
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        
        // Print the cracked keys
        System.out.println("Key1: " + key1 + "\nKey2: " + key2);
        
        // Calculate and return the decrypted string using the 'encryptTwoKeys' method
        CaesarCipher cc = new CaesarCipher(key1);
        return cc.decryptThis(encrypted, key1, key2);
    }
    
    public void testHalfOfString() {
        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));
        System.out.println(halfOfString("Michael", 0));
    }
    
    public void testDecrypt() {
        String singleEncrypted = "UGTT RPZT XC IWT RDCUTGTCRT GDDB!";
        int key = getKey(singleEncrypted);
        
        System.out.println("Decryption Key: " + key);
        System.out.println("\nBEFORE: " + singleEncrypted + "\nAFTER : " + decrypt(singleEncrypted, key));
    }
    
    public void testDoubleKeyDecrypt() {
        String doubleEncryption = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println(decryptTwoKeys(doubleEncryption, 2, 20));
    }
    
    public void testCountLetters() {
        int[] counts = countLetters("The quick red fox jumps over the lazy brown dog.");
        
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + (i > 9 ? i : " " + i) + "] is " + counts[i]);
        }
        
        maxIndex(counts);
    }
}
