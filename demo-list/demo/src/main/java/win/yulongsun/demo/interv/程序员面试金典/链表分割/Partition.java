package win.yulongsun.demo.interv.程序员面试金典.链表分割;

import org.junit.Test;

/**
 * Created by sunyulong on 2016/11/18.
 * 链表分割
 */
public class Partition {

    /**
     * http://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?tpId=8&tqId=11004&rp=1&ru=/ta/cracking-the-coding-interview&qru=/ta/cracking-the-coding-interview/question-ranking
     * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
     * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
     *
     * @param pHead
     * @param x
     * @return
     */
    public ListNode partition(ListNode pHead, int x) {
        //思路：
        //1.用两个链表来存：小链表和大链表
        //2.最后将两个链表合并
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;//cur指针指向头节点的下一个节点
        ListNode sHead = new ListNode(-1);
        ListNode bHead = new ListNode(-1);
        ListNode sTmp = sHead;//临时变量，指向head
        ListNode bTmp = bHead;//临时变量，指向head
        while (cur != null) {
            if (cur.val < x) {
                sTmp.next = new ListNode(cur.val);//新建下一个节点，并指向这个节点
                sTmp = sTmp.next;//移动tmp指针。指向下一个节点
            } else {
                bTmp.next = new ListNode(cur.val);
                bTmp = bTmp.next;
            }
            cur = cur.next;
        }
        cur = sHead;//将cur指针指向小链表头指针
        //遍历，找到小链表的最后一个节点
        while (cur.next != null && cur.next.val != -1) {
            cur = cur.next;
        }
        //大小链表合并
        cur.next=bHead.next;
        return sHead.next;
    }

    @Test
    public void testPartition() {
        ListNode pHead = new ListNode(0);//不能是-1
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        pHead.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode _pHead = partition(pHead, 9);
        while (_pHead.next != null) {
            _pHead = _pHead.next;
            System.out.println(_pHead.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
