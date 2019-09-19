package wp.org.game;

/**
 * 三枚石子放置在数轴上，位置分别为 a，b，c。

 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。

 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveStone {

    public static void main(String[] args){
        for (int a:numMovesStones(4,3,2)) {
            System.out.println(a);
        }
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int[] answer = {0,0};
        int f = Math.abs(a-b);
        int s = Math.abs(b-c);
        if(f == 1 && s == 1){
            return answer;
        }else if(f == 1 || s == 1){
            int tmp;
            if(f != 1){
                tmp = f;
            }else {
                tmp = s;
            }
            answer[0] = 1;
            answer[1] = tmp-1;
            return answer;
        }else {
            answer[0] = 2;
            answer[1] = f+s-2;
            return answer;
        }

    }
}
