// Repeat Exercise 3.11.37, but use a doubly linked list. Moreover, your
// implementation of remove(i) should make the fewest number of pointer
// hops to get to the game entry at index .

package labs.chap3.LAB38;

public class LAB38 {
  public static void main(String[] args)
  {
    DoublyLinkedList highScores = new DoublyLinkedList();

    // Testing adding highscores with various scores in various orders
    highScores.add(2000, "Faker");
    highScores.add(100,"Larry");
    highScores.add(200, "Brian");
    highScores.add(900, "PashaBiceps");
    highScores.add(300, "Big Dog");
    highScores.add(400, "Alex");
    highScores.add(500, "Ya Boi");
    highScores.add(1300, "Super");
    highScores.add(600, "Peter");
    highScores.add(700, "Pinball Wizard");
    highScores.add(2000, "Chovy");
    highScores.add(1600, "shroud");
    highScores.add(800, "Joshua");
    highScores.add(1000, "Faker");

    System.out.println("Baseline");
    // Print to check if top 10 is retained in order
    highScores.print();

    System.out.println("Baseline Backwards");
    // Print to check if prev pointers are correct
    highScores.printReverse();
    

    // Test remove function
    highScores.remove(800,"Joshua");
    highScores.remove(700, "Pinball Wizard");

    System.out.println("Remove Function");
    highScores.print();
    System.out.println("Remove Function Backwards");
    highScores.printReverse();

    // Test remove function at the head of the linked list
    highScores.remove(2000, "Faker");

    System.out.println("Remove At Head");
    highScores.print();
    System.out.println("Remove At Head Reverse");
    highScores.printReverse();

    // Test remove function at the end of the linked list
    highScores.remove(500, "Ya Boi");

    System.out.println("Remove At Tail");
    highScores.print();
    System.out.println("Remove At Tail Reverse");
    highScores.printReverse();

    // Test remove function where entry does not exist
    highScores.remove(200, "Bepp");

    System.out.println("Remove Nonexistent");
    highScores.print();
    System.out.println("Remove Nonexistent Reverse");
    highScores.printReverse();
  }
}
