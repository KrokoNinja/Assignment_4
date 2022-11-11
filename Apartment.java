public class Apartment {

    private Room hallway = new Room("Hallway");

    Apartment(){
        this.addNewRoom(hallway);
        this.enter();
    }

    public void enter() {
        this.hallway.enter();
    }

    public void addNewRoom(Room newRoom){

    }
}
