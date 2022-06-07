/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
 //java.awt.event.ActionListener

public class ClassA implements ActionListener{
   @Override
   public void processAction(ActionEvent event) throws AbortProcessingException {
           
       
       UserData a1 = (UserData) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userData"); 
      a1.setData("Hello World from a1");
       UserData a2=new UserData() ;
       a2.setData("Hello World from a2");
     
   }
}