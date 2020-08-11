/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.Hospitalized;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.HospitalizedDAO;
import dao.PacientDAO;
import java.util.List;

/**
 *
 * @author samoy
 */
public class HospitalizedController extends ActionSupport {

    private Hospitalized hospi = new Hospitalized();
    private List<Hospitalized> list;
    private int id;
    private PacientDAO idd;

    @Override
    public String execute() {
        HospitalizedDAO usuario = new HospitalizedDAO();
        usuario.hospitalizationRegister(hospi);
        return SUCCESS;
    }
    
    public int setID(int id) {
        this.id = id;
        return this.id;
    }

    public String getAllHospitalizedPacients() {
        HospitalizedDAO usuario = new HospitalizedDAO();
        this.list = usuario.getAllHospitalizedPacient();
        System.out.println(getID());
        return SUCCESS;
    }

    public String delete() {
        HospitalizedDAO usuario = new HospitalizedDAO();
        usuario.deleteDiagnostic(hospi);
        return SUCCESS;
    }

    public int getID() {
        return id;
    }

    public Hospitalized getHospitalizedPacients() {
        return hospi;
    }

    public void setHospitalized(Hospitalized hospi) {
        this.hospi = hospi;
    }

    public List<Hospitalized> getList() {
        return list;
    }

    public void setList(List<Hospitalized> list) {
        this.list = list;
    }

}
