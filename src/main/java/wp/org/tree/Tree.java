package wp.org.tree;

import java.util.LinkedList;
import java.util.List;

public class Tree {
    private Node root;

    public Tree(){
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    public Node find(int key){
        Node current = root;
        while (key != current.key){
            if(key < current.key){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }
            if(null == current){
                return null;
            }
        }
        return current;
    }

    public void insert(int key, int data){
        Node newNode = new Node();
        newNode.key = key;
        newNode.data = data;
        if(null == root){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(key < current.key){
                    current = current.leftChild;
                    if(null == current){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if(null == current){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findMin() {
        Node current = root;
        Node last = current;
        while (null != current){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax(){
        Node current = root;
        Node last = current;
        while (null != current){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    //前序遍历
    public void preOrder(Node node){
        if(null != node){
            System.out.println(node.data+" ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    //中序遍历
    public void inOrder(Node node){
        if(null != node){
            inOrder(node.leftChild);
            System.out.println(node.data+" ");
            inOrder(node.rightChild);
        }
    }

    //后续遍历
    public void postOrder(Node node){
        if(null != node){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.data+" ");
        }
    }

    //层序遍历
    public void levelOrder(){

    }

    //树的高度
    public int height(Node root) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        leafNodeHeight(root, 0, stack);
        return stack.pop();
    }

    private void leafNodeHeight(Node node, int h, LinkedList<Integer> stack){
        if(null == node.leftChild && null == node.rightChild){
            if(h > stack.peek()){
                stack.pop();
                stack.push(h);
            }
        }else if(null == node.rightChild){
            leafNodeHeight(node.leftChild, h+1, stack);
        }else if(null == node.leftChild){
            leafNodeHeight(node.rightChild, h+1, stack);
        }else{
            leafNodeHeight(node.leftChild, h+1, stack);
            leafNodeHeight(node.rightChild, h+1, stack);
        }
    }

    public boolean delete(int key){
        if(null == root){
            return false;
        }
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //找到要删除的节点
        while (current.key != key){
            parent = current;
            if(key < current.key){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(null == current){
                return false;
            }
        }

        //要删除的节点没有子节点
        if(null == current.leftChild & null == current.rightChild){
            if(current == root){
                current = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }

        //要删除的节点只有左孩子节点
        else if(null == current.rightChild){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }

        //要删除的节点只有右孩子节点
        else if(null == current.leftChild){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }

        //要删除的节点同时有左右孩子节点
        else{
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    //返回节点的直接后继节点
    private Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (null != current){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void dispalyTree(){
        LinkedList<Node> globalStack = new LinkedList<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................................");
        while (isRowEmpty == false){
            LinkedList<Node> localStack = new LinkedList<>();
            isRowEmpty = true;

            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }

            while (globalStack.isEmpty()==false){
                Node temp = globalStack.pop();
                if(null != temp){
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(null != temp.leftChild || null != temp.rightChild){
                        isRowEmpty = false;
                    }
                }else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i=0;i<nBlanks*2-2;i++){
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty()==false){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("......................................................................");
    }
}
