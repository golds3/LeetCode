/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 *
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (70.78%)
 * Likes:    2012
 * Dislikes: 0
 * Total Accepted:    315.8K
 * Total Submissions: 446.2K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        //关键是看二叉树的形状！而不要关注具体的节点数值是否相同
        int[] dp = new int[n+1];
        //dp[i] i个元素的二叉搜索树的种树
        dp[0] = 1;
        dp[1] = 1;
        //选择--选谁作为头结点
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j]; //j作为头结点---搜索树，左节点就有j-1个，右节点就是i-j个！！！
            }
        }
        return dp[n];
    }
}
// @lc code=end

