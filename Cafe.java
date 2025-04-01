/* This is a stub for the Cafe class */
public class Cafe extends Building {
    
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    
    /**
     * Constructs a Cafe object with the provided name, address, number of floors, and initial inventory.
     *
     * @param name Name of the cafe
     * @param address Address of the cafe
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Number of coffee ounces in inventory
     * @param nSugarPackets Number of sugar packets in inventory
     * @param nCreams Number of cream packets in inventory
     * @param nCups Number of cups in inventory
     */
    public Cafe(String name, String address, int nFloors,int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }


    /**
     * Sells a coffee with their size of coffee, sugarpackets and creams that it needs.
     * If the stuff needed is available, it will make a coffee. If they are not available, it will restock all the ingredients.
     * @param size size of the coffee in ounces.
     * @param nSugarPackets number of sugarpackets the drink requires.
     * @param nCreams Number of creams the drink requires.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size <= nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
            System.out.println("Your coffee is ready to pick up.");
        } else {
            System.out.println("Sorry, we are out of stock for the ordered coffee.");
            restock(50, 30, 30, 30); // Restock with default values
        }
    }

    /**
     * Restocked the ingredients when called.
     * 
     * @param nCoffeeOunces Number of coffee ounces to restock.
     * @param nSugarPackets Number of sugar packets to restock.
     * @param nCreams Number of creams to restock.
     * @param nCups Number of cups to restock.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("Inventory has been restocked.");
    }

    /**
     * Main method to show the functionality of the Cafe class.
     */
    public static void main(String[] args) {
        System.out.println("You have built a cafe: ☕");
        Cafe cafe = new Cafe("Cafe", "A Ave", 3, 30, 40, 45, 50);
        cafe.sellCoffee(12, 3, 2); 
        cafe.sellCoffee(16, 5, 4);
    }
    
}
