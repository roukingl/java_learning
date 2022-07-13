import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public int[] elam = new int[10];

    public static void main(String[] args) {
        elam = Arrays.copyOf(elam, 2 * elam.length);
    }

}
