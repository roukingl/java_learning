package javaAPI.langAPI;

public class Learning {

    public static void main(String[] args) {
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        String s1 = new String("dingruihangr");
        String s2 = new String(ch);
        String str = s1.replaceFirst("gr", "zx");
        System.out.println("str = " + str);

    }

}
