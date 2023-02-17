/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 *
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (65.90%)
 * Likes:    508
 * Dislikes: 0
 * Total Accepted:    103K
 * Total Submissions: 156.2K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 
 * 每步 可以删除任意一个字符串中的一个字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 
 * 
 * 示例  2:
 * 
 * 
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        //n+m-2LCS
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return n+m-2*dp[n][m];

    }
}
// @lc code=end

