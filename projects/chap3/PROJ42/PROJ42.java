// Design a RandomCipher class as a subclass of the SubstitutionCipher
// from Exercise 3.11.40, so that each instance of the class relies on
// a random permutation of letters for its mapping.

package projects.chap3.PROJ42;

public class PROJ42 {
  public static void main(String[] args)
  {
    // Test Cipher using shift
    String message1 = "Big Bird Loves The Streets";

    // Set of tests using shift method
    System.out.println("Test Shift Constructor:");
    SubstitutionCipher cipher = new SubstitutionCipher(3);
    String encrypted1 = cipher.encode(message1);
    System.out.println("Encrypted: " + encrypted1);
    System.out.println("Decrypted: " + cipher.decode(encrypted1));

    // Set of tests using input cipher method
    System.out.println("\nTest Cipher Input Constructor: ");
    String randlets = "KLRNHBEDWZUXCFPGTMSOJQAIYV";
    SubstitutionCipher cipher2 = new SubstitutionCipher(randlets);
    String encrypted2 = cipher2.encode(message1);
    System.out.println("Encrypted: " + encrypted2);
    System.out.println("Decrypted: " + cipher2.decode(encrypted2));

    // Set of tests using random. First time
    RandomCipher randCipher1 = new RandomCipher();
    System.out.println("\nRandomCipher Test 1: ");
    System.out.println("Encrypted: " + randCipher1.encode(message1));
    String encrypted3 = randCipher1.encode(message1);
    System.out.println("Decrypted: " + randCipher1.decode(encrypted3));

    // Set of tests using random. Second Time
    RandomCipher randCipher2 = new RandomCipher();
    System.out.println("\nRandomCipher Test 2 (Different): ");
    System.out.println("Encrypted: " + randCipher2.encode(message1));
    String encrypted4 = randCipher2.encode(message1);
    System.out.println("Decrypted: " + randCipher2.decode(encrypted4));
  }
}