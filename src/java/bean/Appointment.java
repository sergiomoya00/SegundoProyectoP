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
public class Appointment extends Worker {

    private int idAppointment;
    private Pacient idPacient;
    private String date;
    private String hour;
    private String observation;
    private String condition;

    public Appointment(int idAppointment, Pacient idPacient, int id, String date, String hour, String observation, String condition) {
        super(id);
        this.idAppointment = idAppointment;
        this.idPacient = idPacient;
        this.date = date;
        this.hour = hour;
        this.observation = observation;
        this.condition = condition;
    }

    public Appointment() {
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Pacient getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(Pacient idPacient) {
        this.idPacient = idPacient;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
