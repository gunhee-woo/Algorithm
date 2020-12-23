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
 * 데이터의 개수가
 *
 * https://blog.naver.com/ndb796/221282210534
 *
 */

public class SegmentTree {
    static int NUMBER = 12;
    static int a[] = {1,9,3,8,4,5,5,9,10,3,4,5};
    static int tree[] = new int[4 * NUMBER];
    public static void main(String[] args) {
        init(0, NUMBER - 1, 1);
    }

    private static int init(int start, int end, int node) {
        if(start == end) return tree[node] = a[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
}
