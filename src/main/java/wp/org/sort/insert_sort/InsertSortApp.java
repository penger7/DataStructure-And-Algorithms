package wp.org.sort.insert_sort;


public class InsertSortApp {

    public static void main(String[] args){
        InsertSort insertSort = new InsertSort(100);

        insertSort.insert(77);
        insertSort.insert(53);
        insertSort.insert(22);
        insertSort.insert(79);
        insertSort.insert(2);
        insertSort.insert(717);
        insertSort.insert(36);
        insertSort.insert(57);
        insertSort.insert(53);
        insertSort.insert(1);

        insertSort.dispaly();

        insertSort.insertSort();

        insertSort.dispaly();

    }

}
