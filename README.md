# CaesarCipher
Project files for CaesarCipher Project

All base .java files from the CaesarCipher Project.  This program will encrypt text using the Caesar Cipher, as well as decrypt.  We can also use a double-key cipher to encrypt and decrypt text using this program.

# Files
- CaesarCipher
  - Base file used for encrypting and decrypting single-key ciphers.
  - Used by `Caesar Breaker`, `TestCaesarCipherTwo`, and `TestCaesarCipher`

- CaesarBreaker
  - Contains logic to break the CaesarCipher when the key is not known
  - Used by `CaesarCipher`, `TestCaesarCipher`, `TestCaesarCipherTwo`, and `WordLengths`
  
- CaesarCipherTwo
  - Contains the logic to both encrypt and decrypt using a dual key methodology
  - Used by `TestCaesarCipherTwo`

- TestCaesarCipher
  - Contains test cases for encrypting and decrypting the basic CaesarCipher
  - Used by `CaesarCipher` and `CaesarBreaker`

- TestCaesarCipherTwo
  - Contains the test cases for encrypting and decrypting the dual-key CaesarCipher
  - Used by `CaesarCipherTwo`, `CaesarBreaker`, and `CaesarCipher`
