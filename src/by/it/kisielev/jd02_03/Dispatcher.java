package by.it.kisielev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int KSPEED = 100;
    private static AtomicInteger buyersInMarket=new AtomicInteger(0);
    private static final int PLAN_COUNT = 100;
    private static AtomicInteger factCount =new AtomicInteger (0);

    static void addBuyer() {
        buyersInMarket.incrementAndGet();
    }

    static  void buyerLeaveMarket() {
        buyersInMarket.getAndIncrement();
        factCount.incrementAndGet();
    }

    static int getBuyersInMarket() { return buyersInMarket.get(); }
    static boolean marketIsOpened() {
        return (buyersInMarket.get()+ factCount.get())<PLAN_COUNT;
    }
    static boolean planComplete() {
        return factCount.get() >= PLAN_COUNT;
    }
}
