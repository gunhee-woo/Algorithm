package baekJoon.Tree;

import java.io.FileInputStream;
import java.util.*;

import static Util.Constants.INPUT;

// Ʈ��
// ������ �־������� Ʈ������ �Ǻ��ϴ� ����
// 1. ���� ������ �ϳ��� ���� ��尡 �ϳ��� �����ϴ���(= ��Ʈ�� �ϳ��� �����ϴ���)
// 2. ��Ʈ�� ������ ��� ������ ���� ������ �Ѱ� ����
// 3. ��Ʈ���� �ٸ� ���� ���� ��δ� �ݵ�� �����ϸ� ��������(��Ʈ�� ������ ��� ��忡 ����) => ������ ���� - 1 == ������ ����

public class isTree_6416 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while(true) {
            Map<Integer, Integer> map = new HashMap<>(); // �ڽĳ��, �θ��� => ����
            Set<Integer> set = new HashSet<>(); // ����
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