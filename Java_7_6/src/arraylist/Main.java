package arraylist;

public class Main {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.display();
        myArrayList.add(12);
        myArrayList.addHead(23);
        myArrayList.addPos(1,27);
        myArrayList.addHead(56);
        myArrayList.display();
    }

}
