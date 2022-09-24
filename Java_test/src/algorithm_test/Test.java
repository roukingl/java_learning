package algorithm_test;

public class Test {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String str1 = "abbstabbabbstabbs";
        String str2 = "tabb";
        int index = kmp.searchStringKMP(str1, str2);
        System.out.println(str1.substring(index, index + str2.length()));
    }
}
