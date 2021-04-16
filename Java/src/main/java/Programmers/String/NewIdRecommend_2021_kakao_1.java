package Programmers.String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class NewIdRecommend_2021_kakao_1 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(br.readLine()));
    }

    public static String solution(String id) {
        id = id.toLowerCase();
        id = sol2(id);
        id = sol3(id);
        id = sol4(id);
        if(id.isEmpty()) id = "a";
        if(id.length() >= 16) {
            id = id.substring(0, 15);
            if(id.charAt(id.length() - 1) == '.') id = id.substring(0, 14);
        }
        if(id.length() <= 2) {
            char c = id.charAt(id.length() - 1);
            StringBuilder sb = new StringBuilder(id);
            while(!(sb.length() == 3)) {
                sb.append(c);
            }
            id = sb.toString();
        }
        return id;
    }

    public static String sol2(String id) {
        char[] ids = id.toCharArray();
        for(int i = 0; i < ids.length; i++) {
            if(!(ids[i] == '-') && !(ids[i] == '_') && !(ids[i] == '.') && !Character.isLowerCase(ids[i]) && !Character.isDigit(ids[i])) ids[i] = ' ';
        }
        return new String(ids).replaceAll(" ", "");
    }

    public static String sol3(String id) {
        char[] ids = id.toCharArray();
        int cnt = 0;
        boolean isStart = false;
        int sidx = 0;
        for(int i = 0; i < ids.length; i++) {
            if(isStart) {
                if(!(ids[i] == '.'))  {
                    if(cnt > 1) {
                        for(int j = sidx; j < sidx + cnt - 1; j++) {
                            ids[j] = ' ';
                        }
                    }
                    isStart = false;
                    cnt = 0;
                    sidx = 0;
                }
                else {
                    cnt++;
                    if(i == ids.length - 1) {
                        if(cnt > 1) {
                            for(int j = sidx; j < sidx + cnt - 1; j++) {
                                ids[j] = ' ';
                            }
                        }
                    }
                }
            } else {
                if(ids[i] == '.') {
                    isStart = true;
                    cnt++;
                    sidx = i;
                }
            }
        }
        return new String(ids).replaceAll(" ", "");
    }

    public static String sol4(String id) {
        char[] ids = id.toCharArray();
        for(int i = 0; i < ids.length; i++) {
            if((i == 0 || i == ids.length - 1) && ids[i] == '.') {
                ids[i] = ' ';
            }
        }
        return new String(ids).replaceAll(" ", "");
    }
}
