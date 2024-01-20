package Leetcode_practiceDay02;

import java.util.Scanner;
/*
9. 回文数
已解答
简单
提示
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。
示例 1：
输入：x = 121
输出：true

示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
提示：
-231 <= x <= 231 - 1
进阶：你能不将整数转为字符串来解决这个问题吗？
 */
class Solution2 {
    //一、数字解法，算出从后面往前面新数字，位数不超过原数字位数的一半
    public boolean isPalindrome(int x) {
        int newN = 0; //从后往前的新数字，位数不超过原数字位数的一半
        //2、把一定不符合的数字先排除，比如说负数和最后一位数字为0的数，0除外。
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        while(x > newN){ //如果x还大于newN，则继续让新数字往前面走
            newN = newN * 10 + x % 10;
            x /= 10;
        }
        return x == newN || x == (newN / 10);
    }
    //二、字符串解法
    public boolean isPalindromeByString(int x){
        //1、先把该数字转换成字符串，设置起始索引和终止索引
        String s = x + "";
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class palindrome_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution2 slt2 = new Solution2();
        System.out.println(slt2.isPalindrome(x));
    }
}
