// Yannik Seidel 1080202332811 Ludovico Ferrara 108020222205 Lennert Pfundtner 108020228802
//Gruppe C3
public class Main {
    public static void main(String[] args) {
        Apartment aps = new Apartment();
        Kitchen kitchen = new Kitchen();
        Bathroom bathroom = new Bathroom();
        Room bedroom = new Room("Bedroom");
        Room workroom = new Room("Workroom");
        aps.addNewRoom(kitchen);
        aps.addNewRoom(bathroom);
        aps.addNewRoom(bedroom);
        aps.addNewRoom(workroom);
        aps.getRoomByName("Hallway").addNeighbor(kitchen);
        aps.getRoomByName("Hallway").addNeighbor(bathroom);
        aps.getRoomByName("Hallway").addNeighbor(bedroom);
        aps.getRoomByName("Hallway").addNeighbor(workroom);
        aps.getRoomByName("Workroom").addNeighbor(bedroom);
        aps.enter();
    }
}