package Leetcode_practiceDay01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sum_of_two_numbers {
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
