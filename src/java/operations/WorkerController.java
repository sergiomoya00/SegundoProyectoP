/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

//import bean.Area;
import bean.Worker;
import com.opensymphony.xwork2.ActionSupport;
import dao.WorkerDAO;
import java.util.List;

/**
 *
 * @author jabre
 */
public class WorkerController extends ActionSupport {

    private Worker worker = new Worker();
    //private Area area = new Area();
    private List<Worker> list;

    @Override
    public String execute() {
        WorkerDAO usuario = new WorkerDAO();
        usuario.workerRegister(worker);
        return SUCCESS;
    }

    public String getAllWorkers() {
        WorkerDAO usuario = new WorkerDAO();
        this.list = usuario.getAllWorkers();
        return SUCCESS;
    }

    public String delete() {
        WorkerDAO usuario = new WorkerDAO();
        usuario.deleteWorker(worker);
        return SUCCESS;
    }

    public String areaRegister() {
        WorkerDAO usuario = new WorkerDAO();
//        usuario.areaRegister(area);
        return SUCCESS;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Worker> getList() {
        return list;
    }

    public void setList(List<Worker> list) {
        this.list = list;
    }
/*
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }*/
}
