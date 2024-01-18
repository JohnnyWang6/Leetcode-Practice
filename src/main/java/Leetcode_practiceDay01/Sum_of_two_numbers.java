package Leetcode_practiceDay01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sum_of_two_numbers {
    /*
    1. 两数之和
已解答
简单
提示
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     */
    public int[] twoSum(int[] nums, int target) {
        //1、创立一个输出结果的数组
        int result[] = new int[2];

        //2、new一个HashMap
        Map<Integer,Integer> map = new HashMap();

        //3、循环遍历nums数组，找出和为target的两个数字的下标
        for(int i=0; i<nums.length; i++){
            //定义一个中间值存储target和当前nums节点下的差
            int temp = target - nums[i];
            //判断这个差是否已经在map中有对应的键
            if(map.containsKey(temp)){ //如果有，表示找到了两个和为target的数，将其下标存入result
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
            //如果在map中没有对应的键，那就把这个nums[i]作为键，i作为值put到map里去
            map.put(nums[i],i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums=null;
        nums = sc.nextLine().split(" ");
        int[] num=new int[nums.length];
        for(int i=0;i<num.length;i++){
            num[i]=Integer.parseInt(nums[i]);
        }
        int target=sc.nextInt();
        Sum_of_two_numbers sotn = new Sum_of_two_numbers();
        System.out.println(Arrays.toString(sotn.twoSum(num,target)));
    }
}
