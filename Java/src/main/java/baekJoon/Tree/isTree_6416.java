package baekJoon.Tree;

import java.io.FileInputStream;
import java.util.*;

import static Util.Constants.INPUT;

// 트리
// 간선이 주어졌을때 트리인지 판별하는 문제
// 1. 진입 간선이 하나도 없는 노드가 하나만 존재하는지(= 루트가 하나만 존재하는지)
// 2. 루트를 제외한 모든 노드들의 진입 간선이 한개 인지
// 3. 루트에서 다른 노드로 가는 경로는 반드시 가능하며 유일한지(루트를 제외한 모든 노드에 성립) => 정점의 개수 - 1 == 간선의 개수

public class isTree_6416 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while(true) {
            Map<Integer, Integer> map = new HashMap<>(); // 자식노드, 부모노드 => 간선
            Set<Integer> set = new HashSet<>(); // 정점
            boolean flag = false;
            while(true) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a == -1 && b == -1) return;
                if(a == 0 && b == 0) break;
                set.add(a); set.add(b);
                if(!map.containsKey(b)) map.put(b, a);
                else flag = true;
            }
            if(set.size() == 0) {
                System.out.println("Case " + T + " is a tree.");
            } else {
                if(!flag) {
                    int count = 0;
                    for(int val : set) {
                        if(!map.containsKey(val)) {
                            count++;
                        }
                    }
                    if(count != 1) flag = true;
                    if(!flag) {
                        if(set.size() - 1 != map.size()) flag = true;
                    }
                }
                if(flag) System.out.println("Case " + T + " is not a tree.");
                else System.out.println("Case " + T + " is a tree.");
            }
            T++;
        }
    }
}