package wp.org;

import java.math.BigInteger;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
//        int[] test = {1,8,6,2,5,4,8,3,7};
//        System.out.println( maxArea(test) );
//        int nums1[] = {1,2};
//        int nums2[] = {3,4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//        System.out.println(simplifyPath("/a//b////c/d//././/.."));
//        System.out.println(simplifyPath("/a/../../b/../c//.//"));
//        timeConversion("12:45:54PM");
//        gradingStudents()
//        System.out.println(twoStrings("hackerrankcommunity","cdecdecdecde"));
//        List<String> names = new ArrayList<String>() {{
//            add("Tom");
//            add("Sally");
//            add("John");
//        }};
//
//        int[][] arr = { {-1,-1,0,-9,-2,-2},
//                        {-2,-1,-6,-8,-2,-5},
//                        {-1,-1,-1,-2,-3,-4},
//                        {-1,-9,-2,-4,-4,-5},
//                        {-7,-3,-3,-2,-9,-9},
//                        {-1,-3,-1,-2,-4,-5},
//                      };
//        System.out.println(hourglassSum(arr));
//        Scanner sc = new Scanner(System.in);
//        LinkedList<Integer> queue = new LinkedList<>();
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++){
//            int type = sc.nextInt();
//            switch (type){
//                case 1:
//                    int num = sc.nextInt();
//                    queue.add(num);
//                    break;
//                case 2:
//                    queue.removeFirst();
//                    break;
//                case 3:
//                    System.out.println(queue.getFirst());
//                    break;
//            }
//        }
//        sc.close();
//        System.out.println(countingValleys(8,"UDDDUDUU"));
        int[][] s = {{4,5,8},
                    {2,4,1},
                    {1,9,7},};
        System.out.println(formingMagicSquare(s));
    }

    static int formingMagicSquare(int[][] s) {
        int sum = 0;
        Map<Integer,Integer> lack = new HashMap<>();
        Map<Integer,Integer> more = new HashMap<>();
        lack.put(1,1);
        lack.put(2,1);
        lack.put(3,1);
        lack.put(4,1);
        lack.put(5,1);
        lack.put(6,1);
        lack.put(7,1);
        lack.put(8,1);
        lack.put(9,1);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(null == lack.remove(s[i][j])){
                    more.put(s[i][j],s[i][j]);
                }
            }
        }
        Iterator<Integer> l = lack.keySet().iterator();
        Iterator<Integer> m = more.keySet().iterator();
        while (l.hasNext() & m.hasNext()){
            sum += Math.abs(l.next() - m.next());
        }
//        System.out.println(lack.size());
//        for(int i:more.keySet()){
//            System.out.print(i);
//        }
        return sum;
    }

    static int countingValleys(int n, String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int num = 0;
        boolean isDownSea = false;
        char[] c = s.toCharArray();
        for(char i:c){
            if(stack.size() != 0){
                char peek = stack.peek();
                if(peek == 'U' & i == 'D'){
                    stack.pop();
                }else if(peek == 'D' & i == 'U'){
                    stack.pop();
                }else {
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }

            if(stack.size() != 0){
                if(stack.peek() == 'D'){
                    isDownSea = true;
                }else{
                    isDownSea = false;
                }
            }else {
                if (isDownSea){
                    num++;
                    isDownSea = false;
                }
            }
        }
        return num;
    }


    static int sockMerchant(int n, int[] ar) {
        LinkedList<Integer> matchList = new LinkedList<>();
        int num = 0;
        for(int i:ar){
            if(matchList.contains(i)){
                matchList.removeFirstOccurrence(i);
            }else {
                matchList.add(i);
            }
        }
        num = (n - matchList.size())/2;
        return num;
    }

    static int hourglassSum(int[][] arr) {
        int sum = -64;
        int[][][] hourglassList = new int[16][3][3];
        int num = 0;
        for(int l=0;l<4;l++){
            for(int k=0;k<4;k++){
                int h=0;
                for(int i=l;i<l+3;i++){
                    int t=0;
                    for(int j=k;j<k+3;j++){
//                        System.out.print("h="+h+"t="+t);
//                        System.out.println(" "+arr[i][j]);
                        hourglassList[num][h][t] = arr[i][j];
                        t++;
                    }
                    h++;
                }
                num++;
//                System.out.println(num);
            }
        }
        //输出三维数组
        for(int i=0;i<16;i++){
            int tmp = 0;
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    System.out.print(hourglassList[i][j][k]);
                    if(j == 1){
                        if(k == 1){
                            tmp += hourglassList[i][j][k];
                        }
                    }else {
                        tmp += hourglassList[i][j][k];
                    }
                }
                System.out.println();
            }
            System.out.print(tmp);
            System.out.println();
            if(tmp > sum){
                sum = tmp;
            }
        }


        return sum;

    }

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i:a){
            list.push(i);
        }
        int[] b = a;
        for(int i=0;list.size()!=0;i++){
            b[i] = list.pop();
        }

        return b;
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        hMap.put(1,0);
        hMap.put(2,0);
        hMap.put(3,0);
        hMap.put(4,0);
        hMap.put(5,0);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        for(int i:arr){
            switch (i){
                case 1:
                    a++;
                    hMap.put(1, a);
                    break;
                case 2:
                    b++;
                    hMap.put(2, b);
                    break;
                case 3:
                    c++;
                    hMap.put(3, c);
                    break;
                case 4:
                    d++;
                    hMap.put(4, d);
                    break;
                case 5:
                    e++;
                    hMap.put(5, e);
                    break;
            }
        }
        int num = 1;
        int max = hMap.get(1);
        for(int i=2;i<6;i++){
            if(max < hMap.get(i)){
                max = hMap.get(i);
                num = i;
            }
        }
        return num;
    }

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int num = 0;
        for(int i=0;i<=(s.size() - m);i++){
            int sum = 0;
            for(int j=i;j<i+m;j++){
                sum += s.get(j);
            }
            if(d == sum){
                num++;
            }
        }
        return num;
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1<=v2){
            return "NO";
        }else{
            int times = (x2-x1)/(v1-v2);
            if((x1+v1*times) == (x2+v2*times)){
                return "YES";
            }else{
                return "NO";
            }
        }
    }


    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        List<Integer> applesLocation = new ArrayList<>();
        List<Integer> orangesLocation = new ArrayList<>();
        int anum = 0;
        int bnum = 0;
        for(int i:apples){
            applesLocation.add(a+i);
        }
        for(int i:oranges){
            orangesLocation.add(b+i);
        }
        for(int i:applesLocation){
            if(i>=s & i<=t){
                anum++;
            }
        }
        for(int i:orangesLocation){
            if(i>=s & i<=t){
                bnum++;
            }
        }
        System.out.println(anum);
        System.out.print(bnum);
    }

    static String twoStrings(String s1, String s2) {
        String result = "NO";
        char[] car = s1.toCharArray();
        for(char c:car){
            if(s2.contains(c+"")){
                result = "YES";
            }else {
            }
        }
        return result;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        LinkedList<Integer> result = new LinkedList<>();
        grades.sort((i,j)->i.compareTo(j));
        for(int i:grades){
            System.out.println(i);
        }
//        for(int i:grades){
//            for(int j=0;j<result.size();j++){
//                if(i <= result.get(j)){
//                    int k = j;
//                    while (k<=result.size()) {
//
//                        int tmp = result.get(k);
//                        result.set(k, i);
//                        k++;
//                    }
//                }
//            }
//        }
        return result;
    }

    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
