package main.TestSessionBean;

import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@NoArgsConstructor
public class ClientTest {

    @EJB
    public FirstEJB FE;

    @EJB
    public SecondEJB SE;

    @PostConstruct
    public String getSEMsg(){
        return this.SE.getMessage();
    }

    @PostConstruct
    public String getFEMsg(){
        return this.FE.getMessage();
    }

    @PostConstruct
    public String changeBools(){
        this.FE.changeBool();
        this.SE.changeBool();
        return "home";
    }

    public FirstEJB getFE() {
        return this.FE;
    }

    public SecondEJB getSE(){
        return this.SE;
    }
}
