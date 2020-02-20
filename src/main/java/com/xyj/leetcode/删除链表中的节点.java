package com.xyj.leetcode;

public class 删除链表中的节点 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

        //反转链表
        public ListNode reverseList(ListNode first) {
           /* if(first == null||first.next == null){return first;}
            ListNode aa = reverseList(first.next);
            first.next.next = first;
            first.next = null;
            return aa;*/
           ListNode newHead = null;
           while(first != null){
              ListNode temp = first.next;
              first.next = newHead;
              newHead = first;
              first = temp;
           }
            return first;
        }
    }
}
