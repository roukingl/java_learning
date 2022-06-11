
public class Main {

    public static <E> void fun(E ch) {
        System.out.println(ch);
    }

    public static void main(String[] args) {

        String arr = "hello";

        fun(arr);

        Double a = 23.32;
        fun(a);

    }

}
