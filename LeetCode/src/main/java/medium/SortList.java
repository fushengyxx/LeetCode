package medium;


import common.ListNode;

/**
 * Created by yixinxin on 17/2/22.
 *
 * 148 SortList
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Subscribe to see which companies asked this question.
 * <p>
 * 如果待排序的元素存储在数组中，那么快速排序相对归并排序就有两个原因更快。
 * 一是，可以很快地进行元素的读取(相对于链表，数组的元素是顺序摆放的，而链表的元素是随机摆放的)
 * ，数组的partion这步就比链表的partion这步快。
 * 二是，归并排序在merge阶段需要辅助数组，需要申请O(N)
 * 的空间，申请空间也是需要时间的。而快排不需要额外申请空间。
 * 如果待排序的元素存储在链表中，快排的优点就变成了缺点。归并排序于是就速度更优了。
 *
 *
 *
 解题报告：就是对一个链表进行归并排序。
 主要考察3个知识点，
 知识点1：归并排序的整体思想
 知识点2：找到一个链表的中间节点的方法
 知识点3：合并两个已排好序的链表为一个新的有序链表

 归并排序的基本思想是：找到链表的middle节点，然后递归对前半部分和后半部分分别进行归并排序，最后对两个以排好序的链表进行Merge。

 代码：

 寻找中间节点（用快慢指针）
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode sortedHead = null;

        // 空间复杂度为1，原地排序
        // 快排
        if(head == null || head.next == null)
            return head;

        ListNode mid = getMidListNode(head);
        ListNode list2 = mid.next;
        mid.next = null;

        return mergeList(sortList(head), sortList(list2));
    }

    public ListNode getMidListNode(ListNode head){
        ListNode slow = head, fast = head;

        // slow走一步，fast走两步
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        // 循环每次只跑一个
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 != null ? list1 : list2;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3= new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(10);
        ListNode node8 = new ListNode(2);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        SortList sortList = new SortList();

        ListNode listNode = sortList.sortList(head);

        //  !listNode.next.equals(null) listNode若为null，则不能用.equals(null)
        while (listNode != null){
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }

    }

    /*public ListNode mergeSort(ListNode list1, ListNode list2){
        ListNode mergedList = list1;

        int count = 0;
        int temp = 0;
        ListNode temp1 = null;

        while(list1.next != null || list2.next != null) {
            if(list1.val > list2.val){
                temp = list1.val;
                list1.val = list2.val;
                list2.val = temp;

                list2 = list2.next;

                while(temp > list2.val){
                    temp1 = list1.next;
                    list1.next = list2.next;
                    list1 = list1.next;
                }

                list2 = list1.next;
                list1.next = temp1;
            }else{
                list1 = list1.next;
            }
        }
        return mergedList;
    }*/




    /*public ListNode quickSort(ListNode head, int count) {
        ListNode sortedHead = null;

        // 空间复杂度为1，原地排序
        // 快排

        int temp = 0;
        int headDate = head.val;

        if (count > 0) {

        }
        while (head.next != null) {
            count++;

            if (head.val > head.next.val) {
                temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
            }

            head = head.next;
        }

        sortedHead = head;

        return sortedHead;
    }*/
}
