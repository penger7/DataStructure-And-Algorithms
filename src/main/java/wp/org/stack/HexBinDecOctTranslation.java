package wp.org.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 非负数十进制与十六进制、二进制、八进制相互转化实现类
 * 整数部分使用短除法：除以对应进制的数字（2，8，16），余数的倒数排列就是对应进制
 * 小数部分使用短乘法：乘以对应进制的数字（2，8，16），整数顺序排列就是对应进制
 */
public class HexBinDecOctTranslation {

    public static void main(String[] args){
//        getDecimal(666.123);
        DecToOther(111.71875, 2);
        DecToOther(111.71875, 4);
        DecToOther(111.71875, 8);
        DecToOther(111.71875, 10);
        DecToOther(111.71875, 16);
    }

    /**
     * 获取小数部分
     */
    private static double getDecimal(double in){
        double dec;
        String decimal = in + " ";
        decimal = decimal.split("\\.")[1];
        dec = Double.valueOf("0." + decimal);
//        System.out.println(dec);
        return dec;
    }

    /**
     * 十进制转换成其他进制
     */
    public static void DecToOther(double in, int to){
        LinkedList<Integer> integerStack = new LinkedList<>();
        ArrayList<Integer> decimalArray = new ArrayList<>();
        int integer = (int)in;
        double dec = getDecimal(in);
        //整数部分
        while (integer != 0){
            integerStack.push(integer % to);
            integer = integer / to;
        }
        //小数部分
        while (dec != 0){
            decimalArray.add((int)(dec * to));
            dec = getDecimal(dec * to);
            if(decimalArray.size() > 100){
                break;
            }
        }

        for (int d:integerStack             ) {
            System.out.print(d+" ");
        }
        System.out.print(".");
        for(int t:decimalArray){
            System.out.print(t+" ");
        }
        System.out.println();
    }


}
