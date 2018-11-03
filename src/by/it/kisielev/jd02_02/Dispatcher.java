package by.it.kisielev.jd02_02;

public class Dispatcher {
    static final int KSPEED = 100;
    private static volatile int buyersInMarket = 0;
    private static final int PLAN_COUNT = 100;
    private static volatile int factCount = 0;

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void buyerLeaveMarket() {
        buyersInMarket--;
        factCount++;
    }

    static synchronized  int getBuyersInMarket() {
        return buyersInMarket;
    }

    synchronized static boolean marketIsOpened() {
        return (buyersInMarket+ factCount)<PLAN_COUNT;
    }
    synchronized static boolean planComplete() {
        return factCount >= PLAN_COUNT;
    }
}
