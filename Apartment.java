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
     * Return room with given name
     * @param name
     * @return Room
     */
    public Room getRoomByName(String name) {
        for (Object room: Rooms) {
            if (((Room) room).getName().equals(name)) {
                return (Room) room;
            }
        }
        return null;
    }

    /**
     * Check if lights, stove or shower are still switched on by leaving.
     */
    private void checkApartment() {
        for (Object room:
             Rooms) {
            if (room.getClass() == Room.class) {
                if (((Room) room).lightState()) {
                    this.printWarning(((Room) room).getName(), "Light");
                }
            } else if (room.getClass() == Kitchen.class) {
                if(((Kitchen) room).lightState()) {
                    this.printWarning(((Kitchen) room).getName(), "Light");
                }
                if (((Kitchen) room).stoveState()) {
                    this.printWarning(((Kitchen) room).getName(), "Stove");
                }
            } else if (room.getClass() == Bathroom.class) {
                if(((Bathroom) room).lightState()) {
                    this.printWarning(((Bathroom) room).getName(), "Light");
                }
                if (((Bathroom) room).showerState()) {
                    this.printWarning(((Bathroom) room).getName(), "Shower");
                }
            }

        }
    }

    /**
     * Print warning message when light, stove or shower are still switched on in a room
     * @param room name of the room
     * @param error what ist on (light, stove, shower)
     */
    private void printWarning(String room, String error) {
        System.out.printf("Warning: %s in the %s is still switched on.%n", error, room);
    }
}
