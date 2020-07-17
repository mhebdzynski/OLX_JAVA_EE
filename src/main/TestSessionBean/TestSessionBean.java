package main.TestSessionBean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;

@Singleton
public class TestSessionBean {

    public String msg = "EJB is working";
    public boolean beanStatus = false;

    @PostConstruct
    public String getMsg(){
        return this.msg;
    }
    @PostConstruct
    public boolean getBeanStatus(){
        return this.beanStatus;
    }


}
