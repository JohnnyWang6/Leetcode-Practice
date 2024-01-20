package Leetcode_practiceDay02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
/*
3. 无重复字符的最长子串
        已解答
        中等
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

        示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

        示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        提示：
        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成

 */

//一、官方解题思路
class Solution1 {

    /*
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        // 右指针rightPoint，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动,maxLength为子串最大长度
        int rightPoint = -1, maxLength = 0;
        for (int i = 0; i < n; ++i) { //此处i表示每一个子串的起始索引
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符，因为每进行一次循环就相当于是把起始索引右移一位，因此可以删去上一个子串的起始索引
                set.remove(s.charAt(i - 1));
            }
            //判断从第i个索引开始一直检索到有重复字符为止，期间每检索一次，右指针rk移动一位。
            while (rightPoint + 1 < n && !set.contains(s.charAt(rightPoint + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rightPoint + 1));
                ++rightPoint;
            }
            // 第 i 到 第 rightPoint 个字符是一个极长的无重复字符子串
            maxLength = Math.max(maxLength, rightPoint - i + 1);
        }
        return maxLength;
    }
    */


    public int lengthOfLongestSubstring(String s){
        //定义HashSet存储每一个不重复的字符,算出s字符串的长度
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        //定义最大不重复子串的长度maxLength,和不断移动的右索引,起始值为-1,保证右索引始终是子串最后一位的索引。
        int maxLength = 0;
        int rightPoint = -1;
        //开始循环，i代表每一个子串的起始索引
        for(int i=0; i<n; i++){
            if(i!=0){
                //如果i!=0,则删去set中的s.charAt[i-1]这个字符，一直删到从起始索引开始到右索引为止没有与下一位字符重复的字符为止
                set.remove(s.charAt(i-1));
            }
            //当右索引小于s长度n并且该字符与子串前面的字符没有重复时，将其添加进set集合中，并且右索引移动一位
            while(rightPoint + 1 < n && !set.contains(s.charAt(rightPoint + 1))){
                set.add(s.charAt(rightPoint + 1));
                rightPoint++;
            }
            //每一轮大循环结束后进行最大子串长度比较
            maxLength = Math.max(maxLength, rightPoint - i + 1);
        }
        return maxLength;
    }


}

//二、大神解题思路
/*
class Solution{
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}
 */

public class The_longest_substring_without_repeated_characters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution1 slt = new Solution1();
        int ans = slt.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
