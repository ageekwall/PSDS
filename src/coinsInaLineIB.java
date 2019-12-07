import java.util.ArrayList;
import java.util.List;

public class coinsInaLineIB {

    public static void main(String[] args) {
        coinsInaLineIB c = new coinsInaLineIB();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(9);
        a.add(1);
        a.add(2);
        c.maxcoin(a);
    }
    public int maxcoin(ArrayList<Integer> A) {
        int s = A.size();
        Pair dp[][] = new Pair[s+1][s+1];
        dp[0][0] = new Pair(0,0);

        int ar[][] = new int[][]{{1,2,4},{1,3,4},{2,4,5}};

        for(int gap = 0; gap < s; gap++) {
            for(int j = gap,i = 0 ; j < s; j++,i++) {
                dp[i][j] = new Pair();
                if (i == j) {
                    dp[i][j].x = A.get(i);
                    dp[i][j].y = 0;
                }
                else {
                    dp[i][j].x = Math.max(dp[i + 1][j].y + A.get(i),
                            dp[i][j - 1].y + A.get(j));
                    dp[i][j].y = Math.min(dp[i + 1][j].x, dp[i][j - 1].x);
                }
            }
        }
        return dp[0][s-1].x;
    }
    class Pair {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {

        }
    }
}

