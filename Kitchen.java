public class Kitchen extends Room{

    private boolean stove;

    Kitchen(){
        super("Kitchen");
        this.stove = false;
    }

    public boolean switchStove(){
        return stove = !stove;
    }
}
