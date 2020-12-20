import java.io.*;

import static Util.Constants.INPUT;

public class CodingTip {

    public static void main(String[] args) throws Exception{
        base();
        stringOneWordChange();
    }

    // 자바 코딩테스트 기본 필수적인 코드
    static void base() throws Exception{
        System.setIn(new FileInputStream(INPUT)); // freopen 역할하는 함수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int n = Integer.parseInt(br.readLine());

        // .......... //

        bw.write(sb.toString().trim()); // trim 을 사용하여 마지막 빈 줄을 없애줌
        bw.flush();
        bw.close();
        br.close(); // !!!!! 중요 버퍼리더, 라이터 close 함수로 마지막에 꼭 닫아줄 것 !!!!!
    }

    // 자바 스트링에서 한 문자만 변경하고 싶을때
    static void stringOneWordChange() {
        String str = "String";
        System.out.println(str);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, 'G');
        System.out.println(sb.toString());
    }
}
