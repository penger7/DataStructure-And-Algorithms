package wp.org.arrays;

import java.io.*;
import java.util.*;

/**
 * There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings.
 * For example, given input strings = ['ab','ab','abc'] and queries = ['ab','abc','bc'], we find 2 instances of 'ab', 1 of 'abc' and 0 of 'bc'. For each query, we add an element to our return array, result = [2,1,0].
 */
public class MatchStrings {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int num = 0;
            for(String s:strings){
                if(queries[i].equals(s)){
                    num++;
                }
            }
            result[i] = num;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
//            bufferedWriter.write(String.valueOf(res[i]));

//            if (i != res.length - 1) {
//                bufferedWriter.write("\n");
//            }
            System.out.println(res[i]);
        }

//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}