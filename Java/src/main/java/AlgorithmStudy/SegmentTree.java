package AlgorithmStudy;

/**
 * 세그먼트 트리
 * 특정한 범위의 데이터 합을 가장 빠르고 간단하게 구할 수 있는 자료구조
 * 시간복잡도 O(logN)
 *
 * 1. 구간 합 트리 생성
 * 최상단 노드에는 전체 원소를 더한 값이 들어감
 * 두번째, 세번째 노드부터 원래 데이터 범위를 반씩 분할하며 그 구간의 합들을 저장하도록 설정
 * *** 구간 합 트리에 한해서 인덱스 번호가 1부터 시작
 *      => 1부터 시작함으로써 2를 곱했을 때 왼쪽 자식 노드를 가리키므로 효과적임 => 따라서 짝수면 왼쪽 홀수면 오른쪽을 가리키게 함
 * 구간 합 트리는 재귀적으로 구현하는 것이 효과적
 * 데이터의 개수가 N개일 때 N보다 큰 가장 가까운 N의 제곱수를 구한뒤에 그것의 2배까지 미리 배열의 크기를 지정해야 함
 * 데이터의 개수가 12개이면 16 * 2 = 32개의 크기가 필요
 * 따라서 실제로 데이터의 개수 N에 4를 곱한 크기만큼 미리 구간 합 트리의 공간을 할당
 *
 * 2. 구간 합을 구하는 함수
 * 구간 합은 항상 O(logN)의 시간에 구할 수 있음
 * 구간 합을 구하는 함수 또한 재귀적으로 구현하는 것이 효과적임
 * 구간 합은 범위 안에 있는 경우에 한해서 더해주면 됨
 *
 * 3. 특정 원소의 값을 수정하는 함수
 * 해당 원소를 포함하고 있는 모든 구간 합 노드들을 갱신하면 됨
 * 이 또한 범위 안에 있는 경우에 한해서 더해주며
 * 재귀적으로 구현하는 것이 효과적임
 *
 * 따라서 세그먼트 트리 알고리즘을 사용하면 구간 합 계산 시 기존 방법보다 획기적으로 속도가 빨라지게 됨
 *
 * 출처 : https://blog.naver.com/ndb796/221282210534
 *
 */

public class SegmentTree {
    static int NUMBER = 12;
    static int a[] = {1,9,3,8,4,5,5,9,10,3,4,5};
    static int tree[] = new int[4 * NUMBER];
    public static void main(String[] args) {
        init(0, NUMBER - 1, 1);
        System.out.println("0 부터 12까지의 합");
        System.out.println(sum(0, NUMBER - 1, 1, 0, 12));
        System.out.println("3 부터 8까지의 합");
        System.out.println(sum(0, NUMBER - 1, 1, 3, 8));
        System.out.println("인덱스 5의 원소를 -5로 수정");
        update(0, NUMBER - 1, 1, 5, -5);
        System.out.println("3 부터 8까지의 합");
        System.out.println(sum(0, NUMBER - 1, 1, 3, 8));
    }

    // 구간 합 트리 생성
    // start 시작 인덱스, end 끝 인덱스
    private static int init(int start, int end, int node) {
        if(start == end) return tree[node] = a[start];
        int mid = (start + end) / 2;
        // 재귀적으로 두 부분을 나눈 후 합을 구함
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // left, right => 구간 합을 구하고자 하는 범위
    private static int sum(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if(left > end || right < start) return 0;
        // 범위 안에 있는 경우
        if(left <= start && end <= right) return tree[node];
        // 그렇지 않다면 두 부분으로 나누어 합을 구하기
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    // index : 구간 합을 수정하고자 하는 노드
    // dif : 수정할 값 => 기존값과 바꾸려는 값의 차이 => 얼마큼 수정할 지
    private static void update(int start, int end, int node, int index, int dif) {
        // 범위 밖에 있는 경우
        if(index < start || index > end) return;
        // 범위 안에 있으면 내려가며 다른 원소도 갱신
        tree[node] += dif;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
