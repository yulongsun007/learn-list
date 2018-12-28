package win.yulongsun.demo.interv.剑指Offer.链表中倒数第k个节点;

import org.junit.Test;

/**
 * Created by : yulongsun
 * Date on : 16/10/22
 * Desc : 链表中倒数第k个节点
 */
public class Solution {


    /**
     * 题目描述
     * 输入一个链表，输出链表中倒数第k个节点。链表从1开始计数
     *
     * ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
     * 解题思路：
     * 1. 一般思路：从链表头走到链表尾部，然后从链表尾倒着走k个节点。
     *            但是，由ListNode知道，链表是单链表，所以不能这么做。
     * 2. 两次走：第一次走一遍，知道链表的长度n。
     *           第二次走（n-k+1）步，就是
     * 3. 一步走：两个指针，No1指针往前走k－1步，当走第k步的时候，No2指针同时开始走，那么No1和No2指针之间始终相差k－1步，
     * 也就是说，当No1指针走到结尾的时候，No2指针正好走到正数n-(k-1)=n-k+1步，也是倒数第k步
     *
     * 注意：隐藏条件K小于链表长度
     *
     *
     * 代码如下：
     */
    public ListNode searchK(ListNode head,int k) {
        ListNode no1 = head;
        ListNode no2 = head;
        int count = 0;
        while (no1.getNext() != null) {
            count++;
            no1 = no1.getNext();
            // 当no1走第k步时 no2也同时走
            if (count >= k) {
                no2 = no2.getNext();
            }
        }
        if (k > count) {
            throw new RuntimeException("k大于链表长度");
        }
        return no2;
    }

    @Test
    public void testSearchK(){
        //init
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        node1.setNext(node2);
        node1.setValue(1);
        node2.setNext(node3);
        node2.setValue(2);
        node3.setNext(node4);
        node3.setValue(3);
        node4.setNext(node5);
        node4.setValue(4);
        node5.setNext(node6);
        node5.setValue(5);
        node6.setValue(6);

        ListNode listNode = null;
        listNode = searchK(node1, 1);
        System.out.println(listNode.getValue());

    }

}


class ListNode{
    private int value;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
