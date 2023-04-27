package test;

public class Test {

    private int id;

    public void add() {
        System.out.println("test 执行" + this.id);
    }

    public Test(int id) {
        this.id = id;
    }

    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