//        boolean isPM = false;
        int hhPM = 0;
        if(s.substring(8,s.length()).equals("PM")){
            hhPM = Integer.valueOf(s.substring(0,2));
            hhPM += 12;
            // if(hhPM == 24){
            //     s = "00"+s.substring(2,8);
            // }else {
            //     s = hhPM + s.substring(2, 8);
            // }
            s = hhPM + s.substring(2, 8);
        }else {
            int AM = Integer.valueOf(s.substring(0,2));
            if(AM == 12){
                s = "00"+s.substring(2,8);
            }else{
                s = s.substring(0,8);
            }
        }
        System.out.println(s);
        return s;
    }

    static void plusMinus(int[] arr) {
        int a = 0;
        int b = 0;
        int c = 0;
        double length = arr.length;
        for (int i:arr) {
            if(i > 0){
                a++;
            }else if(i < 0){
                b++;
            }else{
                c++;
            }
        }
        System.out.println(a/length);
        System.out.println(b/length);
        System.out.println(c/length);

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int a = 0;
        int b = 0;
        int length = arr.get(0).size();
        for(int i=0;i<length;i++){
            a += arr.get(i).get(i);
        }
        for(int i=0;i<length;i++){
            b += arr.get(i).get(length-i-1);
        }
        return Math.abs(a - b);
    }

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0l;
        for (long l:ar             ) {
            sum += l;
        }
        return sum;
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aa = 0;
        int bb = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(a.get(i).compareTo(b.get(i)) > 0){
                aa++;
            }else if(a.get(i).compareTo(b.get(i)) < 0){
                bb++;
            }
        }
        list.add(aa);
        list.add(bb);
        return list;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listHead = new ListNode(0);
        ListNode list = new ListNode(0);
        listHead.next = list;
        while (null != l1 & null != l2 ) {
            if (l1.val <= l2.val) {
                list.next = new ListNode(l1.val);
                list = list.next;
                l1 = l1.next;
            } else {
                list.next = new ListNode(l2.val);
                list = list.next;
                l2 = l2.next;
            }
        }
        if(null == l1){
            list.next = l2;
        }else {
            list.next = l1;
        }
        return listHead.next.next;
    }

    public static String simplifyPath(String path) {
        String[] s = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<String> stackOut = new LinkedList<>();
        for (String t:s             ) {
            System.out.print(t+", ");
        }
        System.out.println();
        stack.push("/");
        for (String t:s) {
            if(t.equals("..")){
                if(stack.size() != 1){
                    stack.pop();
                }
            }else if(!t.equals(".") & !t.equals("")){
                stack.push(t+"/");
            }
            for (String k:stack) {
                System.out.print(k+", ");
            }
            System.out.println();

        }
        System.out.println();
        StringBuffer sb = new StringBuffer();
        for (String k:stack) {
            stackOut.push(k);
        }
        for (String k:stackOut) {
            sb.append(k);
        }
        if(sb.length() != 1){
            return sb.toString().substring(0,sb.length()-1);
        }
        return sb.toString();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int length = nums1.length + nums2.length;
        List<Integer> tmp = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length & j < nums2.length){
            if(nums1[i] <= nums2[j]){
                tmp.add(nums1[i]);
                i++;
            }else {
                tmp.add(nums2[j]);
                j++;
            }
        }
        if(i == nums1.length){
            for (int k=j;k<nums2.length;k++) {
                tmp.add(nums2[k]);
            }
        }else {
            for (int k=i;k<nums1.length;k++) {
                tmp.add(nums1[k]);
            }
        }
        if(length%2 == 0){
            median = (tmp.get(length/2-1)+tmp.get(length/2))/2.0;
        }else {
            median = tmp.get(length/2);
        }
        return median;
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int floor = j-i;
                int h = Math.min(height[i], height[j]);
                max = max>floor * h?max:floor * h;
            }
        }
        return max;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
