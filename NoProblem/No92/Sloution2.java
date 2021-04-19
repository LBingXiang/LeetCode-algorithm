/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /* 
        采用递归的方式实现。
        此方法相比喻迭代来说更加，难以理解，且空间复杂度为O(n)，但对于加深对递归理解来说，十分有用
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //base case
        if(left == 1) {
            return reverse(head, right);
        }

        //递归
        head.next = reverseBetween(head.next, left-1, right-1);

        //返回
        return head;
    }


    //反转一次需要返回的头结点
    ListNode cur = null;
    /*
        编写base的反转函数
    */
    public ListNode reverse(ListNode head, int n) {
        
        //base case
        if(n == 1) {
            //记录第n+1个节点
            cur = head.next;
            return head;
        }

        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverse(head.next, n - 1);

        head.next.next = head;

        // 让反转之后的 head 节点和后面的节点连起来
        head.next = cur;
        return last;
    }
}
