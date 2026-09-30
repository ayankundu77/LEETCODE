class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        long after[][] = new long[2][k+1];
        long curr[][] = new long[2][k+1];
        for(int idx=0;idx<n;idx++){
            for(int buy=0;buy<2;buy++){
                curr[buy][0]=0;
            }
        }
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int maxT=1;maxT<=k;maxT++){
                    long profit = 0;
                    if(buy==1) profit = Math.max(-prices[idx]+after[0][maxT],after[1][maxT]);
                    else profit = Math.max(prices[idx]+after[1][maxT-1],after[0][maxT]);
                    curr[buy][maxT]=profit;
                }
            }
            after=curr;
        }
        return (int)after[1][k];
    }
}