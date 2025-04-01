/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Map;

/**
 * The Library class extends the Building class and manages the lists of books and collections.
 */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  /**
  * Construct with provided name, address, floors number.
  *
  * @param name Name of the house
  * @param address Address of the house
  * @param nFloors FLoors number in the house
  */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
  }


  /**
  * The title of the books are added to the collection list. If the book was in the collection, change it state to true.
  *
  * @param title Title of the added book.
  */
  public void addTitle(String title){
    if (collection.containsKey(title)) {
        collection.put(title, true);
    } else {
        collection.put(title, true);
    }
  }

  /**
   * The title of the books are removed from the collection list. If the title is not in the list, throw an error exception.
   *
   * @param title Title of the removed books.
   * @return Title of the removed books.
   * @throws IllegalArgumentException if the title is not found in the collection.
   */  
  public String removeTitle(String title){
    if (collection.containsKey(title)) {
        collection.remove(title);
        return title;
    } else {
        throw new IllegalArgumentException("Title not found in the collection: " + title);
    }
  }

  /**
   * The title of the books that are borrowed out are changed to false at the key. And print the title is not found if the books are not found in the collection.
   *
   * @param title Title of the book that is borrowed.
   * @throws IllegalArgumentException if the book is not found in the collection.
   */  
  public void checkOut(String title){
    if (collection.containsKey(title)) {
        if (collection.get(title)) {
            collection.put(title, false); 
        } else {
            throw new IllegalStateException("The book '" + title + "' is already checked out.");
        }
    } else {
        throw new IllegalArgumentException("Title not found in the collection: " + title);
    }
  }
  
  /**
   * The title of the books are changed to true for the key in the collection. If the title is not in collection, it will print the title is not in the collection.
   *
   * @param title Title of the returned books.
   * @throws IllegalArgumentException if the book is not checked out.
   */  
  public void returnBook(String title){
    if (collection.containsKey(title)) {
        if (!collection.get(title)) {
            collection.put(title, true); 
        } else {
            throw new IllegalStateException("The book '" + title + "' is not checked out.");
        }
    } else {
        throw new IllegalArgumentException("Title not found in the collection: " + title);
    }
  }
  
  /**
   * The title of the book is checked whether it is in the collection.
   *
   * @param title Title of the books that are going to be checked whether they are in the collection.
   * @return return true if the collection contains the titles, return false if the collection did not contain the titles.
   */  
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * The title of the books are removed from the collection list.
   *
   * @param title Title of the removed books.
   * @return True if the book is available, False if the book is not available or not existing in the collection.
   */  
  public boolean isAvailable(String title){
    return collection.getOrDefault(title,false);
  }

  /**
   * Prints all books in the collection along with their availability status.
   * 
   * Each book is listed with its title followed by either "Available" or "Checked out".
   */
  public void printCollection(){
    System.out.println("Library Collection");
    for(Map.Entry<String, Boolean> entry : collection.entrySet()){
        String status = entry.getValue() ? "Available" : "Checked out";
        System.out.println(entry.getKey() + " - " + status);
    }
  }

  /**
   * Main method to show the functionality of the Library class.
   */
  public static void main(String[] args) {
    System.out.println("You have built a library: 📖");
    Library library = new Library("Joyce" , "7 Joyce Drive",3);
    library.addTitle("Grignard Reaction");
    library.addTitle("Chemistry");
    library.addTitle("Chemical Reactions");
    library.checkOut("Chemistry");
    library.returnBook("Chemistry");
    library.printCollection();
    System.out.println(library.isAvailable("Chemical Reactions"));
  }

}