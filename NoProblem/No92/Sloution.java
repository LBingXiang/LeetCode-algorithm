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

    /**
        迭代实现：具体思路是先寻找left-1 个节点, 然后循环遍历left -> right 
        最后处理边界问题
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //表明不需要交换
        if(left == right) {
            return head;
        }
        
        //设置反转的前半部分尾节点,当left == 1为null
        ListNode h = (left == 1) ? null : head;
        for(int i = 1 ; i < left - 1; i++) {
            h = h.next;
        }

        //反转left -> right
        ListNode pre = (left == 1) ? head : h.next;
        ListNode cur = pre.next;
        ListNode next = null;

        for(int i = left; i < right; i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //当起点为1的特殊情况
        if(left == 1) {
            head.next = next;
            return pre;
        } else {
            h.next.next = next;
            h.next = pre;
            return head;
        } 
    }
}
