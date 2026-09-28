public class Lights {

    public static void main(String[] args) {

        Bulb bulb1 = new Bulb();
        Bulb bulb2 = new Bulb();
        Bulb bulb3 = new Bulb();

        bulb1.turnOn();
        bulb3.turnOn();

        System.out.println("Bulb 1: " + bulb1.getState());
        System.out.println("Bulb 2: " + bulb2.getState());
        System.out.println("Bulb 3: " + bulb3.getState());
    }
}