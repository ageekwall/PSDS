public class lc53dp {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = nums[0];
        int cur = nums[0];
        int prv = nums[0];
        if(n == 1) return prv;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            int tcur = Math.max(nums[i],prv+nums[i]);
            if(tcur > cur) {
                cur = tcur;
            }
            prv = tcur;
        }
        System.out.println(cur);
        int max = Integer.MIN_VALUE;
        for(int i =0; i< n; i++) {
            System.out.println(dp[i]);
            if(max <= dp[i]) max= dp[i];
        }
        return cur; //return dp[n-1]
    }
}
