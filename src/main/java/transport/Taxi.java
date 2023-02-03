package transport;

import java.util.Scanner;

public class Taxi extends PublicTransport {

    Scanner scanner = new Scanner(System.in);

    int basicFare;
    int farePerDistance;
    int basicDistance;
    int distanceToDestination;
    int totalFare;
    String destination;

    public Taxi() {
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
            System.out.println("주유가 필요하다.");
        } else {
            System.out.println("운행을 시작합니다.");
        }
    }

    //- 상태 변경
    @Override
    public void switchState() {
        state = state.equals("일반") ? "운행 중" : "일반";
        if (!checkGasoline()) {
            state = "탑승 불가";
            System.out.println("주유가 필요하다");
        } else {
            System.out.println("상태를 " + state + " 로 변경했습니다.");
        }
    }

    //-승객 탑승
    @Override
    public void putPassengersOn() {
        int n;
        do {
            if(!state.equals("일반")){
                System.out.println("택시가 현재 가용하지 않습니다.");
                break;
            }
            System.out.print("탑승 인원을 입력해 주세요. : ");
            n = scanner.nextInt();
            if (n <= maxPassenger) {
                state = "운행 중";
            } else {
                System.out.println("4명을 초과하여 탑승할 수 없습니다.");
            }
        } while (n > maxPassenger);
        inputDestination();
    }

    public void inputDestination() {
        System.out.printf("목적지를 입력해 주세요. : ");
        scanner.next();
        destination = scanner.nextLine();
        System.out.print("목적지까지의 거리를 입력해 주세요 : ");
        distanceToDestination = scanner.nextInt();
        System.out.println("운행을 시작합니다.");
    }

    //- 거리당 요금 추가
    public void calculateTotalFare() {
        totalFare = Math.max((distanceToDestination - basicDistance) * farePerDistance, basicFare);
    }

    //- 요금 지불
    public void pay() {
        System.out.println(totalFare);
    }
}
