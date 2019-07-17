import java.util.concurrent.atomic.AtomicBoolean;

public class lc1025dp {

    public static void main(String[] args) {
        lc1025dp lc1025dp = new lc1025dp();
        System.out.println(lc1025dp.divisorGameNoDP(5));
    }
    public boolean divisorGameNoDP(int N) {
        
       if(N%2==0) {
           return true;
       }
       return false;
    }
    public boolean divisorGameDP(int N) {
        boolean dp[] = new boolean[N+1] ;
        dp[0] = false;
        dp[1] = false;
        dp[2] = true;
        for(int i = 3; i <= N; i++){
            dp[i] = false;
            for(int j = i-1; j > 0; j--) {
                if(i%j == 0 && dp[i-j]== false) {
                    dp[i] = true;
                    continue;
                }
            }
        }
        return dp[N];

    }



}
