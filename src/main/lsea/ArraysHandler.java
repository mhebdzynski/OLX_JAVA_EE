package main.lsea;

import lombok.*;
import main.TestSessionBean.ClientTest;
import main.TestSessionBean.TestSessionBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
@ManagedBean(name="arraysHandler",eager=true)
@SessionScoped
public class ArraysHandler{
    ArrayList<LSEA> profiles = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();


    public String addProfile(LSEA obj){
        this.getProfiles().add(obj);
        return "home";
    }

    public String addCar(Car obj){
        obj.setAccount(this.getProfiles().get(this.getProfiles().size() - 1));
        this.getCars().add(obj);
        return "home";
    }


}
