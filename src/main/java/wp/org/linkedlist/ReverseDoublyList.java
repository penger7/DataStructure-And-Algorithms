package wp.org.linkedlist;

import java.io.*;
import java.util.*;

public class ReverseDoublyList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) throws IOException {
        System.out.println();
        while (node != null) {
//            bufferedWriter.write(String.valueOf(node.data));
            System.out.println(node.data);
            node = node.next;

//            if (node != null) {
//                bufferedWriter.write(sep);
//            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        LinkedList<DoublyLinkedListNode> stack = new LinkedList<>();
        DoublyLinkedListNode h = new DoublyLinkedListNode(0);
        DoublyLinkedListNode first = new DoublyLinkedListNode(0);
        while (null != head){
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        for(int i=1;i<=size;i++){
            if(i == 1){
                h = stack.pop();
                h.prev = null;
                first.next = h;
            }else if(i == size){
                h.next = stack.pop();
                h.next.prev = h;
                h.next.next = null;
            }else {
                h.next = stack.pop();
                h.next.prev = h;
                h = h.next;
            }
        }
        return first.next;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
