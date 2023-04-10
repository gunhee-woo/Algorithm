package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Util.Constants.INPUT;

public class StringGame2_20437 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 0; i < 26; i++) // ���ĺ� �ҹ��ڸ� ��� Map�� ��Ƽ� �ʱ�ȭ
                map.put((char)('a' + i), new ArrayList<>());
            for(int i = 0; i < str.length(); i++)
                map.get(str.charAt(i)).add(i);
            int min = 987654321, max = 0;
            boolean b = false; // ������ �� ���̶� �����ߴ��� ���ߴ��� üũ�ϴ� �÷���
            for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
                ArrayList<Integer> list = entry.getValue();
                if(list.size() >= k) { // k�� �̻� ����ִ� ������ ����Ʈ�� ���� ����
                    b = true;
                    int s = 0, e = k - 1; // �� ������ �˰���
                    while (e != list.size()) {
                        min = Math.min(min, list.get(e) - list.get(s) + 1); // 3�� => ������ �ش� ���ڰ� �� ���� �������� ���� ª�� �� �ۿ� ����
                        max = Math.max(max, list.get(e) - list.get(s) + 1); // 4��
                        s++;
                        e++;
                    }
                }
            }
            if(b) {
                System.out.print(min + " ");
                System.out.println(max);
            } else
                System.out.println(-1);
        }
    }
}
