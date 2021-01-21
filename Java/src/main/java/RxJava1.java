import java.util.concurrent.TimeUnit;

public class RxJava1 {

    // 외부에 영향을 받는 비동기 처리 예제
    private enum State {
        ADD, MULTIPLY
    }

    private static State calcMethod; // 외부변수

    public static void main(String[] args) throws Exception {
        // 초기에 계산 방법을 더하기로 설정
        calcMethod = State.ADD;

        Flowable<Long> flowable =
                // 300밀리초마다 0부터 시작하는 값을 비동기로 통지하는 Flowable을 interval로 생성
                Flowable.interval(300L, TimeUnit.MILLISECONDS)
                        // 7건까지 통지
                        .take(7)
                        // scan을 사용해 집계하고 데이터를 받아 계산할때마다 통지
                        .scan((sum, data) -> { // sum은 이전까지의 계산결과, data는 Flowable부터 받은 통지 데이터
                            if(calcMethod == State.ADD) { // 외부변수에 따라 계산 방법을 다르게 함 => 절대 해서는 안됨`
                                return sum + data;
                            } else {
                                return sum * data;
                            }
                        });
        // 구독하고 받은 데이터를 출력
        flowable.subscribe(data -> System.out.println("data=" + data));

        // 잠시 기다렸다가 계산 방법을 곱셈으로 변경
        Thread.sleep(1000);
        System.out.println("계산 방법 변경");
        calcMethod = State.MULTIPLY; // 1000밀리초를 대기 후 외부 변수 값을 변경(곱셈으로)

        // 잠시 대기
        Thread.sleep(2000);
    }

//    출력결과
//    data=0
//    data=1
//    data=3
//    계산 방법 변경
//    data=9
//    data=36
//    data=180
//    data=1080
}
