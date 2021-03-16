package AlgorithmStudy;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private boolean isLastChar;
    private Map<Character, TrieNode> childNodes = new HashMap<>();

    // �ڽ� ���� Ʈ���� �������� �����ؼ� ���� ���̱� ������ getter�� ����
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
