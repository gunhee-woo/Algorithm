package BaekJoon.RhsCodingTest1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class sol1 {
    static int min = 987654321, max = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        dfs(N, 0);
    }

    static void dfs(String n, int c) {
        if(n.length() == 1) {

            return;
        }
        for(int i = 0; i < n.length(); i++) {
            if(((n.charAt(i) - '0') % 2) != 0) { // È¦¼ö
                c++;
            }
        }
        if(n.length() >= 3) {
            for(int i = 1; i < n.length() - 1; i++) {
                dfs(n.substring(0, i), c);
                for(int j = i + 1; j < n.length(); j++) {
                    dfs(n.substring(i, j), c);
                    dfs(n.substring(j, j + 1), c);
                }
            }
        }
        if(n.length() == 2) {

        }
    }
}
