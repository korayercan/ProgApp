/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
 import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="user")
//@SessionScoped
@RequestScoped
public class UserBean{
 String a;

    public void setA(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
   
	public String goLoginPage(){
            
	return "login.xhtml";}
        
}


