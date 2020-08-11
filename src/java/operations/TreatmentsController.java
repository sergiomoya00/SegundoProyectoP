/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;


import bean.Treatments;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.TreatmentsDAO;
import java.util.List;

/**
 *
 * @author jabre
 */
public class TreatmentsController extends ActionSupport {
    
    private Treatments treatments=new Treatments();
    private List<Treatments> list;
    
    @Override
    public String execute() {
        TreatmentsDAO usuario = new TreatmentsDAO();
        usuario.treatmentRegister(treatments);
        return SUCCESS;
    }
    
    public String getAllTreatments(){
    TreatmentsDAO usuario = new TreatmentsDAO();
    this.list = usuario.getAllTreatments();    
    return SUCCESS;
    }
    
    public String delete() {
        TreatmentsDAO usuario = new TreatmentsDAO();
        usuario.deleteDiagnostic(treatments);
        return SUCCESS;
    }
    
     public Treatments getTreatments() {
        return treatments;
    }

    public void setTreatments(Treatments treatments) {
        this.treatments = treatments;
    }
    
     public List<Treatments> getList() {
        return list;
    }

    public void setList(List<Treatments> list) {
        this.list = list;
    }
}
