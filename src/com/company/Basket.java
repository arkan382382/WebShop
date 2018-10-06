package com.company;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Order> productInsideOfBasket; //here could be a map (map<produkt_name><product_id>
    ProductInfo info = new ProductInfo();

    public Basket(){
            productInsideOfBasket = new ArrayList<>();
    }
    void addToBasket(short idOfProduct, short howManyToBasket){
        productInsideOfBasket.add(new Order(idOfProduct, howManyToBasket));
        info.UpdateAvailableQuantityAfterOrder_ReduceTheAmountInDatabase(String.valueOf(idOfProduct), howManyToBasket);
    }
    void removeFromBasket(short idOfProduct, short howManyToRemove){
        short index = 0;
        for(byte i = 0; i < productInsideOfBasket.size(); i++){
            if ((productInsideOfBasket.get(i).getIdOfProduct()) == idOfProduct){
                index = productInsideOfBasket.get(i).getIdOfProduct();
            }
        }

        productInsideOfBasket.remove(productInsideOfBasket.get(index));
        info.UpdateAvailableQuantityAfterOrder_IncreaseTheAmountInDatabase(String.valueOf(idOfProduct), howManyToRemove);
    }
}
