package AlgorithmStudy;

public class LinkedList {
    static Node head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        head = n1;
        head.next = n2;
        n2.next = n3;

        print();
    }

    static class Node {
        int data;
        Node next;
        public Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void print() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }

    }
}
