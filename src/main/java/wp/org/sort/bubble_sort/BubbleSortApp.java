package wp.org.sort.bubble_sort;

public class BubbleSortApp {

    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort(100);

        bubbleSort.insert(77);
        bubbleSort.insert(53);
        bubbleSort.insert(22);
        bubbleSort.insert(79);
        bubbleSort.insert(2);
        bubbleSort.insert(717);
        bubbleSort.insert(36);
        bubbleSort.insert(57);
        bubbleSort.insert(53);
        bubbleSort.insert(1);

        bubbleSort.dispaly();

        bubbleSort.bubbleSort();

        bubbleSort.dispaly();

    }

}
