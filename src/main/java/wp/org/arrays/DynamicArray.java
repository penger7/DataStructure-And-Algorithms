package wp.org.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        int lastAnswer = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        System.out.println("size="+queries.size());
        for(int i=0;i<queries.size();i++){
            int type = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            System.out.println("i="+i+"type="+type+"x="+x+"y="+y);
            if(type == 1){
                int index = (x^lastAnswer)%n;
                list.get(index).add(y);
                System.out.println("index="+index+"la="+lastAnswer);
            }else{
                int index = (x^lastAnswer)%n;
                int subindex = y%list.get(index).size();
                lastAnswer = list.get(index).get(subindex);
                System.out.println("index="+index+"la="+lastAnswer);
                result.add(lastAnswer);
            }
        }
        return result;
    }

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        Scanner scanner = new Scanner(System.in);
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = scanner.nextInt();//Integer.parseInt(firstMultipleInput[0]);

        int q = scanner.nextInt();//Integer.parseInt(firstMultipleInput[1]);

        System.out.print("n="+n+"q="+q);
        List<List<Integer>> queries = new ArrayList<>();

        for(int i=0;i<q;i++){
            List<Integer> l = new ArrayList<>();
            l.add(scanner.nextInt());
            l.add(scanner.nextInt());
            l.add(scanner.nextInt());
            queries.add(l);
        }

//        IntStream.range(0, q).forEach(i -> {
////            try {
//                queries.add(
//                        Stream.of(scanner.nextLine().split(" "))//bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
////            } catch (IOException ex) {
////                throw new RuntimeException(ex);
////            }
//        });

        List<Integer> result = Result.dynamicArray(n, queries);
        for(Integer i:result){
            System.out.println(i);
        }

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
