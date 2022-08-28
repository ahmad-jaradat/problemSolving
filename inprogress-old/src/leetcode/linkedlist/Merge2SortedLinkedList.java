package leetcode.linkedlist;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */
public class Merge2SortedLinkedList {

    private static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode mergeHead = list1.val < list2.val ? list1 : list2;
        ListNode mergePtr = mergeHead;

        if (mergePtr == null)
            return null;
        if (mergeHead == list1)
            list1 = list1.next;
        else
            list2 = list2.next;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergePtr.next = list1;
                list1 = list1.next;
            } else {
                mergePtr.next = list2;
                list2 = list2.next;
            }
            mergePtr = mergePtr.next;
        }

        if (list1 != null)
            mergePtr.next = list1;
        else if (list2 != null)
            mergePtr.next = list2;
        return mergeHead;
    }

    /*
     * Faster solution
     */
    private static ListNode mergeRec(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeRec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeRec(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        System.out.println(merge(new ListNode(1).n(2).n(4), new ListNode(1).n(3).n(4)));
        System.out.println(merge(null, new ListNode(0)));
        System.out.println(merge(new ListNode(0), null));
        System.out.println(mergeRec(new ListNode(1).n(2).n(4), new ListNode(1).n(3).n(4)));
        System.out.println(mergeRec(null, new ListNode(0)));
        System.out.println(mergeRec(new ListNode(0), null));
    }
}
