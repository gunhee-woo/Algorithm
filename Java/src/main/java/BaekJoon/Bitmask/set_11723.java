package BaekJoon.Bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class set_11723 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int bitSet = 0;
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if(command.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                bitSet |= (1 << (num - 1));
            } else if(command.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                bitSet &= ~(1 << (num - 1));
            } else if(command.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                sb.append((bitSet & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
            } else if(command.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                bitSet ^= (1 << (num - 1));
            } else if(command.equals("all")) {
                bitSet |= (~0);
            } else if(command.equals("empty")) {
                bitSet &= 0;
            }
        }
        System.out.print(sb.toString());
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String command = st.nextToken();
//            if(command.equals("add")) {
//                set.add(Integer.parseInt(st.nextToken()));
//            } else if(command.equals("remove")) {
//                set.remove(Integer.parseInt(st.nextToken()));
//            } else if(command.equals("check")) {
//                if(set.contains(Integer.parseInt(st.nextToken()))) System.out.println(1);
//                else System.out.println(0);
//            } else if(command.equals("toggle")) {
//                int val = Integer.parseInt(st.nextToken());
//                if(set.contains(val)) set.remove(val);
//                else set.add(val);
//            } else if(command.equals("all")) {
//                for(int j = 1; j <= 20; j++)
//                    set.add(j);
//            } else if(command.equals("empty")) {
//                set.clear();
//            }
//        }
    }
}
