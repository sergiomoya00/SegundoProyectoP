/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.Pacient;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.PacientDAO;
import java.util.List;

/**
 *
 * @author samoy
 */
public class PacientController extends ActionSupport {

    private Pacient pacient = new Pacient();
    private List<Pacient> list;

    @Override
    public String execute() {
        PacientDAO pacientD = new PacientDAO();
        pacientD.pacientRegister(pacient);

        return SUCCESS;
    }

    public String getAllCenters() {
        PacientDAO pacientD = new PacientDAO();
        this.list = pacientD.getAllPacients();
        return SUCCESS;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public List<Pacient> getList() {
        return list;
    }

    public void setList(List<Pacient> list) {
        this.list = list;
    }
}
