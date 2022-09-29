package singletonPattern;

public class LazyPattern {

    private static LazyPattern lazyPattern;

    private LazyPattern() {

    }

    public LazyPattern getLazyPattern() {
        if (lazyPattern == null) {
            synchronized(this) {
                if (lazyPattern == null) {
                    lazyPattern = new LazyPattern();
                }
            }
        }
        return lazyPattern;
    }
}
