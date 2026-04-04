/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  public int nResidents;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<Student>();
        this.hasDiningRoom = hasDiningRoom;
  }

  public House(String name, String address, int nFloors) {
    this(name, address, nFloors, false);
}
  public House(String name, String address) {
    this(name, address, 1, false);
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
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

    public static void main(String[] args) {
      new House("Landree's house", "100 Green Street Northampton, MA 01063", 2, true);
      System.out.println("You have built a house: 🏠");
    }
  }