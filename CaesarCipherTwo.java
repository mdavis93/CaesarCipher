 


/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    
    ///shiftedAlphabet1 - For odd numbered characters
    ///shiftedAlphabet2 - For even numbered characters
    public CaesarCipherTwo( int key1, int key2 ) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }
    
    // Method to return a capitalized character
    private Character capitalize(Character c, boolean capital) {
        return capital ? Character.toUpperCase(c) : Character.toLowerCase(c);
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isCap = Character.isUpperCase(c);
            
            int alph = alphabet.indexOf(capitalize(c, true));
            
            // Check if the character is in the alphabet
            if( alph != -1 ) {
                // Then, check if we are on an even character. If index is odd, we are.
                if ( i > 0 && (i % 2) == 1 ) {
                    // Even Character, encrypt with key2
                    encrypted.setCharAt(i, isCap ? capitalize(shiftedAlphabet2.charAt(alph), true) : capitalize(shiftedAlphabet2.charAt(alph), false));
                } else {
                    // Odd Character, encrypt with key1
                    encrypted.setCharAt(i, isCap ? capitalize(shiftedAlphabet1.charAt(alph), true) : capitalize(shiftedAlphabet1.charAt(alph), false));
                }
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isCap = Character.isUpperCase(c);
            
            int alph = alphabet.indexOf(capitalize(c, true));
            
            // Does the character exist in the alphabet?
            if (alph != -1) {
                // Is this an odd or even character?
                if ( i > 0 && (i % 2) == 1) {
                    // Even!
                    sb.setCharAt(i, isCap ? capitalize(shiftedAlphabet1.charAt(alph), true) : capitalize(shiftedAlphabet1.charAt(alph), false));
                } else {
                    // Odd!
                    sb.setCharAt(i, isCap ? capitalize(shiftedAlphabet2.charAt(alph), true) : capitalize(shiftedAlphabet2.charAt(alph), false));
                }
                
            } 
        }
        return sb.toString();
    }
    
}