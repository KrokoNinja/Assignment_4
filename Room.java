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
    }

    protected String enteringMsg() {
        return String.format("You are in the %s. \n" +
                "What do you want to do? \n" +
                "1) Switch light\n"+
                "2) Leave room\n"+
                "3) Enter neighbouring room\n", this.getName());
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
                System.out.println("Invalid input! Try again!");
                this.enter();
                break;
        }
    }

    public boolean switchLight(){
        if(!lighting) {
            System.out.println("You switched the light on.");
        }
        else {
            System.out.println("You switched the light off.");
        }
        return lighting = !lighting;
    }

    private void switchRoom() {
        this.printNeighbors();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt() - 1;
        if(0 <= input && input < neighbors.size()) {
            neighbors.get(input).enter();               //Entering neighbour room
        }
        else {
            System.out.println("Invalid input range");
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
