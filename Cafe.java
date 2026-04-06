/* This is a stub for the Cafe class */
import java.util.Scanner;
public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    //overload. no inventory specified, sets default inventory to 24 ounces of coffee, 100 sugar packets, 100 creams, and 100 cups
    public Cafe(String name, String address, int nFloors) {
    this(name, address, nFloors, 25, 100, 100, 100);
}
    public Cafe(String name, String address) {
        this(name, address, 1, 25, 100, 100, 100);
    }


    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) { 
        // if you dont have enough materials to make the coffee, restock the materials and then make the coffee
        if (nCoffeeOunces > this.nCoffeeOunces) {
            this.nCoffeeOunces += nCoffeeOunces;
        }
        if (nSugarPackets > this.nSugarPackets) {
            this.nSugarPackets += nSugarPackets;
        }
        if (nCreams > this.nCreams) {
            this.nCreams += nCreams;
        }
        if (nCups > this.nCups) {
            this.nCups += nCups;
        }
    }


    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
//For sellCoffee, first check if you have enough of each ingredient. 
// If not, call restock. Then subtract everything from inventory (coffee by size, sugar by nSugarPackets, cream by nCreams, cups by 1). 
        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || 1 > this.nCups) {
            restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams)");
    }
    @Override
    public void goToFloor(int floorNum) {
        if (floorNum != 1) {
            throw new RuntimeException("Customers can only access the ground floor of " + this.name + ".");
        }
        super.goToFloor(floorNum);
}
    @Override
    public void handleAction(String action, Scanner scan) {
        if (action.equalsIgnoreCase("coffee")) {
            System.out.println("What size coffee?");
            int size = scan.nextInt();

            System.out.println("How many sugar packets do you want?");
            int sugar = scan.nextInt();

            System.out.println("How many creams do you want?");
            int creams = scan.nextInt();

            this.sellCoffee(size, sugar, creams);
        } else {
            super.handleAction(action, scan);
        }
    }

    public static void main(String[] args) {
        new Cafe("Starbucks", "456 Oak Avenue", 1, 1000, 500, 300, 200);
    }
}
