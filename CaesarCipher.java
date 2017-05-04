 

import edu.duke.*;
/**
 * Write a description of Assignment2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int masterKey;
    
    public String getAlphabet() {
        return alphabet;
    }
    
    public int getMasterKey() {
        return masterKey;
    }
    
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        masterKey = key;
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    }
    
    private boolean isCapital (char c) {
        return Character.isUpperCase(c);
    }
    
    public String decrypt( String input ) {
        CaesarCipher cc = new CaesarCipher(26-masterKey);
        
        return cc.encrypt(input);
    }
   
    public String decryptThis (String input, int key) {
        key = 26 - key;
        return encrypt(input, key);
    }
    
    public String decryptThis (String input, int key1, int key2) {
        key1 = 26 - key1;
        key2 = 26 - key2;
        
        return encrypt(input, key1, key2);
    }
    
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isCapital = Character.isUpperCase(c);
            
            if (alphabet.indexOf(c) != -1) {
                encrypted.setCharAt(i, isCapital ? Character.toUpperCase(shiftedAlphabet.charAt(alphabet.indexOf(c))) : shiftedAlphabet.charAt(alphabet.indexOf(c)));
            } else {
                encrypted.setCharAt(i, c);
            }
        }
        
        return encrypted.toString();
    }
   
    private String encrypt (String input, int key) {
        
        StringBuilder encrypted = new StringBuilder(input);
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isCap = isCapital(c);
            c = Character.toUpperCase(c);
            
            if ( alphabet.toUpperCase().indexOf(Character.toUpperCase(c)) != -1 ) {
                
                int alph = alphabet.indexOf(c);
                char ch = shiftedAlphabet.charAt(alph);
                
                encrypted.setCharAt(i, isCap ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
            } else {
                encrypted.setCharAt(i, isCap ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }
        
        return encrypted.toString();
    }
    
    private String encrypt (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        //String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedOdd = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedEven = alphabet.substring(key2) + alphabet.substring(0,key2);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isCap = isCapital(c);
            
            alphabet = isCap ? alphabet.toUpperCase() : alphabet.toLowerCase();
            int alph = alphabet.indexOf(c);
            
            // Check if the character is in the alphabet
            if( alph != -1 ) {
                // Then, check if we are on an even character. If index is odd, we are.
                if ( i > 0 && (i % 2) == 1 ) {
                    // Even Character, encrypt with key2
                    encrypted.setCharAt(i, isCap ? Character.toUpperCase(shiftedEven.charAt(alph)) : Character.toLowerCase(shiftedEven.charAt(alph)));
                } else {
                    // Odd Character, encrypt with key1
                    encrypted.setCharAt(i, isCap ? Character.toUpperCase(shiftedOdd.charAt(alph)) : Character.toLowerCase(shiftedOdd.charAt(alph)));
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesar() {
        FileResource fr = new FileResource();
        int key = 15;
        
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println( "The key is " + key + ".\n\n" + encrypted );
    }
    
    public void testEncrypt() {
        System.out.println("Encrypt: " + encrypt("FREE CAKE IN THE CONFERENCE ROOM!", 15));
        System.out.println("Decrypt: " + decrypt("UGTT RPZT XC IWT RDCUTGTCRT GDDB!"));
    }
    
    public void examQuestions() {
        String q1 = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String q2 = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        
        String encrypted1 = encrypt( q1, 15 );
        String encrypted2 = encrypt( q2, 21, 8 );
        
        System.out.println( encrypted1 + "\n" + encrypted2 );
    }
}
