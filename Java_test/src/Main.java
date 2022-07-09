
public class Main {

    public static void main(String[] args) {

    }
        // 反转一个单链表
            /*
            public ListNode reverseList(ListNode head) {

            if(head == null || head.next == null) {
                return head;
            }
            ListNode cur = head.next;
            head.next = null;

            while(cur != null) {
                ListNode curList = cur.next;
                cur.next = head;
                head = cur;
                cur = curList;
            }

            return head;

        }
        */

        // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
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

  /*  public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode forward = head;
        ListNode back = head;
        while(forward != null && forward.next != null) {

            forward = forward.next.next;
            back = back.next;

        }

        return back;
    }*/

    // 输入一个链表，输出该链表中倒数第k个结点
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


    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 /*   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode node = new ListNode(-1);
        ListNode cur = node;
        ListNode forward = list1;
        ListNode back = list2;

        while(forward != null && back != null) {
            if(forward.val > back.val) {
                cur.next = back;
                back = back.next;
            } else {
                cur.next = forward;
                forward = forward.next;
            }
            cur = cur.next;
        }

        // forward == null || back == null了
        if(forward == null) {
            cur.next = back;
        }
        if(back == null) {
            cur.next = forward;
        }
        return node.next;
    }*/

    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    /*public ListNode partition(ListNode head, int x) {
        // write code here
        if(head == null || head.next == null) {
            return head;
        }

        ListNode backHead = null;
        ListNode backEnd = null;
        ListNode forwardHead = null;
        ListNode forwardEnd = null;
        ListNode cur = head;

        while(cur != null) {
            if(cur.val < x) {
                if(backHead == null) {
                    backHead = cur;
                    backEnd = backHead;
                } else {
                    backEnd.next = cur;
                    backEnd = backEnd.next;
                }
            } else {
                if(forwardHead == null) {
                    forwardHead = cur;
                    forwardEnd = forwardHead;
                } else {
                    forwardEnd.next = cur;
                    forwardEnd = forwardEnd.next;
                }
            }
            cur = cur.next;
        }

        // 遍历一 遍了，判断backHead == null,
        //forwardHead == null,和最后一个节点置为空,连接两个链表
        if(backHead == null) {
            return forwardHead;
        }
        if(forwardHead == null) {
            return backHead;
        }
        backEnd.next = forwardHead;
        forwardEnd.next = null;
        return backHead;
    }*/

    // 链表的回文结构
    /*
        public boolean chkPalindrome(ListNode head) {

        ListNode forward = head;
        ListNode back = head;
        while(forward != null && forward.next != null) {
            forward = forward.next.next;
            back = back.next;
        }

        // back是中心节点 以back为头结点翻转
        ListNode cur = back.next;
        back.next = null;

        while(cur != null) {
            ListNode curList = cur.next;
            cur.next = back;
            back = cur;
            cur = curList;
        }
        while(back != head && back != null && head != null) {
            if(back.val != head.val) {
                return false;
            }
            back = back.next;
            head = head.next;
        }
        return true;
    }
    */

    // 输入两个链表，找出它们的第一个公共结点
    /*
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = listNodeLength(curA);
        int lengthB = listNodeLength(curB);
        int listNodeLack = lengthA - lengthB;
        if(listNodeLack > 0) {
            while(listNodeLack != 0) {
                listNodeLack--;
                curA = curA.next;
            }
        } else {
            while(listNodeLack != 0) {
                listNodeLack++;
                curB = curB.next;
            }
        }
        while(curA != curB && curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        if(curA == null || curB == null) {
            return null;
        }
        return curA;
    }

    public int listNodeLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    */
    // 给定一个链表，判断链表中是否有环
    /*
        public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        // 使用快慢指针，快指针一次两步，慢指针一次一步
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果相遇了代表有环，没相遇就美没环
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    */
}
