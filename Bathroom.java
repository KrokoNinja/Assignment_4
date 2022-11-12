import java.util.Date;

public class Bathroom extends Room {

    private long water = 0;
    private boolean shower;

    Bathroom(){
        super("Bathrooom");
        this.shower = false;
    }

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
            System.out.println("You switched off the shower.");
            System.out.println("The shower was on for " + seconds + " seconds. You consumed " + consumed + " milliliters water. \n");
        }
        return shower = !shower;
    }

    public boolean showerState() {
        return shower;
    }

    @Override
    public String enteringMsg() {
        return super.enteringMsg() + "4) Switch shower\n";
    }

    @Override
    public void userInput(String input) {
        if ("4".equals(input)) {
            if (switchShower()) {
                System.out.println("You switched on the shower.\n");
            }
            this.enter();
        }
        else {
            super.userInput(input);
        }
    }
}
