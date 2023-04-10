package AlgorithmStudy;

// �����佺�׳׽��� ü
public class Prime {
    public static void main(String[] args) {
        print(isPrime3(4) + " ");
        print(isPrime3(3));
    }

    // 1. 2���� �Ǻ��ϴ� ���ڱ��� ������ �������� ���� ���´ٸ� �Ҽ��̴� => �ð����⵵ O(N)
    public static boolean isPrime1(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    // 2. �ش� ������ ���ݱ��� Ȯ���ϴ� ��� �ڱ��ڽ��� �����ϰ� ������ �ʰ��ϴ� ���ڿ��� ���������� �������� 0�� ���ü� ���� => �ð����⵵ O(N)
    public static boolean isPrime2(int num) {
        if(num == 1) return false;
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    // 3. �ش� ������ ��Ʈ���� Ȯ���ϴ� ��� => �ð����⵵ O(��ƮN)
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
