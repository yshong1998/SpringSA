package transport;

public class Bus extends PublicTransport {

    private static final int busFare = 1000;
    int passengerCount;


    public Bus() {
        super();
        maxPassenger = 30;
        state = "운행";
    }

    @Override
    public void run() {
        if (checkGasoline()) {
            state = "운행";
        }
    }

    @Override
    public void switchState() {
        state = state.equals("운행") ? "차고지행" : "운행";
        if (!checkGasoline()) {
            state = "차고지행";
            System.out.println("주유가 필요하다");
        } else {
            System.out.println("상태를 " + state + " 로 변경하였습니다.");
        }
    }

    @Override
    public void putPassengersOn() {
        System.out.print("탑승 인원을 입력해 주세요. : ");
        int n = scanner.nextInt();
        if (passengerCount + n <= maxPassenger && state.equals("운행")) {
            passengerCount += n;
            sumTotalIncome(n * busFare);
        } else if (passengerCount + n > maxPassenger) {
            System.out.println("정원이 초과되었습니다.");
        } else if (!state.equals("운행")) {
            System.out.println("운행중인 버스가 아닙니다.");
        }
    }

    public void sumTotalIncome(int income) {
        totalIncome += income;
    }
}
