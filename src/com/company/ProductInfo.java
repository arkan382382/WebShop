package com.company;
/*
This class is only to get datas about Product from database
There isn't way to add product via program - not yet :)
 */
public class ProductInfo {
    private short productId;
    private String nameOfProduct;
    private short availableQuantity;
    private float price;

   /* public Product(String name, short quantityOfProduct, ){
        this.nameOfProduct = name;
        this.availableQuantity = quantityOfProduct;
    } */
   public ProductInfo(){
       this.productId = Short.parseShort((SQL_Worker.GetDataFromDatabase("SELECT tmp.productId FROM Arkan.dbo.product tmp")));
       this.nameOfProduct = (SQL_Worker.GetDataFromDatabase("SELECT tmp.nameOfProduct FROM Arkan.dbo.product tmp"));
       this.availableQuantity = Short.parseShort((SQL_Worker.GetDataFromDatabase("SELECT tmp.quantity FROM Arkan.dbo.product tmp")));
       this.price = Float.parseFloat((SQL_Worker.GetDataFromDatabase("SELECT tmp.price FROM Arkan.dbo.product tmp")));
   }

    public short howManyProductsLeft(short productID){
        return availableQuantity;
    }
    public short getProductId() {
        return productId;
    }
    public String getNameOfProduct() {
        return nameOfProduct;
    }
    public float getPrice() {
        return price;
    }
    public short getAvailableQuantity() {
        return availableQuantity;
    }

    public void UpdateAvailableQuantityAfterOrder_ReduceTheAmountInDatabase(String productId, short howManyHasDecrease){
       String newValue = String.valueOf(availableQuantity - howManyHasDecrease);
       this.availableQuantity = Short.parseShort((SQL_Worker.GetDataFromDatabase("UPDATE Arkan.dbo.product SET quantity = " + newValue + " WHERE productId = " + productId)));
    }
    public void UpdateAvailableQuantityAfterOrder_IncreaseTheAmountInDatabase(String productId, short howManyIncrease){
        String newValue = String.valueOf(availableQuantity + howManyIncrease);
        this.availableQuantity = Short.parseShort((SQL_Worker.GetDataFromDatabase("UPDATE Arkan.dbo.product SET quantity = " + newValue + " WHERE productId = " + productId)));
    }
}
