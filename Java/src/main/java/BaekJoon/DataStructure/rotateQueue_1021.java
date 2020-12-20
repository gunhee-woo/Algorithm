package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import static Util.Constants.INPUT;

/**
 * ArrayList의 경우 데이터 추가 삭제 시 임시배열을 이용하여 복사하는 작업을 수행함
 * 즉, 밀어내기 식으로 연산을 수행하기 때문에 성능에 문제가 있을 수 있음
 * 하지만 각 데이터에 대한 인덱스를 가지고 있어 검색이 매우 빠름
 *
 * 반면 LinkedList의 경우는 자료의 위치정보를 가지며 내부적인 인덱스는 가지고 있지 않음
 * 데이터의 추가 삭제는 위치정보의 수정으로 가능하기 때문 많은 데이터 추가 삭제시 용이함
 * 하지만 데이터 검색 시 처음 자료부터 순차적으로 진행하기 때문에 성능에 문제가 있음
 * http://seeit.kr/36
 */

// 이 문제에서는 데이터 추가 삭제 연산만 수행하기 때문에 LinkedList 사용이 적합함
public class rotateQueue_1021 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        final int N = Integer.parseInt(line1[0]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) list.add(i);
        int result = 0;
        for (String s : line2) {
            int k = Integer.parseInt(s);
            while (true) {
                int pos = list.indexOf(k);
                int left = pos; // head 와의 거리를 뽑을 요소의 인덱스로 정함
                int right = list.size() - pos - 1; // tail 과의 거리
                if (left == 0) {
                    list.remove(pos);
                    break;
                }
                if (left <= right) { // 왼쪽으로 탐색
                    list.addLast(list.removeFirst());
                    ++result;
                } else { // 오른쪽으로 탐색
                    list.addFirst(list.removeLast());
                    ++result;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
