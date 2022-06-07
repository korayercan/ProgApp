import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
 
@ManagedBean(name="user")

@SessionScoped
public class UserBean{
 
   public String nickname;
   public String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
 
	//action listener event
    public void method(ActionEvent event){
 
       nickname = (String)event.getComponent().getAttributes().get("username");
         surname = (String)event.getComponent().getAttributes().get("surname");
 
	}
 
	public String outcome(){
            return "result";
	}
 
	public String getNickname() {
		return nickname;
	}
 
	//public void setNickname(String nickname) {
	//	this.nickname = nickname;
	//}
}