package AlgorithmStudy;

// 문자열에서 검색을 빠르게 해주는 자료구조
// 트라이를 이용하면 O(M)의 시간만에 원하는 문자열 검색 가능

public class Trie {
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    // 입력받은 문자열의 각 단어를 계층 구조의 자식노드로 만들어 넣는다
    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i = 0; i < word.length(); i++) {
            // 해당 계층 문자의 자식노드가 존재하지 않을 때에만 자식 노드 생성
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        // 마지막 글자에서 여기까지를 끝으로 하는 단어가 존재한다는 표시를 위함
        thisNode.setLastChar(true);
    }

    // 특정 단어가 Trie에 존재하는지 확인하기 위함
    // 1. 루트 노드부터 순서대로 알파벳이 일치하는 자식 노드들이 존재할 것
    // 2. 해당 단어의 마지막 글자에 해당하는 노드의 isLastChar가 true일 것
    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // TrieNode가 가지고 있는 자식 노드 중에서 해당 문자를 가진 노드를 가져온다
            TrieNode node = thisNode.getChildNodes().get(c);
            // TrieNode의 자식 노드 중 해당 문자를 가진 노드가 없다. 즉, word라는 문자가 존재하지 않는다
            if(node == null) return false;
            // 문자가 존재하면 문자열의 모든 단어가 Trie에 존재하는지 확인하기 위해 TrieNode를 자식 노드로 바꾸면서 탐색
            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    // Trie에 넣었던 단어 삭제
    // 주어진 단어를 찾아 하위 노드로 단어길이만큼 내려간다
    // 각 노드들에 부모 노드에 대한 정보가 존재하지 않으므로 하위 노드로 내려가며 탐색하고 다시 올라오며 삭제하는 콜백 형식으로 구현
    // 탐색 : 부모 -> 자식 노드 방향
    // 삭제 : 자식 -> 부모 노드 방향
    // 삭제 조건
    // 1. 자식 노드를 가지고 있지 않아야 한다
    // 2. 삭제를 시작하는 첫 노드는 isLastChar == true이어야 한다. false인 경우는 Trie가 가지고있지 않다는 뜻이므로
    // 3. 삭제를 진행하던 중에는 isLastChar == false이어야 한다. 삭제 과정 중 isLastChar가 true라면 또 다른 단어가 있다는 의미이므로
    void delete(String word) {
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char c = word.charAt(index);

        // 삭제조건2
        if(!thisNode.getChildNodes().containsKey(c)) throw new Error("아예 존재하지 않는 단어");
        TrieNode childNode = thisNode.getChildNodes().get(c);
        index++;

        if(index == word.length()) {
            if(!childNode.isLastChar()) throw new Error("노드는 존재하지만 insert한 단어가 아님");

            childNode.setLastChar(false);

            // 삭제조건 1
            // 삭제 대상 문자의 끝으로써 자식 노드가 없다면 삭제 시작
            if(childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(c);
        } else {
            delete(childNode, word, index);

            // 삭제조건 1, 3
            // 삭제 중 자식노드가 없고 현재 노드로 끝나는 단어가 없을 경우 삭제
            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(c);
            }
        }
    }
}
