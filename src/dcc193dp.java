/*
You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to advance to the end. You can advance at most, the number of steps that you're currently on. Determine whether you can get to the end of the array.

For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
 */

public class dcc193dp {

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 1, 0, 0};
        advanceToReachEnd(array);
    }

    public static void  advanceToReachEnd(int [] array) {
//        int array [] = new  int[20];
        int dp[] = new int[20];
        int n = array.length;
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = i-1; j >= 0; j-- ) {
                if(dp[j] == 1 && array[j] >= i-j) {
                    dp[i] = 1;
                }
            }
        }
        System.out.println(dp[n]);
      }

}
