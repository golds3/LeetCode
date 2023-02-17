/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode.cn/problems/jump-game-ii/description/
 *
 * algorithms
 * Medium (45.15%)
 * Likes:    1881
 * Dislikes: 0
 * Total Accepted:    425K
 * Total Submissions: 941.4K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        //贪心 每次在最远处起跳
        int curRange = 0;//这里就是为了跳到i-2后不需要+1步
        int nextRange = 0;
        int count = 0;
        //题目说一定能到达，所以到len-1即可
        for(int i =0;i<nums.length-1;i++){
            nextRange = Math.max(nextRange,i+nums[i]);
            if(i>=curRange){
                count++;
                curRange = nextRange;
            }
        }
        return count;
    }
}
// @lc code=end

