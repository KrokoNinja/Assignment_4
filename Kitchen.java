public class Kitchen extends Room{

    private boolean stove;

    Kitchen(){
        super("Kitchen");
        this.stove = false;
    }

    public boolean switchStove(){
        return stove = !stove;
    }

    public boolean stoveState() {
        return stove;
    }

    @Override
    public String enteringMsg() {
        return super.enteringMsg() + "4) Switch stove";
    }

    @Override
    public void userInput(String input) {
        if ("4".equals(input)) {
            if(!this.switchStove()) {
                System.out.println("You switched off the stove.\n");
            }
            else {
                System.out.println("You switched on the stove.\n");
            }
            this.enter();
        }
        else {
            super.userInput(input);
        }
    }
}
