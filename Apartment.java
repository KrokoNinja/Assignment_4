import java.util.ArrayList;

public class Apartment {

    //Fields
    private ArrayList<Object> Rooms = new ArrayList<>();
    private final Room hallway;

    //Constructor
    Apartment(){
        hallway = new Room("Hallway");
        this.addNewRoom(hallway);
    }

    //Methods

    /**
     * Enter the entrance (Hallway) of the Apartment
     * Checking for warnings when the user wants to leave
     * Printing Leave message
     */
    public void enter() {
        this.hallway.enter();
        this.checkApartment();
        System.out.println("Leaving apartment.");
    }

    /**
     * Add new Room to the Roomlist of the apartment.
     * @param newRoom
     */
    public void addNewRoom(Room newRoom){
        Rooms.add(newRoom);
    }

    /**
     * Check if lights, stove or shower are still switched on by leaving.
     */
    private void checkApartment() {
        for (Object room:
             Rooms) {
            room = (Room) room;

        }
    }
}
