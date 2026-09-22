import java.util.*;

class Solution {

    public int func(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {

            int cost = cuts[j + 1] - cuts[i - 1]
                    + func(i, k - 1, cuts, dp)
                    + func(k + 1, j, cuts, dp);

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] newCuts = new int[m + 2];

        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[m + 2][m + 2];

        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(1, m, newCuts, dp);
    }
}