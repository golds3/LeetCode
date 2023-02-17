/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 *
 * https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 *
 * algorithms
 * Hard (68.73%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    20.2K
 * Total Submissions: 29.4K
 * Testcase Example:  '"zzazz"'
 *
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 
 * 「回文串」是正读和反读都相同的字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int LCCS = longestPalindromeSubseq(s);
        int n = s.length();
        return n-LCCS;

    }
    public int longestPalindromeSubseq(String s) {
        int n =s.length();
        //dp[i][j]表示s【i——j】的最长回文子序列
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                if(i==j){
                    dp[i][j] =1;
                }
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j = i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

}
// @lc code=end

