package 程序员面试金典.链表中倒数第k个结点;

import org.junit.Test;

/**
 * Created by : yulongsun
 * Date on : 2016/9/9
 * Desc : 链表中倒数第k个结点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
//    public ListNode FindKthToTail(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//
//        int length = 1;
//        ListNode node = head;
//        while (node.next != null) {
//            length++;
//            node = node.next;
//        }
//
//        int newK = length - k;
//        node = head;
//        for (int i = 0; i < length; i++) {
//            if (i == newK) {
//                break;
//            }
//            node = node.next;
//        }
//        return node;
//    }


    @Test
    public void testFindKthToTail() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ListNode node = FindKthToTail(ln1, 1);
        System.out.println(node.val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = null, p = null;
        //两个指针都指向头结点
        p = head;
        pre = head;
        //记录k值
        int a = k;
        //记录节点的个数
        int count = 0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while (p != null) {
            p = p.next;
            count++;
            if (k < 1) {
                pre = pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < a) return null;
        return pre;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
