/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.Bitacora;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.BitacoraDAO;
import java.util.List;

/**
 *
 * @author samoy
 */
public class BitacoraController extends ActionSupport {

    private Bitacora bitacora = new Bitacora();
    private List<Bitacora> list;

    @Override
    public String execute() {
        BitacoraDAO usuario = new BitacoraDAO();
        usuario.bitacoraRegister(bitacora);
        return SUCCESS;
    }

    public String getAllHospitalizedPacients() {
        BitacoraDAO usuario = new BitacoraDAO();
        this.list = usuario.getAllBitacora();
        return SUCCESS;
    }

    public String delete() {
        BitacoraDAO usuario = new BitacoraDAO();
        usuario.deleteBitacora(bitacora);
        return SUCCESS;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public List<Bitacora> getList() {
        return list;
    }

    public void setList(List<Bitacora> list) {
        this.list = list;
    }

}
