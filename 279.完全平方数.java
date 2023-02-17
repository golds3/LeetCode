import java.util.List;

import org.omg.CORBA.INTERNAL;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (65.76%)
 * Likes:    1546
 * Dislikes: 0
 * Total Accepted:    355.8K
 * Total Submissions: 540.9K
 * Testcase Example:  '12'
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11
 * 不是。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        //d[j]和为j的最少完全平方数
        //构造物品
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i*i<=n){
                nums.add(i);
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i<nums.size();i++){
            for(int j = 0;j<=n;j++){
                if(j-nums.get(i)*nums.get(i)>=0&&dp[j-nums.get(i)*nums.get(i)]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-nums.get(i)*nums.get(i)]+1);
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

