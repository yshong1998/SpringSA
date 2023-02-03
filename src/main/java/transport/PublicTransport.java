package transport;

import java.util.Objects;
import java.util.Scanner;

public abstract class PublicTransport {

    Scanner scanner = new Scanner(System.in);

    public int gasoline;
    public int speed;
    public int maxPassenger;
    protected static int totalTransportNumber = 0;
    protected int totalIncome = 0;
    private final int transportNumber;
    private String driverName;


    String state;


    public PublicTransport() {
        inputDriverName();
        gasoline = 100;
        speed = 0;
        totalTransportNumber++;
        transportNumber = hashCode();
    }

    private void inputDriverName(){
        System.out.println("운전자의 이름을 입력해 주세요.");
        driverName = scanner.next();
    }

    //- 운행 시작
    public abstract void run();

    //- 상태 변경
    public abstract void switchState();

    //- 승객 탑승
    public abstract void putPassengersOn();

    //- 속도 변경
    public void changeSpeed(int additionalSpeed) {
        speed += additionalSpeed;
    }

    public void printTotalIncome(){
        System.out.println(totalIncome);
    }

    public boolean checkGasoline() {
        return gasoline >= 10;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + totalTransportNumber;
        hash = 31 * hash + (driverName == null ?
                0 : driverName.hashCode()); //String의 hashcode메서드
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicTransport transport = (PublicTransport) o;
        return transportNumber == transport.transportNumber &&
                Objects.equals(driverName, transport.driverName);
    }
}

