
public class Main {

    public static void main(String[] args) {

    }

        /*
        public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode forward = head;
        ListNode back = head;
        while (forward != null) {
            if (forward.next == null) {
                return back;
            }
            forward = forward.next;

            back = back.next;
            if (forward.next == null) {
                return back;
            }
            forward = forward.next;
        }

        return back;
    }
    */
    /*
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode forward = head;
        ListNode back = head;

        while (k != 0) {
            if(forward == null) {
                return null;
            }
            forward = forward.next;
            k--;
        }

        while (forward != null) {
            forward = forward.next;
            back = back.next;
        }
        return back;
    }
    */
}
