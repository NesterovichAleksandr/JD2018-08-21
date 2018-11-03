package by.it.kisielev.jd02_03;

//Каждый покупатель долджен выполнять эти действия
public interface IBuyer {
    void enterToMarket(); //заходит человек в магазин
    void chooseGoods(); //выберат товар с 0.5 до 2 секунд
    void gotoQueue(); // тановиться  в очередь
    void goOut(); //покупатель выходит с маркета
}

