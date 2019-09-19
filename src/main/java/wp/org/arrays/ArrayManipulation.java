package wp.org.arrays;

import java.io.*;
import java.util.*;

/**
 * 给你一个长度为N的列表，列表的初始值全是0。对此列表，你要进行M次查询，输出列表种最终N个值的最大值。对每次查询，给你的是3个整数——a,b和k，你要对列表中从位置a到位置b范围内的（包含a和b)的全部元素加上k。
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        Map<Integer,Long> map = new HashMap<>();
        long max = 0;
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0]-1;j<queries[i][1];j++){
                if(null == map.get(j)){
                    map.put(j, (long)queries[i][2]);
                }else {
                    map.put(j, map.get(j) + queries[i][2]);
                }
                if(max < map.get(j)){
                    max = map.get(j);
                }
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
