/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_test;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Invoice implements Comparable<Invoice>{

    private String id;
    private Customer customer;
    private ArrayList<LineItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public Invoice() {
    }

    public Invoice(String id, Customer cus) {
        this.id = id;
        this.customer = cus;
        this.items = new ArrayList<>();
    }

    public Invoice(Customer customer, ArrayList<LineItem> items) {
        this.customer = customer;
        this.items = items;
    }

    public void add(Product product, int quantity) {
        LineItem lineItem = new LineItem(product, quantity);
        items.add(lineItem);
    }

    public double getTotal() {
        double total = 0;
        for (LineItem item : items) {
            total = total + item.getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        String r = "+----------------------------------------------------------------+"
                + String.format("\n| I N V O I C E %48s |", id)
                + "\n+----------------------------------------------------------------+\n"
                + customer.toString()
                + "\n+----------------------------------------------------------------+"
                + String.format("\n| %-5s %-24s%12s%5s%15s |\n", "No", "Description", "Price", "Qty",
                        "Amount");
        for (int i = 0; i < items.size(); i++) {
            r = r + "| " + (i + 1) + "    " + items.get(i).toString() + "\n";
        }
        r = r + "+----------------------------------------------------------------+";
        r = r + String.format("\n| Total: %,8.0f VND%44s|", getTotal(), " ");
        r = r + "\n+----------------------------------------------------------------+";
        return r;

    }

    @Override
    public int compareTo(Invoice o) {
        return -1*(int)(this.getTotal()-o.getTotal());
    }

}
