package esay;

import common.ListNode;

/**
 * Created by yixinxin on 17/3/8.
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                current.next = l1; // .next, move forward
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;

        return fakeHead.next;
    }

    // recursive
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4= new ListNode(8);

        ListNode head2 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        head2.next = node6;
        node6.next = node7;
        node7.next = node8;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(head, head2);

        //  !.next.equals(null) result，则不能用.equals(null)
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }

    }
}
