import transport.Bus;
import transport.Taxi;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.run();
        bus.changeSpeed(30);
        System.out.println("현재 속도는 " + bus.speed + "입니다.");
        bus.changeSpeed(-30);
        System.out.println("현재 속도는 " + bus.speed + "입니다.");
        bus.putPassengersOn();
        bus.changeSpeed(30);
        System.out.println("현재 속도는 " + bus.speed + "입니다.");
        bus.printTotalIncome();

        Taxi taxi = new Taxi();
        taxi.run();
        taxi.changeSpeed(50);
        System.out.println("현재 속도는 " + taxi.speed + "입니다.");
        taxi.changeSpeed(-50);
        System.out.println("현재 속도는 " + taxi.speed + "입니다.");
        taxi.putPassengersOn();
        taxi.switchState();
        taxi.changeSpeed(50);
        System.out.println("현재 속도는 " + taxi.speed + "입니다.");
        taxi.calculateTotalFare();
        taxi.pay();
    }
}
