import java.util.*;

public class Room {

    //Fields
    private String name;
    private boolean lighting;

    private ArrayList<Room> neighbors = new ArrayList<>();

    //Constructor
    Room(String name){
        this.name = name;
        this.lighting = false;
    }

    /**
     * Enter room, print Message and let the user input his/her choice what to do
     */
    public void enter(){
        System.out.println(enteringMsg());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        userInput(input);
    }

    /**
     * Print entering message with options what to do
     * @return message String
     */
    protected String enteringMsg() {
        return String.format("""
                You are in the %s.\s
                What do you want to do?\s
                1) Switch light
                2) Leave room
                3) Enter neighbouring room
                """, this.getName());
    }

    /**
     * Check user input and do what the user wants or print error message
     * @param input
     */
    protected void userInput(String input) {
        switch (input) {
            case "1":
                this.switchLight();
                this.enter();
                break;
            case "2":
                //leaving room equals doing nothing. See switchRoom()
                break;
            case "3":
                this.switchRoom();
                break;
            default:
                System.out.println("Invalid input! Try again!\n");
                this.enter();
                break;
        }
    }

    /**
     * turn light on and return current light state + message
     * @return light state as boolean
     */
    public boolean switchLight(){
        if(!lighting) {
            System.out.println("You switched the light on. \n");
        }
        else {
            System.out.println("You switched the light off. \n");
        }
        return lighting = !lighting;
    }

    /**
     * If neighbor isnt already in the list of neighbors add neighbor to the list and to the list of neighbors from neighboring room
     * @param neighbor Room which should be added as neighbor
     */
    public void addNeighbor(Room neighbor) {
        for (Room room : neighbors){
            if (room.getName().equals(neighbor.getName())){
                return;
            }
        }
        neighbors.add(neighbor);
        neighbor.neighbors.add(this);
    }

    /**
     * print neighbors and get user input which neighbor he/she wants to switch to
     * Enter the room or print error message
     */
    private void switchRoom() {
        this.printNeighbors();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt() - 1;
        if(0 <= input && input < neighbors.size()) {
            neighbors.get(input).enter();               //Entering neighbour room
        }
        else {
            System.out.println("Invalid input range \n");
        }
        this.enter();                                   //After leaving neighbour room coming back to previous room
    }

    /**
     * Print list of neighbors so the user can decide where to go
     */
    private void printNeighbors() {
        String output = "Which room? \n\n";
        for (int i = 0; i < neighbors.size(); i++) {
            output += String.format("%d) %s\n", i + 1, neighbors.get(i).getName());
        }
        System.out.println(output);
    }

    /**
     * Return current light state
     * @return boolean
     */
    public boolean lightState() {
        return lighting;
    }

    /**
     * Return name of the room
     * @return String
     */
    public String getName() {
        return name;
    }
}
