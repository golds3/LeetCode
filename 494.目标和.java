/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (49.11%)
 * Likes:    1448
 * Dislikes: 0
 * Total Accepted:    297.2K
 * Total Submissions: 605.5K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 
 * 
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 
 * 
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], target = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 0 
 * -1000 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //背包容量 
        //分成加法和减法，sum(加法)=x , sum(减法)=sum-x
        //x-(sum-x)=target 
        //x = (sum+target)/2
        //所以背包容量为x
        //dp[j] 容量为j的方法
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if((sum+target)%2==1) return 0;
        if(sum<Math.abs(target)) return 0;
        int weight = (sum+target)/2;
        // if(weight<0) weight = -weight;
        int[] dp =new int[weight+1];
        //base case
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            for(int j = weight;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[weight];
    }
}
// @lc code=end

