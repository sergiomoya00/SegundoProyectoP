/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jabre
 */
public class Worker {

    //Atributos de la clase Worker
    protected int id;
    private String name;
    private String type;
    private String deliveryDate;
    private String area;

    public Worker(int id, String name, String type, String deliveryDate, String area) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.deliveryDate = deliveryDate;
        this.area = area;
    }

    public Worker(int id) {
        this.id = id;
    }

    public Worker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setFechaDeEntrega(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
