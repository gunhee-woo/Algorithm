package BaekJoon.Trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 트라이 자료구조를 사용하였을 때 속도가 훨씬 빠름
public class PhoneNumberList_5052 {
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        while(T-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            Set<String> set = new HashSet<>();
//            List<String> list = new ArrayList<>();
//            boolean isFind = false;
//            for(int i = 0; i < n; i++) {
//                String str = br.readLine();
//                list.add(str);
//                set.add(str);
//            }
//            for (String value : list) {
//                String temp = "";
//                for (int j = 0; j < value.length(); j++) {
//                    temp += value.charAt(j);
//                    if (set.contains(temp)) {
//                        // 전화번호가 완전 같은 두 값은 존재하지 않는다 => 조건에 의해 자기 자신과 같은 단어일 경우 예외 처리
//                        if(temp.equals(value)) continue;
//                        isFind = true;
//                        break;
//                    }
//                }
//                if (isFind) break;
//            }
//            if(isFind) System.out.println("NO");
//            else System.out.println("YES");
//        }
//    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isFind = false;
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String str = br.readLine();
                trie.insert(str);
                list.add(str);
            }
            for(String str : list) {
                if(trie.contains(str)) {
                    isFind = true;
                    break;
                }
            }
            if(isFind) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    public static class TrieNode {
        private Map<Character, TrieNode> childNode = new HashMap<>();
        private boolean isLastChar;

        public Map<Character, TrieNode> getChildNode() {
            return childNode;
        }

        public boolean isLastChar() {
            return isLastChar;
        }

        public void setLastChar(boolean lastChar) {
            isLastChar = lastChar;
        }
    }

    public static class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        public void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), it -> new TrieNode());
            }
            thisNode.setLastChar(true);
        }

        public boolean contains(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNode().get(c);
                if(node == null) return false;
                thisNode = node;
            }
            if(thisNode.isLastChar()) { // 해당 단어로 종료하는 문자가 존재한다
                // 전화번호가 완전 같은 두 값은 존재하지 않는다 => 조건에 의해 자기 자신과 같은 단어일 경우 예외 처리
                if(thisNode.getChildNode().isEmpty()) return false;
            }
            return true;
        }
    }
}
