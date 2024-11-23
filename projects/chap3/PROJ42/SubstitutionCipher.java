// Implement a class, SubstitutionCipher, with a constructor that takes a
// string with the 26 uppercase letters in an arbitrary order and uses that
// as the encoder for a cipher (that is, A is mapped to the first character
// of the parameter, B is mapped to the second, and so on.) You should
// derive the decoding map from the forward version.

package projects.chap3.PROJ42;

import java.util.HashMap;
import java.util.HashSet;

public class SubstitutionCipher {
  HashMap<Integer, Character> alphabet = new HashMap<>();
  HashMap<Character, Integer> decoder = new HashMap<>();
  HashMap<Integer, Character> encoder = new HashMap<>();

  // Create a decoder using the standard shift method
  // I did not immediately realize the project was different from the book
  // example. Please note that there is another constructor below
  public SubstitutionCipher (int shift)
  {
    if (shift < 0)
    {
      shift = shift * -1;
    }
    shift = shift % 26;
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String shifted = letters.substring(shift) + letters.substring(0, shift);
    encoderHashMapify(shifted);
    decoderHashMapify(shifted);
    alphabetHashMap();
  }

  public SubstitutionCipher (String cipher)
  {
    cipher = cipher.toUpperCase();
    // Throws error if cipher is not 26 characters and if it is not just A-Z
    if(cipher == null || cipher.length() != 26 || !cipher.matches("[A-Z]{26}"))
    {
      String errorMessage = "Cipher must be a 26 character string";
      throw new IllegalArgumentException(errorMessage);
    }
    
    // Throws error if letters appear more than once
    HashSet<Character> set = new HashSet<>();
    for(int i = 0; i < 26; i++)
    {
      if(!set.add(cipher.charAt(i)))
      {
        String errorMessage = "Cipher must contain each letter only once";
        throw new IllegalArgumentException(errorMessage);
      }
    }
    encoderHashMapify(cipher);
    decoderHashMapify(cipher);
    alphabetHashMap();
  }

  public void alphabetHashMap()
  {
    for (char c = 'A'; c <= 'Z'; c++)
    {
      alphabet.put(c - 'A', c);
    }
  }

  private void encoderHashMapify(String shifted)
  {
    // Converts string to array
    char[] array = shifted.toCharArray();

    // Gets current letter position and corresponding letter and puts
    // it into a hashmap
    for(int i = 0; i < array.length; i++)
    {
      this.encoder.put(i, array[i]);
    }
  }

  private void decoderHashMapify(String shifted)
  {
    // Converts string to array
    char[] array = shifted.toCharArray();

    // Gets current letter and puts corresponding letter position into hashmap
    for(int i = 0; i < array.length; i++)
    {
      this.decoder.put(array[i], i);
    }
  }

  // Encode the message
  public String encode(String mess)
  {
    // Grabs len of string and converts all to upper case
    int len = mess.length();
    mess = mess.toUpperCase();
    char[] letters = mess.toCharArray();

    // Traverses length of array converting each letter individually
    for(int i = 0; i < len; i++)
    {
      // If the position in the array is not currently within the scope of
      // A-Z, it skips this iteration of the loop
      if(letters[i] < 'A' || letters[i] > 'Z')
      {
        continue;
      }
      // We get the int value of the character starting from 0
      // and then get the corresponding letter from the hashmap we
      // generated earlier
      // We then replace the letters individually within the array to
      // the encoded values
      char encLetter = this.encoder.get((int)letters[i]-'A');
      letters[i] = encLetter;
    }

    // Convert array back to string and return
    String encrypted = new String(letters);
    return encrypted;
  }

  public String decode(String mess)
  {
    // Convert string to uppercase, grab length, and convert to char array
    int len = mess.length();
    mess = mess.toUpperCase();
    char[] letters = mess.toCharArray();

    // Traverse length of array
    for(int i = 0; i < len; i++)
    {
      // Skip values out of scope of A-Z
      if(letters[i] < 'A' || letters[i] > 'Z')
      {
        continue;
      }

      // Grab int values of letters from decoder
      // Grab letter values of ints from alphabet
      // Change letter
      char decLetter = this.alphabet.get(this.decoder.get(letters[i]));
      letters[i] = decLetter;
    }

    // Convert array of letters back into string
    String decrypted = new String(letters);
    return decrypted;
  }
}
