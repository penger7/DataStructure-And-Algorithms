package wp.org.sort.select_sort;

import wp.org.sort.bubble_sort.BubbleSort;

public class SelectSortApp {

    public static void main(String[] args){
        SelectSort selectSort = new SelectSort(100);

        selectSort.insert(77);
        selectSort.insert(53);
        selectSort.insert(22);
        selectSort.insert(79);
        selectSort.insert(2);
        selectSort.insert(717);
        selectSort.insert(36);
        selectSort.insert(57);
        selectSort.insert(53);
        selectSort.insert(1);

        selectSort.dispaly();

        selectSort.selectSort();

        selectSort.dispaly();

    }

}
