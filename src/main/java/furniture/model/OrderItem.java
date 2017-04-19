package main.java.furniture.model;

public class OrderItem {

    private int id;
    private Comanda comanda;
    private Produs produs;
    private int cantitate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public double calculeazaPret() {
        return produs.getPret() * cantitate;
    }

    public void updateStoc() {
        produs.reduStoc(cantitate);
    }
}
