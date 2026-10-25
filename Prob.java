import java.util.*;

public class Prob {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode fast = head.next;
        int count = 1;
        ArrayList<Integer> arr = new ArrayList<>();

        while (fast != null) {
            
            if (count != 1) {
                if (prev.val > curr.val && curr.val < fast.val) {
                    arr.add(count);
                }
                if (prev.val < curr.val && curr.val > fast.val) {
                    arr.add(count);
                }
            }
            prev = prev.next;
            curr = curr.next;
            fast = fast.next;
            count++;

        }
        int max = arr.get(arr.size()-1) - arr.get(0);
        int min = arr.get(arr.size()-1) - arr.get(arr.size()-2);
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode head1 = new ListNode(1, head);
        ListNode head2 = new ListNode(5, head1);
        ListNode head3 = new ListNode(2, head2);
        ListNode head4 = new ListNode(1, head3);
        ListNode head5 = new ListNode(3, head4);
        ListNode head6 = new ListNode(5, head5);
        int[] res = nodesBetweenCriticalPoints(head6);
        for (int i: res) {
            System.out.println(i);
        }

    }
}
