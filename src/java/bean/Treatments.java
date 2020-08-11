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
public class Treatments {

    private String idDiagnostic;
    private String name;
    private int quantity;
    private String type;

    public Treatments() {
    }

    public String getIdDiagnostic() {
        return idDiagnostic;
    }

    public void setIdDiagnostic(String idDiagnostic) {
        this.idDiagnostic = idDiagnostic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
