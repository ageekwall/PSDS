public class waystodecodedp {
}
 class Solution {
    public int numDecodings(String A) {
        int size = A.length();
        int dp[] = new int[size+1];
        if(A.charAt(0)=='0') return 0;
        dp[0] = 1;
        for(int i =1; i < size; i++) {
            char c = A.charAt(i);
            char cp = A.charAt(i-1);
            int j = c -'0';
            int jp =cp -'0';
            int njp = (10*jp)+j;
            // System.out.println(njp);
            if(j == 0 ) {
                if(njp != 20 && njp != 10) return 0;
            }
            if(j == 0) {
                if(dp[i-1] == 1) {
                    dp[i] = 1;
                }
                else
                    dp[i] = dp[i-1]-dp[i-2];
            }
            if(jp== 0) {
                dp[i] = dp[i-1];
            }
            if(jp!= 0 && j != 0 && njp > 26)
                dp[i] = dp[i-1];
            else if(jp!= 0 && j != 0) {
                if(i == 1) dp[i] = dp[i-1]+1;
                else dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[size-1];

    }
}

