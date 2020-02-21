package com.xyj.leetcode;

public class 删除链表中的节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
            while (first != null) {
                ListNode temp = first.next;
                first.next = newHead;
                newHead = first;
                first = temp;
            }
            return first;
        }

        //判断列表是否有环
        public boolean huan(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode man = head;
            ListNode kuai = head.next;
            while (kuai != null && kuai.next != null) {
                man = man.next;
                kuai = kuai.next.next;
                if (kuai.equals(man)) {
                    return true;
                }
            }
            return false;
        }

        /*删除链表中等于给定值 val 的所有节点。

        示例:

        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5
         这里运用设置头节点解决麻烦
        */
        public ListNode removeElements(ListNode head, int val) {
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;
            ListNode prev = sentinel, curr = head;
            while (curr != null) {
                if (curr.val == val) {prev.next = curr.next;}
                else{ prev = curr;}
                curr = curr.next;
            }
            return sentinel.next;
        }
        }

    }




