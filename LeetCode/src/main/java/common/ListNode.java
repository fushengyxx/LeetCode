package common;

/**
 * Created by yixinxin on 17/2/22.
 *
 * Definition for singly-linked list.
 *
 *  访问权限    同一类中    同一包中    不同包的子类      不同包的非子类
 *  private     Yes
 *  default     Yes         Yes
 *  protected   Yes         Yes         Yes
 *  public      Yes         Yes         Yes             Yes
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }
}
