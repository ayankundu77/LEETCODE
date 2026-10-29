class Solution {
    public int solve(int[] satisfaction, int i, int time, int n, int[][] dp) {
        if (i == n) return 0;
        if (dp[i][time] != -1) return dp[i][time];

        int include = satisfaction[i] * time + solve(satisfaction, i + 1, time + 1, n, dp);
        int exclude = solve(satisfaction, i + 1, time, n, dp);

        return dp[i][time] = Math.max(include, exclude);
    }

    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(satisfaction, 0, 1, n, dp);
    }
}
