package AlgorithmStudy;

// ���ڿ����� �˻��� ������ ���ִ� �ڷᱸ��
// Ʈ���̸� �̿��ϸ� O(M)�� �ð����� ���ϴ� ���ڿ� �˻� ����

public class Trie {
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    // �Է¹��� ���ڿ��� �� �ܾ ���� ������ �ڽĳ��� ����� �ִ´�
    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i = 0; i < word.length(); i++) {
            // �ش� ���� ������ �ڽĳ�尡 �������� ���� ������ �ڽ� ��� ����
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        // ������ ���ڿ��� ��������� ������ �ϴ� �ܾ �����Ѵٴ� ǥ�ø� ����
        thisNode.setLastChar(true);
    }

    // Ư�� �ܾ Trie�� �����ϴ��� Ȯ���ϱ� ����
    // 1. ��Ʈ ������ ������� ���ĺ��� ��ġ�ϴ� �ڽ� ������ ������ ��
    // 2. �ش� �ܾ��� ������ ���ڿ� �ش��ϴ� ����� isLastChar�� true�� ��
    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // TrieNode�� ������ �ִ� �ڽ� ��� �߿��� �ش� ���ڸ� ���� ��带 �����´�
            TrieNode node = thisNode.getChildNodes().get(c);
            // TrieNode�� �ڽ� ��� �� �ش� ���ڸ� ���� ��尡 ����. ��, word��� ���ڰ� �������� �ʴ´�
            if(node == null) return false;
            // ���ڰ� �����ϸ� ���ڿ��� ��� �ܾ Trie�� �����ϴ��� Ȯ���ϱ� ���� TrieNode�� �ڽ� ���� �ٲٸ鼭 Ž��
            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    // Trie�� �־��� �ܾ� ����
    // �־��� �ܾ ã�� ���� ���� �ܾ���̸�ŭ ��������
    // �� ���鿡 �θ� ��忡 ���� ������ �������� �����Ƿ� ���� ���� �������� Ž���ϰ� �ٽ� �ö���� �����ϴ� �ݹ� �������� ����
    // Ž�� : �θ� -> �ڽ� ��� ����
    // ���� : �ڽ� -> �θ� ��� ����
    // ���� ����
    // 1. �ڽ� ��带 ������ ���� �ʾƾ� �Ѵ�
    // 2. ������ �����ϴ� ù ���� isLastChar == true�̾�� �Ѵ�. false�� ���� Trie�� ���������� �ʴٴ� ���̹Ƿ�
    // 3. ������ �����ϴ� �߿��� isLastChar == false�̾�� �Ѵ�. ���� ���� �� isLastChar�� true��� �� �ٸ� �ܾ �ִٴ� �ǹ��̹Ƿ�
    void delete(String word) {
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char c = word.charAt(index);

        // ��������2
        if(!thisNode.getChildNodes().containsKey(c)) throw new Error("�ƿ� �������� �ʴ� �ܾ�");
        TrieNode childNode = thisNode.getChildNodes().get(c);
        index++;

        if(index == word.length()) {
            if(!childNode.isLastChar()) throw new Error("���� ���������� insert�� �ܾ �ƴ�");

            childNode.setLastChar(false);

            // �������� 1
            // ���� ��� ������ �����ν� �ڽ� ��尡 ���ٸ� ���� ����
            if(childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(c);
        } else {
            delete(childNode, word, index);

            // �������� 1, 3
            // ���� �� �ڽĳ�尡 ���� ���� ���� ������ �ܾ ���� ��� ����
            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(c);
            }
        }
    }
}
