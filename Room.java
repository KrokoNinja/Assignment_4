import java.util.Scanner;

public class Room {

    private String name;
    private boolean lighting;

    Room(String name){
        this.name = name;
        this.lighting = false;
    }

    public void enter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in " + name);
        System.out.println("What do you want to do?");
        System.out.println("1\\) Switch light");
        System.out.println("2\\) Leave room");
        System.out.println("3\\) Enter neighbouring room");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                switchLight();
                break;
            case 2:
                //TODO: implement switch to previous room
                break;
            case 3:

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
}
