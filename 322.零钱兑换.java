/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
                dp[0] = 0;
                for (int i = 0; i < coins.length; i++) {
                    //正序遍历：完全背包每个硬币可以选择多次
                    for (int j = coins[i]; j <= amount; j++) {
                        //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                        if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                            //选择硬币数目最小的情况
                            dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                        }
                    }
                }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
// @lc code=end

