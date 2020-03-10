package swu.xl.algorithm.code_03_10.experiment_3;

public class Solution {
    /**
     * leetcode P206 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;

        while (cur != null){
            //保存指向下一个
            ListNode temp = cur.next;

            //当前的指向指向结果
            cur.next = result;

            //结果的指向指向当前的指向
            result = cur;

            //当前的指向指向下一个
            cur = temp;
        }

        return result;
    }
}

class ListNode {
    int val;

    //赋值链表的
    ListNode(int x) {
        val = x;
    }

    // 下一个链表对象
    ListNode next;
}