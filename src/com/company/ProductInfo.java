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
    SQL_Worker sql = new SQL_Worker();

   public ProductInfo(){
       this.productId = Short.parseShort((sql.GetDataFromDatabase("SELECT tmp.ProductId FROM WebShop.dbo.Product tmp")));
       this.nameOfProduct = (sql.GetDataFromDatabase("SELECT tmp.ProductName FROM WebShop.dbo.Product tmp"));
       this.availableQuantity = Short.parseShort((sql.GetDataFromDatabase("SELECT tmp.Quantity FROM WebShop.dbo.Product tmp")));
       this.price = Float.parseFloat((sql.GetDataFromDatabase("SELECT tmp.Price FROM WebShop.dbo.Product tmp")));
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
       this.availableQuantity = Short.parseShort((sql.GetDataFromDatabase("UPDATE WebShop.dbo.Product SET quantity = " + newValue + " WHERE ProductId = " + productId)));
    }
    public void UpdateAvailableQuantityAfterOrder_IncreaseTheAmountInDatabase(String productId, short howManyIncrease){
        String newValue = String.valueOf(availableQuantity + howManyIncrease);
        this.availableQuantity = Short.parseShort((sql.GetDataFromDatabase("UPDATE WebShop.dbo.Product SET Quantity = " + newValue + " WHERE ProductId = " + productId)));
    }
}
