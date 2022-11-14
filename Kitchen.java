public class Kitchen extends Room{

    //Fields
    private boolean stove;

    //Constructor
    Kitchen(){
        super("Kitchen");
        this.stove = false;
    }

    /**
     * Switching stove
     * @return stove state
     */
    public boolean switchStove(){
        return stove = !stove;
    }

    /**
     * @return current stove state
     */
    public boolean stoveState() {
        return stove;
    }

    /**
     * Override entering message and add 4th option to switch stove
     * @return
     */
    @Override
    public String enteringMsg() {
        return super.enteringMsg() + "4) Switch stove";
    }

    /**
     * Override user input to validate the 4th option
     * Using parent class method to check other input options
     * @param input String
     */
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
