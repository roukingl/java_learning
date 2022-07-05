package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 牌组类
 */
public class Cards {

    // 花色数组
    private static final String[] suits = {"♠", "♥", "♣", "♦"};

    /**
     * 用来创建一个牌组，一共52张牌
     * @return 返回这个牌组的地址
     */
    public List<Card> buyCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 1; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card card = new Card(i, suits[j]);
                cards.add(card);
            }
        }
        return cards;
    }

    public void shuffle(List<Card> cards) {
        for (int i = cards.size() - 1; i > 0; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(cards, index, i);
        }
    }

    private void swap(List<Card> cards, int index, int i) {
        Card tmp = cards.get(i);
        cards.set(i, cards.get(index));
        cards.set(index, tmp);
    }

    public List<List<Card>> gamePerson(List<Card> cards) {

        List<Card> test1 = new ArrayList<>();
        List<Card> test2 = new ArrayList<>();
        List<Card> test3 = new ArrayList<>();

        List<List<Card>> tests = new ArrayList<>();
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < tests.size(); j++) {
                tests.get(j).add(cards.remove(0));
            }
        }

        return tests;
    }

}
