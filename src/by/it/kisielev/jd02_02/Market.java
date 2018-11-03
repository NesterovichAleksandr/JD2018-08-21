package by.it.kisielev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;

        System.out.println("Market is open!");
        for (int i = 0; i <=2 ; i++) {//создаем кассиров
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);//добавляет в наш лист покупателя
                    buyer.start();
                    System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
                }
            }
            Util.sleep(1000);
        }
        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
        System.out.println("Market close");

    }
}
