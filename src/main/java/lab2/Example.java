package lab2;

public class Example {
    public static void main(String[] args) throws Exception {
        CircularLinkedList list = new CircularLinkedList();
        //list is empty
        //use length() method
        System.out.println("Length of empty list: " + list.length());

        //use append() and insert() methods
        list.append('a');
        list.append('b');
        list.append('d');
        list.append('b');
        list.insert('c', 2);
        System.out.print("List after appending and insertion: " );
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        System.out.println("List length: " + list.length());

        //use delete() and deleteAll() methods
        char element = list.delete(2);
        System.out.println("Delete element with index 2: " + element);
        System.out.print("List after deleting " + element + " element: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        list.deleteAll('b');

        System.out.print("List after deleting all 'b' elements: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        list.deleteAll('e'); //nothing change

        //use get() method
        System.out.println("Get element with index 0 from list: " + list.get(0));

        //use clone() and reverse() methods
        CircularLinkedList newList = new CircularLinkedList();
        list.append('h');
        list.append('e');
        list.append('l');
        list.append('l');
        list.append('o');
        System.out.println("newList length: " + newList.length());
        newList = list.clone();
        System.out.print("newList after cloning: ");
        for (int i = 0; i < newList.length(); i++) {
            System.out.print(newList.get(i) + " ");
        }
        System.out.print("\n");
        newList.reverse();
        System.out.print("List: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        System.out.print("newList after reverse: ");
        for (int i = 0; i < newList.length(); i++) {
            System.out.print(newList.get(i) + " ");
        }
        System.out.print("\n");

        //use findFirst() and findLast() methods
        list.insert('e', 0);
        list.insert('e', 2);
        list.insert('e', 4);
        list.append('e');
        System.out.print("List: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        System.out.println("Use findFirst() for 'e' element. Index is " + list.findFirst('e'));
        System.out.println("Use findLast() for 'e' element. Index is " + list.findLast('e'));

        //use extend() and clear() methods
        System.out.print("List: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        System.out.print("newList: ");
        for (int i = 0; i < newList.length(); i++) {
            System.out.print(newList.get(i) + " ");
        }
        System.out.print("\n");
        list.extend(newList);
        System.out.print("List after extending elements from newList: ");
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        newList.clear();
        System.out.print("newList after clear: ");
        for (int i = 0; i < newList.length(); i++) {
            System.out.print(newList.get(i) + " ");
        }
        System.out.print("\n");
    }
}
