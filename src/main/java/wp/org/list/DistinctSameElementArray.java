package wp.org.list;

public class DistinctSameElementArray {

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(distinctSameElem(nums));
        for (int i:nums             ) {
            System.out.print(i+" ");
        }
    }

    public static int distinctSameElem(int[] nums){
        int length = nums.length;
        System.out.println("init:"+length);
        for (int i=0;i<length-1;i++) {
            if(nums[i] == nums[i+1]){
                    System.out.println("两个比较的值为："+nums[i]+", "+nums[i+1]);
                    length--;
                    for(int j=i+1;j<=length;j++){
                        nums[j-1] = nums[j];
                    }
                    i--;
            }
            System.out.print("检查比较"+i+" 和下一个元素之后的数组：");
            for (int k:nums             ) {
                System.out.print(k+" ");
            }
            System.out.print("length："+length);
            System.out.println();

        }
        return length;
    }
}
