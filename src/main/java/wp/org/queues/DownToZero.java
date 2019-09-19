package wp.org.queues;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DownToZero {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
        int steps = 0;
        int min = 0 ;
        while(true){
            if(min == n){
                break;
            }
            if(min < n){
                if(min == 0){
                    min++;
                    steps++;
                }else if(min == 1){
                    min++;
                    steps++;
                }else {
                    boolean end = true;
                    for(int i=2;i<=min;i++){
                        if(min*i > n){
                            if(i != 2){
                                end = false;
                                min = min*(i-1);
                                steps++;
                                break;
                            }else{
                                end = false;
                                min++;
                                steps++;
                                break;
                            }
                        }
                    }
                    if(end){
                        min = min*min;
                        steps++;
                    }
                }
            }
        }
        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}