package wp.org.tree;

public class Node {
    public int key;
    public int data;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.print("{"+data+"}");
    }
}
