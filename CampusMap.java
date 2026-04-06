import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }
    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }
    
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }


    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        Building[] smithBuildings = {
            new Building("Ford Hall", "100 Green Street Northampton, MA 01063"),
            new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4),
            new Building("Seelye Hall", "2 Seelye Drive Northampton, MA 01063", 3),
            new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true),
            new Library("Hillyer Library", "20 Elm Street Northampton, MA 01063", 2, false),
            new Cafe("Compass Cafe", "7 Elm St Northampton, MA 01063"),
            new Cafe("CC Cafe", "100 Elm Street Northampton, MA 01063", 3),
            new House("Chapin House", "11 Elm Street Northampton, MA 01063"),
            new House("Washburn House", "4 Seelye Dr, Northampton, MA 01063", 4, false, false),
            new House("Lawrence House", "99 Green St, Northampton, MA 01060", 4, true, false)
        };

        for (Building b : smithBuildings) {
            myMap.addBuilding(b);
        }
        // demonstrate House overloaded constructor (name + address only)
        House scales = new House("Scales House", "Elm Street Northampton, MA 01063");
        myMap.addBuilding(scales);

        // demonstrate Library overloaded constructor (name only)
        Library smallLib = new Library("Small Library", "5 Green Street");
        myMap.addBuilding(smallLib);

        // demonstrate Cafe overloaded constructor (name + address + floors)
        Cafe campusCafe = new Cafe("Campus Cafe", "10 Green Street", 1);
        myMap.addBuilding(campusCafe);

        System.out.println(myMap);
    }
    }
