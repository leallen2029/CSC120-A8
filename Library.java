/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }

    public void addBook(String title, boolean isAvailable) {
      collection.put(title, isAvailable);
    }

    public void addTitle(String title) {
      collection.put(title, true);
    }
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    }

    public void checkOut(String title) {
      collection.put(title, false);
    }

    public void returnBook(String title) {
      collection.put(title, true);
    }
    public boolean containsTitle(String title){  // returns true if the title appears as a key in the Libary's collection, false otherwise
      if (collection.containsKey(title)){
        return true;
      } return false;
    }

    public boolean isAvailable(String title){ // returns true if the title is currently available, false otherwise
      if (collection.get(title) == true){
        return true;
      } return false;
    } 
    
    
  public void printCollection(){ // prints out the entire collection in an easy-to-read way (including checkout status)
    for (String title : collection.keySet()) {
      if (collection.get(title)) {
        System.out.println(title + ": Available");
  }   else {
        System.out.println(title + ": Checked Out");
      }
    }
  }





    public static void main(String[] args) {
      new Library("Main Library", "123 Main Street", 3);
    }


  }