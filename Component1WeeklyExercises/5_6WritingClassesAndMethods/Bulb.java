public class Bulb {

    private boolean state;

    public Bulb() {
        state = false;
    }

    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public boolean getState() {
        return state;
    }
}