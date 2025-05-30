// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        if(n == 0) return 0;
        
        int[][] dp = new int[n][3];

        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
