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
public class Bitacora {

    private int idBitacora;
    private String date;
    private String hour;
    private String user;
    private int appointmentCode;
    private String condition;

    public Bitacora(int idBitacora, String date, String hour, String user, int appointmentCode, String condition) {
        this.idBitacora = idBitacora;
        this.date = date;
        this.hour = hour;
        this.user = user;
        this.appointmentCode = appointmentCode;
        this.condition = condition;
    }

    public Bitacora() {
    }

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAppointmentCode() {
        return appointmentCode;
    }

    public void setAppointmentCode(int appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
