import com.company.Cats;
import com.company.Dogs;

public class Application {

    public static void main(String[] args) {

        /*Dogs dog = new Dogs("rodfjg",21, 324.32);

        System.out.println(dog);*/

        Cats cat = new Cats("adjf", 2);
        cat.setAge(18);
        cat.eat();
        System.out.println(cat);
    }


}
