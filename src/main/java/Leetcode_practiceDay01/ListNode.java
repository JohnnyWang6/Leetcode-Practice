package Leetcode_practiceDay01;

/*
2. 两数相加
已解答
中等
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */
public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //1、new一个head作为开始的、也是最后结果的头节点，tail作为一直在变化、前进的动态节点，也是最后结果的尾节点。他们一开始都是null.
            ListNode head = null, tail = null;
            //2、定义进位值carry，代表每次两个链表相加时进了多少位。比如5+6=11，carrt=1，刚开始进位值为0。
            int carry = 0;
            //3、循环两个链表，只要有一个链表所指节点不为0就执行循环里的代码
            while(l1 != null || l2 != null){
                //判断当前链表所指节点是否不为null,如果是，则把当前节点的值赋给n1或n2
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                //sum是两个链表当前所指节点的值的和(也加上了上次计算中的carry值)
                int sum = n1 + n2 + carry;
                //判断头节点是否为null
                if(head == null){ //如果是，则表示这是第一次循环，为头节点和动态节点添加值，值应该为：对和取余后的值。比如：5+6=11 值=11%10=1。
                    head = tail = new ListNode(sum % 10);
                }else{ //如果不是，则直接给动态节点前进一个后的节点添加值。然后把动态节点前进一位。
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                //计算结束后carry的值等于：和/10, 比如：5+6=11 ，carry=11/10;
                carry = sum/10;
                //判断l1、l2当前是否不为null
                if(l1 != null){ //如果是，那就把l1、l2前进一个节点
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
                //循环结束
            }
            //判断循环结束之后carry是否大于0
            if(carry > 0){ //如果是，则把carry的值赋给尾节点再前进一位的节点。
                tail.next = new ListNode(carry);
            }
            //最后返回头节点，头节点所指可以覆盖其地址之后所有的节点。
            return head;
        }
    }

    public static void main(String[] args) {
        //省略键入两个链表的过程
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        //ListNode l1 = [2,4,3];
        //ListNode l2 = [5,6,4];
        //ListNode result = new Solution(l1,l2);

    }
}

