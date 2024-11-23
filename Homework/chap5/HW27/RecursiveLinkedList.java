package Homework.chap5.HW27;

public class RecursiveLinkedList {
  private RecursiveLinkedList next;
  public int data;

  // Constructor
  public RecursiveLinkedList (int data)
  {
    this.data = data;
    this.next = null;
  }

  // Appends. If this.next is null, appends here. If it isn't, recursively
  // calls this.next.append until it finds node with this.next null
  public void append(int data)
  {
    RecursiveLinkedList newNode = new RecursiveLinkedList(data);
    if(this.next == null)
    {
      this.next = newNode;
    }
    else
    {
      this.next.append(data);
    }
  }

  // Recursively calls itself down the linked list adding 1 to the return
  // value until this.next is equal to null
  public int getSize()
  {
    if(this.next == null)
    {
      return 1;
    }
    else
    {
      return 1 + this.next.getSize();
    }
  }

  // Searches for the data provided. If it finds it, it returns back true all
  // the way back up the chain. If it gets to this.next == null without
  // finding the value, it returns false. If this.next still exists
  // it will continue to search down the list for the value
  public boolean search(int data)
  {
    if(this.data == data)
    {
      return true;
    }
    else if(this.next == null)
    {
      return false;
    }
    else
    {
      return this.next.search(data);
    }
  }

  // Kind of like search, but instead of looking for a value, you
  // presumeably know what entry your data is in and want to return a
  // specific node's data
  public int getData(int i)
  {
    if(i == 0)
    {
      return this.data;
    }
    else
    {
      return this.next.getData(i - 1);
    }
  }

  // Prints current data. Checks if this.next exists. If does not, returns.
  // Otherwise, continues down the linked list printing
  public void print()
  {
    System.out.print(this.data + " ");
    if(this.next == null)
    {
      System.out.println();
      return;
    }
    this.next.print();
  }
}
