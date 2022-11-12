import java.util.*;

public class Room {


    private String name;
    private boolean lighting;

    private ArrayList<Room> neighbors = new ArrayList<>();

    Room(String name){
        this.name = name;
        this.lighting = false;
    }

    public void enter(){
        System.out.println(enteringMsg());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        userInput(input);
    }

    protected String enteringMsg() {
        return String.format("""
                You are in the %s.\s
                What do you want to do?\s
                1) Switch light
                2) Leave room
                3) Enter neighbouring room
                """, this.getName());
    }

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

    public boolean switchLight(){
        if(!lighting) {
            System.out.println("You switched the light on. \n");
        }
        else {
            System.out.println("You switched the light off. \n");
        }
        return lighting = !lighting;
    }

    public void addNeighbor(Room neighbor) {
        for (Room room : neighbors){
            if (room.getName().equals(neighbor.getName())){
                return;
            }
        }
        neighbors.add(neighbor);
        neighbor.neighbors.add(this);
    }

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

    private void printNeighbors() {
        String output = "Which room? \n\n";
        for (int i = 0; i < neighbors.size(); i++) {
            output += String.format("%d) %s\n", i + 1, neighbors.get(i).getName());
        }
        System.out.println(output);
    }

    public boolean lightState() {
        return lighting;
    }

    public String getName() {
        return name;
    }
}
