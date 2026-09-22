class Solution {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node curr = head;

        // Step 1: Insert cloned nodes
        while (curr != null) {

            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // Step 2: Set random pointers
        curr = head;

        while (curr != null) {

            if (curr.random != null)
                curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        // Step 3: Separate lists
        curr = head;
        Node cloneHead = head.next;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;

            if (copy.next != null)
                copy.next = copy.next.next;

            curr = curr.next;
        }

        return cloneHead;
    }
}