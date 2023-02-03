public abstract class publicTransport {
    int transportNumber;
    int gasoline;
    int speed;
    int maxPassenger;
    String state;

    publicTransport() {
        gasoline = 100;
        speed = 0;
    }

    //- 운행 시작
    public abstract void run();

    //- 상태 변경
    public abstract void switchState();

    //- 승객 탑승
    public abstract void putPassengersOn(int n);

    //- 속도 변경
    public void changeSpeed(int additionalSpeed) {
        speed += additionalSpeed;
    }

    public boolean checkGasoline() {
        return gasoline >= 10;
    }
}

class Bus extends publicTransport {
    int passengerCount;
    int busFare;

    Bus() {
        super();
        maxPassenger = 30;
        state = "운행";
        busFare = 1000;
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
        }
    }

    @Override
    public void putPassengersOn(int n) {
        if (passengerCount + n <= maxPassenger && state.equals("운행")) {
            passengerCount += n;
        }
    }
}

class Taxi extends publicTransport {
    String destination;
    int basicFare;
    int farePerDistance;
    int basicDistance;
    int distanceToDestination;
    int totalFare;

    Taxi() {
        super();
        maxPassenger = 4;
        basicFare = 3000;
        farePerDistance = 1000;
        basicDistance = 1;
        state = "일반";
    }

    //- 운행 시작
    @Override
    public void run() {
        if (!checkGasoline()) {
            state = "탑승 불가";
        }
    }

    //- 상태 변경
    @Override
    public void switchState() {
        state = state.equals("일반") ? "운행 중" : "일반";
        if (!checkGasoline()) {
            state = "탑승 불가";
            System.out.println("주유가 필요하다");
        }
    }

    //-승객 탑승
    @Override
    public void putPassengersOn(int n) {
        if (n <= maxPassenger && state.equals("일반")) {
            state = "운행 중";
        }
    }

    //- 거리당 요금 추가
    public void calculateTotalFare() {
        totalFare = Math.max(distanceToDestination * farePerDistance, basicFare);
    }

    //- 요금 지불
    public void pay() {
        System.out.println(totalFare);
    }
}
