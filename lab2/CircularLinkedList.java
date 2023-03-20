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
        Node cur = head;
        int len = 0;
        while (cur.next != head) len++;
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

//    Операцію вставки елементу на довільну позицію у списку. Нумерація елементів списку починається з 0.
//    def insert(element: Character, index: Integer) -> None
//    У випадку передачі некоректного значення позиції (наприклад, від’ємне число, або число, більше за кількість
//    елементів у списку) метод повинен генерувати виключну ситуацію

    public void insert(char element, int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        Node node = new Node(element);
        if (index == 0) {
            node.next = head;
            head = node;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next != head) cur = cur.next;
            else throw new Exception("Error. Invalid index.");
        }
        node.next = cur.next;
        cur.next = node;
    }

//    Операцію видалення елементу зі списку на вказаній позиції. Метод повинен повертати значення того елементу,
//    який видаляється. Нумерація елементів списку починається з 0.
//    def delete(index: Integer) -> Character
//    У випадку передачі некоректного значення позиції
//    (наприклад, від’ємне число, або число, більше за індекс останнього елементу списку)
//    метод повинен генерувати виключну ситуацію
    public char delete(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (index == 0) {
            head = head.next;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            if (prev.next != head) prev = prev.next;
            else throw new Exception("Error. Invalid index.");
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        return delNode.data;
    }

//    Операцію видалення елементів зі списку за значенням. Метод видаляє зі списку усі елементи,
//    які за значенням відповідають шуканому.
//    def deleteAll(element: Character) -> None
//    У випадку передачі елемента, який у списку відсутній, жодні зміни до списку не застосовуються.

    public void deleteAll(char element) {
        if (isEmpty()) {
            return;
        }
        while (head.data == element) {
            if (head.next == head) {
                head = null;
            } else {
                head = head.next;
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


//    Операцію отримання елементу списку на довільній позиції
//    def get(index: Integer) -> Character
//    У випадку передачі некоректного значення позиції
//    (наприклад, від’ємне число, або число, більше за індекс останнього елементу списку)
//    метод повинен генерувати виключну ситуацію

    public char get(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (index == 0) {
            return head.data;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next != head) cur = cur.next;
            else throw new Exception("Error. Invalid index.");
        }
        return cur.data;
    }


//    Операцію копіювання списку. При виклику повинен створити копію поточного списку та повернути її.
//    def clone() -> List

    public CircularLinkedList clone() {
        CircularLinkedList linkedList = new CircularLinkedList();
        if (isEmpty()) return linkedList;
        Node cur = head;
        do {
            linkedList.append(cur.data);
            cur = cur.next;
        } while (cur.next != head);
        return linkedList;
    }


//    Операцію обернення списку. Метод повинен змінити порядок елементів у поточному списку задом наперед.
//    Елемент, що був останнім стане першим, передостаннім — другим, … а перший — останнім.
//            def reverse() -> None

    public void reverse() {
        Node prev = null;
        Node cur = head;
        Node next = null;
        if(isEmpty()) return;
        while (cur != head) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        cur.next = head;

    }

//    Операцію пошуку елемента за значенням з голови списку. Метод повинен знайти перший елемент у списку,
//    що дорівнює шуканому та повернути його позицію. Нумерація елементів списку починається з 0.
//    У випадку відсутності шуканого елемента у списку, метод повертає -1
//    def findFirst(element: Character) -> Integer

    public int findFirst(char element) {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        Node cur = head;
        while (cur.next != head) {
            if (cur.data != element) return index;
            index++;
            cur = cur.next;
        }
        return -1;
    }




//    Операцію пошуку елемента за значенням з хвоста списку. Метод повинен знайти останній елемент у списку,
//    що дорівнює шуканому та повернути його позицію. Нумерація елементів списку починається з 0.
//    У випадку відсутності шуканого елемента у списку, метод повертає -1.
//    def findLast(element: Character) -> Integer


    public int findLast(char element) {
        if (isEmpty()) {
            return -1;
        }
        int lastIndex = -1;
        int index = 0;
        Node cur = head;
        while (cur != head) {
            if (cur.data != element) lastIndex = index;
            index++;
            cur = cur.next;
        }
        return lastIndex;
    }


//    Операцію очищення списку. Метод видаляє усі елементи списку.
//            def clear() -> None

    public void clear() {
        head = null;
    }

//    Операцію розширення списку. Метод приймає інший список та додає до поточного списку усі елементи останнього.
//    При цьому подальші зміни в другий список не повинні впливати на перший.
//    def extend(elements: List) -> None


    public void extend(CircularLinkedList elements) {
        Node cur = elements.head;
        while (cur.next != elements.head) {
            this.append(cur.data);
            cur = cur.next;
        }
    }
}