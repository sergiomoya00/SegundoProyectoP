/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author samoy
 */
public class Hospitalized {

    private int center;
    private int pacientID;
    private String pacientName;
    private String diagnostic;
    private String startDate;
    private String departureDate;
    private String area;
    private int worker;

    public Hospitalized(int center, int pacientID, String pacientName, String diagnostic, String startDate, String departureDate, String area, int worker) {
        this.center = center;
        this.pacientID = pacientID;
        this.pacientName = pacientName;
        this.diagnostic = diagnostic;
        this.startDate = startDate;
        this.departureDate = departureDate;
        this.area = area;
        this.worker = worker;
    }

    public Hospitalized() {
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public int getPacientID() {
        return pacientID;
    }

    public void setPacientID(int pacientID) {
        this.pacientID = pacientID;
    }

    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getWorker() {
        return worker;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }

}
