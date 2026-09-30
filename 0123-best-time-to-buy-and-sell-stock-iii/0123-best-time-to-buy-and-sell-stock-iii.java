class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        long dp[][][] = new long[n+1][2][3];
        for(int idx=0;idx<n;idx++){
            for(int buy=0;buy<2;buy++){
                dp[idx][buy][0]=0;
            }
        }
        for(int buy=0;buy<2;buy++){
            for(int maxT=0;maxT<3;maxT++){
                dp[n][buy][maxT]=0;
            }
        }
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int maxT=1;maxT<3;maxT++){
                    long profit = 0;
                    if(buy==1) profit = Math.max(-prices[idx]+dp[idx+1][0][maxT],dp[idx+1][1][maxT]);
                    else profit = Math.max(prices[idx]+dp[idx+1][1][maxT-1],dp[idx+1][0][maxT]);
                    dp[idx][buy][maxT]=profit;
                }
            }
        }
        return (int)dp[0][1][2];
    }
}