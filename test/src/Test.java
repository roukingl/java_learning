class Constants {

    // 编号中允许出现的字母顺序
    static final String ALPHABET = "ABCDEFGHIJKLMNPQRSTUVWXYZ";

    // 允许出现的数字顺序
    static final String DIGIT = "023456789";

    // 单元间的间隔符
    static final char SEPARATOR = '-';

    // 每个单元的长度
    static final int UNIT_LENGTH = 4;

    // 一个单元允许出现的最大编号
    static final String MAX_VALUE = "9999";
}

class Utils {
    static boolean isValidId(String id) {
        // 编号不能为空，且长度至少为4
        if (id == null || id.length() < Constants.UNIT_LENGTH) {
            return false;
        }
        // 编号只能包含大写字母，数字和分隔符
        for (char c : id.toCharArray()) {
            if (!Character.isUpperCase(c) && !Character.isDigit(c) && c != Constants.SEPARATOR) {
                return false;
            }
        }
        // 编号不能包含字母O 数字1
        if (id.contains("O") || id.contains("1")) {
            return false;
        }
        // 编号中每个单元的长度必须为4
        for (String unit : id.split(String.valueOf(Constants.SEPARATOR))) {
            if (unit.length() != Constants.UNIT_LENGTH) {
                return false;
            }
        }
        // 编号中除了第一个单元外，其他单元之前必须有分隔符
        for (int i = Constants.UNIT_LENGTH; i < id.length(); i += Constants.UNIT_LENGTH + 1) {
            if (id.charAt(i) != Constants.SEPARATOR) {
                return false;
            }
        }
        // 如果以上条件都满足，返回true
        return true;
    }

    static String incrementUnit(String unit) {
        // 如果单元为空，返回空
        if (unit == null) {
            return null;
        }
        // 如果单元等于最大值，抛出异常
        if (unit.equals(Constants.MAX_VALUE)) {
//            System.out.println("编号已超出最大范围");
//            return null;
            throw new RuntimeException("编号已超出最大范围");
        }
        // 下一个编码需要从最后一位开始增加
        char[] unitArr = unit.toCharArray();
        return addUnit(unitArr, Constants.UNIT_LENGTH - 1);
    }

    static String addUnit(char[] unitArr, int len) {
        // 单元最后一位为 9，需要往前进一位
        if (unitArr[len] == Constants.DIGIT.charAt(Constants.DIGIT.length() - 1)) {
            unitArr[len] = Constants.ALPHABET.charAt(0);
            addUnit(unitArr, len - 1);
        } else {
            // 单元最后一位不为 9，单独加 1即可
            // 但是最后一位是 Z时，需要变为 0
            if (unitArr[len] == Constants.ALPHABET.charAt(Constants.ALPHABET.length() - 1)) {
                unitArr[len] = Constants.DIGIT.charAt(0);
            } else {
                unitArr[len]++;
            }
        }
        return String.valueOf(unitArr);
    }

    static String getNextId(String id) {
        // 如果编号不合法，抛出异常
        if (!isValidId(id)) {
//            System.out.println("编号不合法");
//            return null;
            throw new RuntimeException("编号不合法");
        }
        // 如果编号只有一个单元，直接调用incrementUnit方法，返回结果
        if (id.length() == Constants.UNIT_LENGTH) {
            return incrementUnit(id);
        }
        // 如果编号有多个单元，将编号按照分隔符分割为数组，取出最后一个单元，调用incrementUnit方法，将结果替换原来的单元，将数组重新拼接为字符串，返回结果
        String[] units = id.split(String.valueOf(Constants.SEPARATOR));
        String lastUnit = units[units.length - 1];
        String nextUnit = incrementUnit(lastUnit);
        units[units.length - 1] = nextUnit;
        return String.join(String.valueOf(Constants.SEPARATOR), units);
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建一个已知编号
        String id = "A3AA-AKAK";
        // 调用getNextId方法，输出下一个编号
        System.out.println(Utils.getNextId(id));

        // 将抛出异常换成打印，创建几个不合法的编号试试
//        String id1 = "AAAAA-AAAA";
//        String id2 = "AAAA+AAAA";
//        String id3 = "AAAA-AAOA";
//        String id4 = "AAAA-AA1A";
//        String id5 = "AAAA-AA,A";
//        String id6 = "AAAA-AbDD";
//        String id7 = "AAAAAAAA";
//        String id8 = "AAAA-9999";
//        System.out.println("id1: " + Utils.getNextId(id1));
//        System.out.println("id2: " + Utils.getNextId(id2));
//        System.out.println("id3: " + Utils.getNextId(id3));
//        System.out.println("id4: " + Utils.getNextId(id4));
//        System.out.println("id5: " + Utils.getNextId(id5));
//        System.out.println("id6: " + Utils.getNextId(id6));
//        System.out.println("id7: " + Utils.getNextId(id7));
//        System.out.println("id8: " + Utils.getNextId(id8));


        // 创建几个在条件边缘的编号
        String id1 = "A999";
        String id2 = "AZ99";
        String id3 = "AAAA-A999";
        String id4 = "AAAA-AZ99";
        System.out.println("id1: " + Utils.getNextId(id1));
        System.out.println("id2: " + Utils.getNextId(id2));
        System.out.println("id3: " + Utils.getNextId(id3));
        System.out.println("id4: " + Utils.getNextId(id4));
    }
}

