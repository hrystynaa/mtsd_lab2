package lab2;

public class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int len = 0;
        if (isEmpty()) return len;
        Node cur = head;
        do {
            len++;
            cur = cur.next;
        } while (cur != head);
        return len;
    }

    public void append(char element) {
        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
            node.next = head;

        } else {
            Node cur = head;
            while (cur.next != head) cur = cur.next;
            cur.next = node;
            node.next = head;
        }
    }

    public void insert(char element, int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        Node node = new Node(element);
        if (index == 0) {
            if (isEmpty()) append(element);
            else {
                Node cur = head;
                do {
                    cur = cur.next;
                } while (cur.next != head);
            node.next = head;
            head = node;
            cur.next = head;
            }
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            if (cur.next == head) throw new Exception("Error. Index is out of range.");
            else cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public char delete(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (isEmpty()) throw new Exception("Error. List is empty.");
        if (index == 0) {
            Node cur = head;
            Node delNode = head;
            if (cur.next == head) head = null;
            else {
                do {
                    cur = cur.next;
                } while (cur.next != head);
                head = head.next;
                cur.next = head;
            }
            return delNode.data;
        }
        Node prev = null;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next != head) {
                prev = cur;
                cur = cur.next;
            }
            else throw new Exception("Error. Index is out of range.");
        }
        prev.next = cur.next;
        return cur.data;
    }

    public void deleteAll(char element) {
        if (isEmpty()) {
            return;
        }
        while (head.data == element) {
            if (head.next == head) {
                head = null;
                return;
            } else {
                Node cur = head;
                do {
                    cur = cur.next;
                } while (cur.next != head);
                head = head.next;
                cur.next = head;
            }
        }
        Node prev = head;
        Node cur = head.next;

        while (cur != head) {
            if (cur.data == element) {
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public char get(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (isEmpty()) throw new Exception("Error. List is empty.");
        if (index == 0) {
            return head.data;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next != head) cur = cur.next;
            else throw new Exception("Error. Index is out of range.");
        }
        return cur.data;
    }

    public CircularLinkedList clone() {
        CircularLinkedList linkedList = new CircularLinkedList();
        if (isEmpty()) return linkedList;
        Node cur = head;
        linkedList.append(cur.data);
        do {
            cur = cur.next;
            linkedList.append(cur.data);
        } while (cur.next != head);
        return linkedList;
    }

    public void reverse() {
        Node prev = null;
        Node cur = head;
        Node next = null;
        if(isEmpty()) return;
        do {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } while (cur != head);
        head = prev;
        cur.next = head;

    }

    public int findFirst(char element) {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        Node cur = head;
        while (cur.next != head) {
            if (cur.data == element) return index;
            index++;
            cur = cur.next;
        }
        return -1;
    }

    public int findLast(char element) {
        if (isEmpty()) {
            return -1;
        }
        int lastIndex = -1;
        int index = 0;
        Node cur = head;
        do {
            if (cur.data == element) lastIndex = index;
            cur = cur.next;
            index++;
        } while (cur != head);
        return lastIndex;
    }

    public void clear() {
        head = null;
    }

    public void extend(CircularLinkedList elements) {
        Node cur = elements.head;
        do {
            this.append(cur.data);
            cur = cur.next;
        } while (cur != elements.head);
    }
}