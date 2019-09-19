package wp.org.stack;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class EqualHeightStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int height1 = Arrays.stream(h1).sum();
        int height2 = Arrays.stream(h2).sum();
        int height3 = Arrays.stream(h3).sum();
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();
        for(int i=h1.length-1;i>=0;i--){
            stack1.push(h1[i]);
        }
        for(int i=h2.length-1;i>=0;i--){
            stack2.push(h2[i]);
        }
        for(int i=h3.length-1;i>=0;i--){
            stack3.push(h3[i]);
        }

        if(height1 == height2 & height2 == height3){
            return height1;
        }

        while (height1 != 0 & height2 != 0 & height3 != 0){
            if(height1 >= height2 & height1 >= height3){
                height1 -= stack1.pop();
            }else if(height2 >= height1 & height2 >= height3) {
                height2 -= stack2.pop();
            }else if(height3 >= height1 & height3 >= height2) {
                height3 -= stack3.pop();
            }
            if(height1 == height2 & height2 == height3){
                break;
            }
        }

        if(height1 == height2 & height2 == height3){
            return height1;
        }else{
            return 0;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();
    }
}
