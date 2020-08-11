/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.Diagnostics;
import bean.Treatments;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.DiagnosticsDAO;
import dao.TreatmentsDAO;
import java.util.List;

/**
 *
 * @author jabre
 */
public class DiagnosticsController extends ActionSupport {

    private Diagnostics diagnostics = new Diagnostics();
    private List<Diagnostics> list;

    @Override
    public String execute() {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        usuario.diagnosticsRegister(diagnostics);
        return SUCCESS;
    }

    public String getAllDiagnostics() {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        this.list = usuario.getAllDiagnostics();
        return SUCCESS;
    }

    public String getAllPacientDiagnostics(int id) {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        this.list = usuario.getAllPacientDiagnostics(id);
        return SUCCESS;
    }

    public String delete() {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        usuario.deleteDiagnostic(diagnostics);
        return SUCCESS;
    }

    public String appointmentDay() {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        usuario.patientDiagnosticsRegister(diagnostics);
        return SUCCESS;
    }
    
    public String getAllDiagnosticsFilter() {
        DiagnosticsDAO usuario = new DiagnosticsDAO();
        if (usuario.getAllDiagnosticsByName(diagnostics.getName()).size() > 0) {
            this.list = usuario.getAllDiagnosticsByName(diagnostics.getName());
        }
        if (usuario.getAllDiagnosticsByLevel(diagnostics.getLevel()).size() > 0) {
            this.list = usuario.getAllDiagnosticsByLevel(diagnostics.getLevel());
        }
        if (usuario.getAllDiagnosticsByPatient(diagnostics.getIdPatient()).size() > 0) {
            this.list = usuario.getAllDiagnosticsByPatient(diagnostics.getIdPatient());
        }
        if (usuario.getAllDiagnosticsByDate(diagnostics.getDate()).size() > 0) {
            this.list = usuario.getAllDiagnosticsByDate(diagnostics.getDate());
        }

        return SUCCESS;
    }

    public Diagnostics getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    public List<Diagnostics> getList() {
        return list;
    }

    public void setList(List<Diagnostics> list) {
        this.list = list;
    }
}
