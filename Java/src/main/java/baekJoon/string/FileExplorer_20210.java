package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import static Util.Constants.INPUT;

public class FileExplorer_20210 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        while(N-- > 0) list.add(br.readLine());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                if(Character.isDigit(o1.charAt(0))) {
//                    return o2.charAt(0) - o1.charAt(0);
//                } else {
//                    return o1.charAt(0) - o2.charAt(0);
//                }
                return o2.charAt(0) - o1.charAt(0);

            }
        });
        for(String s : list)
            System.out.println(s);
    }

    static void sort1(String o1, String o2, int ix) {
        if(Character.isDigit(o1.charAt(ix))) {

        }
    }
}
