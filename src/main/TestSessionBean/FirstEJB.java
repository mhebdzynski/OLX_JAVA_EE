package main.TestSessionBean;

import javax.ejb.Stateless;

@Stateless
public class FirstEJB {

    public String message = "first EJB is working";
    public boolean FEJBB = false;

    public String getMessage(){
        return this.message;
    }

    public boolean getEJBB(){
        return this.FEJBB;
    }

    public void changeBool(){
        this.FEJBB = !this.FEJBB;
    }
}
