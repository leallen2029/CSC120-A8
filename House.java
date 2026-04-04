/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  public int nResidents;
  private boolean hasElevator;


  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);
        this.residents = new ArrayList<Student>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
  }

  public House(String name, String address, int nFloors) {
    this(name, address, nFloors, false, false);
}
  public House(String name, String address) {
    this(name, address, 1, false, false);
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public boolean hasElevator() {
    return this.hasElevator;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(Student student) {
    this.residents.add(student);
  }

  public Student moveOut(Student student) {
    this.residents.remove(student);
    return student;
  }

  public boolean isResident(Student student) {
    return this.residents.contains(student);
  }
  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(Student)\n + moveOut(Student)\n"
        + " + isResident(Student)\n + hasDiningRoom()\n + nResidents()");
}

@Override
public void goToFloor(int floorNum) {
    if (!this.hasElevator) {
        if (Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("This house has no elevator - you can only move one floor at a time.");
        }
    }
    super.goToFloor(floorNum);
}
    public static void main(String[] args) {
      new House("Landree's house", "100 Green Street Northampton, MA 01063", 2, true , false);
      System.out.println("You have built a house: 🏠");
    }
  }