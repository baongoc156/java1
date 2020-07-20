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
public class InvoiceManagement {

    private ArrayList<Invoice> invoices;

    public ArrayList<Invoice> getInvoiceList() {
        return invoices;
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoices = invoiceList;
    }

    public InvoiceManagement() {
        invoices = new ArrayList<>();
    }

    public void add(Invoice iv) {
        invoices.add(iv);
    }

    public boolean remove(String id) {
        if (id == null) {
            return false;
        }
        for (int i = 0; i < invoices.size(); i++) {
            if (id.equals(invoices.get(i).getId())) {
                invoices.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Invoice> findInvoicesMaxTotal() {
        ArrayList<Invoice> rs = new ArrayList<>();
        double max = getMaxTotal();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getTotal() == max) {
                rs.add(invoices.get(i));
            }
        }
        return rs;
    }

    public double getMaxTotal() {
        double max = invoices.get(0).getTotal();
        for (int i = 1; i < invoices.size(); i++) {
            if (invoices.get(i).getTotal() > max) {
                max = invoices.get(i).getTotal();
            }
        }
        return max;
    }

    public ArrayList<Invoice> findInvoiceName(String key) {
        ArrayList<Invoice> rs = new ArrayList<>();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getCustomer().getName().equals(key)) {
                rs.add(invoices.get(i));
            }
        }
        return rs;
    }

    public ArrayList<Invoice> Sort() {
        ArrayList<Invoice> rs = this.getInvoiceList();
        
        for (int i = 0; i < rs.size() - 1; i++) {
            if (rs.get(i).getTotal() >= rs.get(i + 1).getTotal()) {
                Swap(i, i + 1,rs);
            }
        }
        return rs;
    }

    public void Swap(int i1, int i2,ArrayList<Invoice> invoices) {
        Invoice temp = invoices.get(i1);
        invoices.set(i1, invoices.get(i2));
        invoices.set(i2, temp);
    }

    public String format() {
        StringBuilder str = new StringBuilder();
        invoices.forEach((x)->str.append("\n").append(x.toString()));
        return str.toString();
    }

}
