package programmers.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LyricsSearch_2020_kakao {
    public static void main(String[] args) throws Exception{
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = solution(words, queries);
        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        Trie front = new Trie();
        Trie back = new Trie(); // 접두사가 ?로 시작되는 쿼리문이 존재하므로 문자열을 뒤집어서 트라이 구조에 저장해야 함

        for(String str : words) {
            front.insert(str);
            back.insert(reverse(str));
        }
        return Arrays.stream(queries).mapToInt(it -> it.charAt(0) == '?' ? back.find(reverse(it), 0) : front.find(it, 0)).toArray();
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static class Trie {
        Map<Integer, Integer> lenMap = new HashMap<>();
        Trie[] child = new Trie[26]; // 알파벳 개수만큼 할당

        public void insert(String str) {
            Trie node = this;
            int len = str.length();
            lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

            for(char c : str.toCharArray()) {
                int idx = c - 'a';
                if(node.child[idx] == null) {
                    node.child[idx] = new Trie();
                }
                node = node.child[idx];
                node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
            }
        }

        public int find(String str, int i) {
            if(str.charAt(i) == '?')
                return lenMap.getOrDefault(str.length(), 0);
            int idx = str.charAt(i) - 'a';
            return child[idx] == null ? 0 : child[idx].find(str, i + 1);
        }
    }
}
