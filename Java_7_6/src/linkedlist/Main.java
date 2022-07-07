package linkedlist;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(4);
        myLinkedList.display();
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(12);
        myLinkedList.display();
        myLinkedList.addLast(164572);
        myLinkedList.display();
        myLinkedList.addIndex(1,786);
        myLinkedList.display();
        boolean con = myLinkedList.contains(12);
        System.out.println(con);
        myLinkedList.remove(786);
        myLinkedList.addLast(12);
        myLinkedList.addIndex(3, 12);
        myLinkedList.display();
        myLinkedList.removeAllKey(12);
        myLinkedList.display();
        myLinkedList.clear();

    }
}
