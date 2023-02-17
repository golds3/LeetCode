/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (52.17%)
 * Likes:    1564
 * Dislikes: 0
 * Total Accepted:    350.2K
 * Total Submissions: 671.3K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        //物品的价值就是物品自身的重量！！
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        //dp[j] 背包容量为j时候，最大的价值（重量）
        int n = sum/2;
        int[] dp = new int[n+1];
        for(int i = 0;i<nums.length;i++){
            for(int j = n;j>=nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[n]==n;
    }   
}
// @lc code=end

