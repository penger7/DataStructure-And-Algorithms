package wp.org.sort.bubble_sort;

/**
 * 冒泡排序算法类
 */
public class BubbleSort {
    private long[] a;
    private int length;

    public BubbleSort(int maxLength){
        a = new long[maxLength];
        length = 0;
    }

    public void insert(long value){
        a[length] = value;
        length++;
    }

    public void dispaly(){
        for (int i=0;i<length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public void bubbleSort(){
        for(int out=length-1;out>0;out--){
            for(int in=0;in<out;in++){
                if(a[in] > a[in+1]){
                    long tmp = a[in];
                    a[in] = a[in+1];
                    a[in+1] = tmp;
                }
                System.out.print("out="+out+" in="+in);
                dispaly();
            }
        }
    }


}
