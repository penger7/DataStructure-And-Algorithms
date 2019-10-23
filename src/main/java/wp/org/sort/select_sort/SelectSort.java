package wp.org.sort.select_sort;

public class SelectSort {
    private long[] a;
    private int length;

    public SelectSort(int maxLength){
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

    public void selectSort(){
        for(int out=0;out<length-1;out++){
            long minValue = a[out];
            int min = out;
            for(int in=out;in<length-1;in++){
                if(minValue > a[in+1]){
                    minValue = a[in+1];
                    min = in+1;
                }
                System.out.print("in="+in+" ");
                dispaly();
            }
            long tmp = a[out];
            a[out] = a[min];
            a[min] = tmp;
            System.out.print("out="+out+" ");
            dispaly();
        }
    }


}
