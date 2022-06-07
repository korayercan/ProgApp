/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ActionEvent;
@ManagedBean(name = "userData")
@SessionScoped
public class UserData  {

   private String data = "data";
	
   public String showResult(){
      return "result";
   }

   public void updateData(ActionEvent e){
      data="Hello World";
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }
}