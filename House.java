/* This is a stub for the House class */
import java.util.ArrayList;

/**
 * The House class respresents a type of the Building class and manages the residents in the house.
 */

public class House extends Building {
  
    private ArrayList<Student> residents;
    private boolean hasDiningRoom;

    /**
     * Construct with provided name, address, floors number and dining hall status.
     *
     * @param name Name of the house
     * @param address Address of the house
     * @para nFloors FLoors number in the house
     * @para hasDiningRoom Whether the house has dining room, if it has, it is true, if it has not,  it is false.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
    }
  
    /**
     * Check if the house has dining hall.
     * 
     * @return whether the house has dining Hall.
     */
    public boolean hasDiningRoom(){
        return hasDiningRoom;
    }
  
    /**
     * Returns the number of residents in the house.
     * 
     * @return the number of people living in the house.
     */
    public int nResidents(){
        return residents.size();
    }

    /**
     * Adds a new resident to the house.
     * 
     * @param s the student to be added as a resident.
     */
    public void moveIn(Student s){
      if (residents.contains(s)){
          System.out.println("Resident already in the house.");
      } else {
          residents.add(s);  
      }
    }

    /**
    * Removes a resident from the house.
    * 
    * @param s the student to be removed from the house.
    * @return the name of the removed resident.
    * @throws IllegalArgumentException if the resident is not found in the list.
    */
    public Student moveOut(Student s){
      if(residents.contains(s)){
          residents.remove(s);
          return s;
      } else {
          throw new IllegalArgumentException("Resident not found in the house: " + s);
      }
    }
    
    /**
     * Check if the name is a resident of the house.
     * 
     * @param name name of the people that we want to check.
     * @return true if the person's name is in residetn list, else return false.
     */
    public boolean isResidents(Student s){
      if(residents.contains(s)){
        return true;
      } else{
        return false;
      }
    }

    /**
     * Main method to show the functionality of the House class.
     */
    public static void main(String[] args){
        House myHouse = new House("My House", "1 Henshaw Ave", 3, true);
        System.out.println("You have built a house: 🏠");
        System.out.println("House Name: " + myHouse.getName());
        System.out.println("House Address: " + myHouse.getAddress());
        System.out.println("Number of Floors: " + myHouse.getFloors());
        System.out.println("Has Dining Room: " + myHouse.hasDiningRoom);
    }

}