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
        Trie back = new Trie(); // ���λ簡 ?�� ���۵Ǵ� �������� �����ϹǷ� ���ڿ��� ����� Ʈ���� ������ �����ؾ� ��

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
        Trie[] child = new Trie[26]; // ���ĺ� ������ŭ �Ҵ�

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
