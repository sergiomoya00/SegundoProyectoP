/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.Appointment;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.AppointmentDAO;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author samoy
 */
public class AppointmentController extends ActionSupport {

    private Appointment appointment = new Appointment();
    private List<Appointment> list;

    @Override
    public String execute() {
        AppointmentDAO appointmentD = new AppointmentDAO();
        appointmentD.createAppontment(appointment);

        return SUCCESS;
    }
    
    public String getAllAppointment() {
        AppointmentDAO appointmentD = new AppointmentDAO();
        this.list = appointmentD.getAllAppointment();
        return SUCCESS;
    }

    public String getAllAppointment(int id) {
        AppointmentDAO appointmentD = new AppointmentDAO();
        this.list = appointmentD.getAllAppointment(id);
        return SUCCESS;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<Appointment> getList() {
        return list;
    }

    public void setList(List<Appointment> list) {
        this.list = list;
    }
}
