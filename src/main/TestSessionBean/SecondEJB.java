package main.TestSessionBean;

import javax.ejb.Stateful;

@Stateful
public class SecondEJB {

    public String message = "second EJB is working";
    public boolean SEJBB = true;

    public String getMessage(){
        return this.message;
    }

    public boolean getEJBB(){
        return this.SEJBB;
    }

    public void changeBool(){
        this.SEJBB = !this.SEJBB;
    }
}
