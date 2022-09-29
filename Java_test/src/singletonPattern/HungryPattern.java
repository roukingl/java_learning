package singletonPattern;

public class HungryPattern {

    private static HungryPattern hungryPattern = new HungryPattern();

    private HungryPattern() {

    }

    public HungryPattern getHungryPattern() {
        return hungryPattern;
    }
}
