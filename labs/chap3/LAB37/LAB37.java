// Write a class that maintains the top ten scores for a game application,
// implementing the add and remove methods of Section 3.1, but using a
// singly linked list instead of an array.

package labs.chap3.LAB37;

public class LAB37 {
  public static void main(String[] args)
  {
    SinglyLinkedList highScores = new SinglyLinkedList();

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

    // Print to check if top 10 is retained in order
    highScores.print();

    // Test remove function
    highScores.remove(800,"Joshua");
    highScores.remove(700, "Pinball Wizard");

    highScores.print();

    // Test remove function at the head of the linked list
    highScores.remove(2000, "Faker");

    highScores.print();

    // Test remove function at the end of the linked list
    highScores.remove(500, "Ya Boi");

    highScores.print();

    // Test remove function where entry does not exist
    highScores.remove(200, "Bepp");

    highScores.print();
  }
}
