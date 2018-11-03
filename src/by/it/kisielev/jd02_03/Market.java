package by.it.kisielev.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;

        System.out.println("Market open!");

        ExecutorService executors = Executors.newFixedThreadPool(5);

        for (int i = 0; i <=2 ; i++) {//создаем кассиров
            Cashier cashier = new Cashier(i);
            executors.execute(cashier);

        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(counterBuyer++);
                    threads.add(buyer);//добавляет в наш лист покупателя
                    buyer.start();
                    System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
                }
            }
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
        while (!executors.isTerminated())Util.sleep(100); //пока все задачи не выполнены она не закончиться
        System.out.println("In market total: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market close");

    }
}
