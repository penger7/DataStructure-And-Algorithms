package wp.org.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ComputeExpression {

    private static Map<String, Integer> precedeMap ;

    static {
        Map<String, Integer> precedeTable = new HashMap<>();
        precedeTable.put("++", 1);  precedeTable.put("+-", 1);  precedeTable.put("+*", -1);  precedeTable.put("+/", -1);  precedeTable.put("+(", -1);  precedeTable.put("+)", 1);  precedeTable.put("+#", 1);
        precedeTable.put("-+", 1);  precedeTable.put("--", 1);  precedeTable.put("-*", -1);  precedeTable.put("-/", -1);  precedeTable.put("-(", -1);  precedeTable.put("-)", 1);  precedeTable.put("-#", 1);
        precedeTable.put("*+", 1);  precedeTable.put("*-", 1);  precedeTable.put("**", 1);  precedeTable.put("*/", 1);  precedeTable.put("*(", -1);  precedeTable.put("*)", 1);  precedeTable.put("*#", 1);
        precedeTable.put("/+", 1);  precedeTable.put("/-", 1);  precedeTable.put("/*", 1);  precedeTable.put("//", 1);  precedeTable.put("/(", -1);  precedeTable.put("/)", 1);  precedeTable.put("/#", 1);
        precedeTable.put("(+", -1);  precedeTable.put("(-", -1);  precedeTable.put("(*", -1);  precedeTable.put("(/", -1);  precedeTable.put("((", -1);  precedeTable.put("()", 0);  precedeTable.put("(#", -2);
        precedeTable.put(")+", 1);  precedeTable.put(")-", 1);  precedeTable.put(")*", 1);  precedeTable.put(")/", 1);  precedeTable.put(")(", -2);  precedeTable.put("))", 1);  precedeTable.put(")#", 1);
        precedeTable.put("#+", -1);  precedeTable.put("#-", -1);  precedeTable.put("#*", -1);  precedeTable.put("#/", -1);  precedeTable.put("#(", -1);  precedeTable.put("#)", -2);  precedeTable.put("##", 0);
        precedeMap = precedeTable;
    }


    //比较运算符优先级 1:大于 0：等于 -1：小于 -2：输入错误
    private static int comparePrecede(char a, char b){
        String key = a+""+b;
        return precedeMap.get(key);
    }

    private static int opreate(int a, int b, char o){
        int tmp = 0;
        switch (o){
            case '+':
                tmp = a + b;
                break;
            case '-':
                tmp = a - b;
                break;
            case '*':
                tmp = a * b;
                break;
            case '/':
                tmp = a / b;
                break;
        }
        return tmp;
    }

    public static void evaluateExpression(String ex){
        char[] array = ex.toCharArray();
        LinkedList<Character> OPTR = new LinkedList<>();
        OPTR.push('#');
        LinkedList<Integer> OPND = new LinkedList<>();
        System.out.println("初始化检查：array = ");
        for(char cc:array){
            System.out.print(cc+" ");
        }
        System.out.println();
        for (char c:array) {
            System.out.println("输入字符："+c);
            if(Character.isDigit(c)){
                OPND.push(Character.getNumericValue(c));
                System.out.println("数字入栈 OPND = "+Character.getNumericValue(c));
            }else {
                boolean flag = false;
                do {
                    flag = false;
                    System.out.println("大小比较结果 = " + comparePrecede(OPTR.peek(), c));
                    switch (comparePrecede(OPTR.peek(), c)) {
                        case -1:
                            System.out.println(c + "push到OPTR栈中");
                            OPTR.push(c);
                            break;
                        case 0:
                            System.out.println(c + "pop出OPTR栈中");
                            OPTR.pop();
                            break;
                        case 1:
                            flag = true;
                            char tmp = OPTR.pop();
                            int b = OPND.pop();
                            int a = OPND.pop();
                            if (c == ')') { //去除（括号
                                OPTR.pop();
                                flag = false;
                            }
                            OPND.push(opreate(a, b, tmp));
                            System.out.println("计算结果 = " + opreate(a, b, tmp));
                            break;
                    }
                }while (flag);
            }
            System.out.print("OPTR栈情况 = ");
            for (char k:OPTR                 ) {
                System.out.print(k+" ");
            }
            System.out.println();
            System.out.print("OPND栈情况 = ");
            for (int i:OPND                 ) {
                System.out.print(i+" ");
            }
            System.out.println();

        }
        System.out.println("表达式计算结果为："+OPND.peek());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入+ - * /简单表达式，可以用（）符号，最后以‘#’符号结尾");
        String expression = in.nextLine();
        System.out.println(expression);
        evaluateExpression(expression);
    }
}
