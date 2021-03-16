package AlgorithmStudy;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private boolean isLastChar;
    private Map<Character, TrieNode> childNodes = new HashMap<>();

    // 자식 노드는 트라이 차원에서 생성해서 넣을 것이기 때문에 getter만 생성
    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}
