public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //This Logic can solve for any Input of any size 
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to print the list (for testing) - Given in the SOP
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    //Given code in the SOP
    public static void main(String[] args) {
        //Test case 
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        LinkedListAddition solution = new LinkedListAddition();
        printList(solution.addTwoNumbers(l1, l2)); 

        // Here I added an Extra Test case for 2 Digit numbers, Since the Logic(addTwoNumbers Method) can pass any Testcase.
        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(9);

        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(6);

        printList(solution.addTwoNumbers(l3, l4)); // Expected Output: 5 6 1 (Represents 165)
    }
}

/*  Program Output:  7 0 8     (For the Given Test Case)
    Expected Output: 7 0 8     (For the Given Test Case)

    Additional Test Case Output: 5 6 1  (For 69 + 96 = 165)
*/
