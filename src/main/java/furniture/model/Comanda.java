package main.java.furniture.model;

import main.java.furniture.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda {

    private int id;
    private Customer customer;
    private Adresa adresaLivrare;
    private String identificationNumber;
    private Date dataLivrare;
    private OrderStatus status;
    private double valoare;

    private List<OrderItem> items = new ArrayList<OrderItem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Adresa getAdresaLivrare() {
        return adresaLivrare;
    }

    public void setAdresaLivrare(Adresa adresaLivrare) {
        this.adresaLivrare = adresaLivrare;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDataLivrare() {
        return dataLivrare;
    }

    public void setDataLivrare(Date dataLivrare) {
        this.dataLivrare = dataLivrare;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void adaugaItem(OrderItem item) {
        items.add(item);
        valoare += item.calculeazaPret();
        item.updateStoc();
    }

    public double calculeazaValoareTotala() {
        for (OrderItem item : items) {
            valoare += item.calculeazaPret();
        }
        return valoare;
    }


}
