import java.util.Date;

public class Bathroom extends Room {

    //Fields
    private long water = 0;
    private boolean shower;

    //Constructor
    Bathroom(){
        super("Bathroom");
        this.shower = false;
    }

    /**
     * Switching state of the shower
     * starting timer to know the time how long the shower is switche don to calculate consumed water
     * Print current shower state and if shower is being switched off how much water was consumed
     * @return shower state
     */
    public boolean switchShower(){
        int res;
        if(!shower){
            Date timer = new Date();
            water = timer.getTime();
        }
        else {
            Date timer = new Date();
            res = (int) (timer.getTime() - water);
            double seconds = res / 1000;
            long consumed = (long) seconds * 200;
            System.out.println("The shower was on for " + seconds + " seconds. You consumed " + consumed + " milliliters water. \n");
        }
        return shower = !shower;
    }

    /**
     * @return shower state
     */
    public boolean showerState() {
        return shower;
    }

    /**
     * Override entering Message to add 4th option of switching the shower
     * @return message String
     */
    @Override
    public String enteringMsg() {
        return super.enteringMsg() + "4) Switch shower\n";
    }

    /**
     * Override checking the user input to validate the 4th option of switching the shower
     * Using the method of the parent class to check other inputs
     * @param input String user input
     */
    @Override
    public void userInput(String input) {
        if ("4".equals(input)) {
            if(!this.switchShower()) {
                System.out.println("You switched off the shower.\n");
            }
            else {
                System.out.println("You switched on the shower.\n");
            }
            this.enter();
        }
        else {
            super.userInput(input);
        }
    }
}
