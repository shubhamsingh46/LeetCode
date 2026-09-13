class Solution {
    public int  coin(int[] coins, int idx, int target, int error, int[][] dp){
        if(target == 0) return 0;
        if(target < 0 || idx < 0) return error;
        if(dp[idx][target] != -1) return dp[idx][target];
        int take = error;
        if(target >= coins[idx]){
            int part = coin(coins, idx, target - coins[idx], error, dp);
            if(part <= error) take = 1 + part;
        }
        int skip = coin(coins, idx - 1, target, error, dp);
        dp[idx][target] = Math.min(take, skip);
        return dp[idx][target];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] x : dp) Arrays.fill(x, -1);
        int error = amount + 1;
        int res = coin(coins, coins.length - 1, amount, error, dp);
        return (res != error)? res : -1;
    }
}