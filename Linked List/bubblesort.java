class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}


public void bubbleSortOptimized() {
    if (head == null || head.next == null) return;

    Node end = null;
    boolean swapped;

    do {
        swapped = false;
        Node prev = null;
        Node curr = head;

        while (curr.next != end) {
            Node nextNode = curr.next;

            if (curr.value > nextNode.value) {
                if (prev == null) {
                    head = nextNode;
                } else {
                    prev.next = nextNode;
                }

                curr.next = nextNode.next;
                nextNode.next = curr;

                swapped = true;
                prev = nextNode;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        end = curr; // largest element fixed
    } while (swapped);
}
