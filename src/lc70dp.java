public class lc70dp {

    public static void main(String[] args) {
        lc70dp lc70dp= new lc70dp();
        System.out.println(lc70dp.climbStairsDP(10));
        System.out.println(lc70dp.climbStairRec(10));
    }
    public int climbStairRec(int n){
        if(n ==1) return 1;
        if(n == 2) return 2;

        return climbStairRec(n-1) + climbStairRec(n-2);
    }
    public int climbStairsDP(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n < 2) return n;
        dp[2] = 2;
        for(int i = 3; i <=n ; i++) {
            dp[i] = (dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
