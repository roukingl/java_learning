class Base{

    public Base(String s){
        System.out.print("B");
    }
}

public class Main extends Base{

    public Main (String s) {
        super("sdf");
        System.out.println("fhhvh");
        System.out.print("D");
    }

    public static void main(String[] args){

        new Main("C");

    }

}