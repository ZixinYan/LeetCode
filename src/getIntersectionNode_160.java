/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        HashSet<ListNode> set = new HashSet();
        while (pA != null) {
            set.add(pA);
            pA = pA.next;
        }
        while (pB != null) {
            if (set.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }
}

// faster
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //计算两个链表的长度差
        ListNode A=headA;
        ListNode B=headB;
        while(A!=null&&B!=null){
            A=A.next;
            B=B.next;
        }
        while(A!=null){
            A=A.next;
            headA=headA.next;
        }
        while(B!=null){
            B=B.next;
            headB=headB.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}