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
            double seconds = res / 10;
            long consumed = res * 200;
            System.out.println("The shower was on for " + seconds + " seconds. You consumed " + consumed + " water.");
        }
        return shower = !shower;
    }

    public boolean showerState() {
        return shower;
    }
}
