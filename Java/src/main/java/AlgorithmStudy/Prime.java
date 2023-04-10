package AlgorithmStudy;

// 에라토스테네스의 체
public class Prime {
    public static void main(String[] args) {
        print(isPrime3(4) + " ");
        print(isPrime3(3));
    }

    // 1. 2부터 판별하는 숫자까지 나누어 떨어지는 수가 나온다면 소수이다 => 시간복잡도 O(N)
    public static boolean isPrime1(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    // 2. 해당 숫자의 절반까지 확인하는 방법 자기자신을 제외하고 절반을 초과하는 숫자에서 나누었을때 나머지가 0이 나올수 없음 => 시간복잡도 O(N)
    public static boolean isPrime2(int num) {
        if(num == 1) return false;
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    // 3. 해당 숫자의 루트까지 확인하는 방법 => 시간복잡도 O(루트N)
    public static boolean isPrime3(int num) {
        if(num == 1) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
