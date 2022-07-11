
public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.display();
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(23);
        myLinkedList.addLast(34);
        myLinkedList.addFirst(456);
        myLinkedList.addLast(768);
        myLinkedList.display();
        myLinkedList.addIndex(1, 36);
        myLinkedList.addIndex(3, 36);
        myLinkedList.addIndex(2, 36);
        myLinkedList.display();
    }
}
