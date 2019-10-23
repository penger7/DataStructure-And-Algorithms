package wp.org.sort.insert_sort;

public class InsertSort {
    private long[] a;
    private int length;

    public InsertSort(int maxLength){
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

    public void insertSort(){
        for(int r=0;r<length;r++){
            for(int l=r-1;l>=0;l--){
                if(a[l] > a[l+1]){
                    long tmp = a[l];
                    a[l] = a[l+1];
                    a[l+1] = tmp;
                }else{
                    break;
                }
            }
        }
    }


}
