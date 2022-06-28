
class Demo<T extends Comparable<T>> {

    public T findMaxVal(T[] array) {
        T tmp = array[0];

        for (int i = 0; i < array.length; i++) {
            if (tmp.compareTo(array[i]) < 0) {
                tmp = array[i];
            }
        }




        return tmp;
    }
}

public class Main {

    public static void main(String[] args) {

        Demo<Integer> test = new Demo();

        System.out.println("hid");
        System.out.println("hid");
        System.out.println("hid");

        Integer[] arr = {12, 32, 45, 67};
        System.out.println(test.findMaxVal(arr));
    }
}
