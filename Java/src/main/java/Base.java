import java.io.*;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Base {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // ��°���� �������϶�
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // ... //

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
