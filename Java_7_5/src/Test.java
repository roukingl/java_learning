import java.util.List;

public class Test {

    public static void main(String[] args) {
        Cards cards = new Cards();
        List<Card> cards1 = cards.buyCards();

        System.out.println(cards1);
        System.out.println("洗牌 ");
        cards.shuffle(cards1);
        System.out.println(cards1);
        System.out.println("发牌 ");
        List<List<Card>> tests = cards.gamePerson(cards1);
        for (int i = 0; i < tests.size(); i++) {
            System.out.println("第" + (i + 1) + "个人的牌: " + tests.get(i));
        }

    }

}
