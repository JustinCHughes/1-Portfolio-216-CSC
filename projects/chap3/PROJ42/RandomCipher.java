// Design a RandomCipher class as a subclass of the SubstitutionCipher
// from Exercise 3.11.40, so that each instance of the class relies on
// a random permutation of letters for its mapping.

package projects.chap3.PROJ42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCipher extends SubstitutionCipher {
  private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                'Y', 'Z'};

  public RandomCipher()
  {
    super(shuffle());
  }

  private static String shuffle()
  {
    List<Character> letters = new ArrayList<>();
    for(char element : ALPHABET)
    {
      letters.add(element);
    }

    Collections.shuffle(letters);

    // It was a list of characters instead of chars so I couldn't
    // just use new String(char array). Had to use StringBuilder
    StringBuilder build = new StringBuilder();
    for(Character element : letters)
    {
      build.append(element);
    }
    
    return build.toString();
  }
}
