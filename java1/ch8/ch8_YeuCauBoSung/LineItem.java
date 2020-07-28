/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_test;

/**
 *
 * @author Administrator
 */
public class LineItem {
    private int quantity;
    private Product theProduct;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getTheProduct() {
        return theProduct;
    }

    public void setTheProduct(Product theProduct) {
        this.theProduct = theProduct;
    }

    public LineItem() {
    }

    public LineItem(Product theProduct,int quantity) {
        this.quantity = quantity;
        this.theProduct = theProduct;
    }
    
    public double getAmount(){
    return theProduct.getPrice()*quantity;
    }
    @Override

    public String toString() {
        return String.format(" %-24s%,12.0f%5d%,15.0f |", theProduct.getDescription(),
        theProduct.getPrice(), quantity, getAmount());
    }
    
}
