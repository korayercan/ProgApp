

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
 
@ManagedBean(name="bean")
@SessionScoped
public class NormalBean{

	public String buttonId; 
        public String x; 

    public String getX() {
        return x;
    }

    public void setX(String x) {
       this.x = x;
    }

	public String getButtonId() {
		return buttonId;
	}

	

	public void printIt(ActionEvent event){
		buttonId = event.getComponent().getId();
		System.out.println(buttonId+" is clicked");
              	}
	
	public String outcome(){
		return "result";
	}
      
}