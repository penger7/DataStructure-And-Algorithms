package wp.org.tree;

public class TestTreeApp {
    public static void main(String[] args){
        Tree tree = initTree();
        tree.dispalyTree();
//        tree.inOrder(tree.getRoot());
        System.out.println(tree.height(tree.getRoot()));
    }

    private static Tree initTree(){
        Tree theTree = new Tree();
        theTree.insert(50, 50);
        theTree.insert(25, 25);
        theTree.insert(75, 75);
        theTree.insert(12, 12);
        theTree.insert(37, 37);
        theTree.insert(43, 43);
        theTree.insert(30, 30);
        theTree.insert(33, 33);
        theTree.insert(87, 87);
        theTree.insert(93, 93);
        theTree.insert(97, 97);
        return theTree;
    }
}
