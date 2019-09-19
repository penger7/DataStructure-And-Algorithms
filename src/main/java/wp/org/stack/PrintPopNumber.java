package wp.org.stack;


import java.io.*;
import java.util.*;

public class PrintPopNumber {

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            LinkedList<Integer> stack = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int max = Integer.MIN_VALUE;
            LinkedList<Integer> maxStack = new LinkedList<>();
            for(int i=0;i<N;i++){
                int type = sc.nextInt();
                switch(type){
                    case 1:
                        int num = sc.nextInt();
                        if(max < num){
                            max = num;
                        }
                        maxStack.push(max);
                        stack.push(num);
                        break;
                    case 2:
                        stack.pop();
                        maxStack.pop();
                        if(maxStack.size() == 0){
                            max = Integer.MIN_VALUE;
                        }else {
                            max = maxStack.peek();
                        }
                        break;
                    case 3:
                        System.out.println(maxStack.peek());
                        break;
                }
            }
        }
    }