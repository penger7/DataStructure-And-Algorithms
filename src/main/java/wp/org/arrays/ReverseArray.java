package wp.org.arrays;

import java.io.*;
import java.util.*;

public class ReverseArray {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int[] reverseArray = new int[a.length];
        for(int i=0;i<a.length;i++){
            reverseArray[i] = a[a.length-1-i];
        }
        return reverseArray;
//        LinkedList<Integer> list = new LinkedList<>();
//        for(int i:a){
//            list.push(i);
//        }
//        int[] b = a;
//        for(int i=0;list.size()!=0;i++){
//            b[i] = list.pop();
//        }
//
//        return b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("1");
        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("2");
        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
//            bufferedWriter.write(String.valueOf(res[i]));

//            if (i != res.length - 1) {
//                bufferedWriter.write(" ");
//            }
            System.out.print(res[i]);
        }

//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}

