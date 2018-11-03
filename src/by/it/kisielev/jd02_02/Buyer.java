package by.it.kisielev.jd02_02;

import static by.it.kisielev.jd02_02.Good.goodsKeySet;

class Buyer extends Thread implements IBuyer, UseBasket {
    
    private Basket basket =null;

    @Override
    public String toString(){return this.getName();}

    Buyer(int number){
        super("Buyer# "+number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        chooseGoods();
        gotoQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to market.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started to choose goods.");
        int timeout= Util.random(500,2000); // создаем таймер для покупок
        Util.sleep(timeout);
        System.out.println(this+" finished to choose goods.");
    }

    @Override
    public void gotoQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this){// должен взять монитор и ждать пока кассир вызовет его
        try {
            System.out.println(this+" waiting catcher.");
            this.wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from market.");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void takeBasket() {
        Util.sleep(Util.random(100,200));
        this.basket=new Basket();
        System.out.println(this + "  take basket ");

    }

    @Override
    public void putGoodsToBasket() {
        Util.sleep(Util.random(100,200));
        for (int i=1; i <= goodsKeySet().size(); i++){
            int counter =0;
            int randomKey= Util.random(goodsKeySet().size());

            for (String good:goodsKeySet()){// метод выбора товара
                if (randomKey ==counter++){
                    basket.put(good);
                    System.out.println(this +" take  "+good);
                }
            }
        }
        String good; // корзина2.0
        switch (basket.getKey().size()){
            case 0: good ="product";
                break;

            case 1: good ="product";
                break;

            default:good ="product";
                break;
        }
        System.out.println(this+ " put everything " + basket.getKey().size() +" "+good);
    }

    }

