/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Scanner;

public class Library extends Building implements LibraryRequirements {
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    // original 
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.hasElevator = hasElevator;
        collection = new Hashtable<>();
        System.out.println("You have built a library: 📖");
    }

    // overload. no floors specified, sets min of 1
    public Library(String name, String address) {
        this(name, address, 1, false);
    }

    // overload. no address or floors specified
    public Library(String name) {
        this(name, "<Address Unknown>", 1, false);
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

  @Override
  public void handleAction(String action, Scanner scan) {
      if (action.equalsIgnoreCase("checkout")) {
          System.out.println("What is the title?");
          scan.nextLine();
          String title = scan.nextLine();
          this.checkOut(title);
      } else {
          super.handleAction(action, scan);
      }
  }

  @Override
  public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle(title)\n + removeTitle(title)\n"
          + " + checkOut(title)\n + returnBook(title)\n"
          + " + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
  }
  @Override
  public void goToFloor(int floorNum) {
      if (!this.hasElevator) {
          if (Math.abs(floorNum - this.activeFloor) > 1) {
              throw new RuntimeException("This Library has no elevator - you can only move one floor at a time.");
          }
      }
      super.goToFloor(floorNum);
  }
  @Override
  public String getExtraOptions() {
    return ", checkout";
}

      public static void main(String[] args) {
        new Library("Main Library", "123 Main Street", 3, false);
      }
  }