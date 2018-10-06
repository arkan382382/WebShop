package com.company;

public class Order {
    private short idOfProduct;
    private short howMany;

    public Order(short idOfProduct, short howMany){
        this.idOfProduct = idOfProduct;
        this.howMany = howMany;
    }

    public short getHowMany() {
        return howMany;
    }
    public short getIdOfProduct() {
        return idOfProduct;
    }
}
