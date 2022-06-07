/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
 import javax.faces.bean.ManagedBean;
 import javax.faces.bean.RequestScoped;

@ManagedBean( name="validationBean" )
 public class ValidationBean 
 {
 private String name;
 private String email;
 private String phone;

 // return the name String
 public String getName()
 {
 return name;
 } // end method getName

 // set the name String
 public void setName( String name )
 {
 this.name = name;
 } // end method setName
// return the email String
 public String getEmail()
 {
 return email;
 } // end method getEmail

 // set the email String
 public void setEmail( String email )
 {
 this.email = email;
 } // end method setEmail

 // return the phone String
 public String getPhone()
 {
 return phone;
 } // end method getPhone

 // set the phone String
 public void setPhone( String phone )
 {
 this.phone = phone;
 } // end method setPhone

 // returns result for rendering on the client
 
 public String response()
 {
 if ( name != null && email != null && phone != null ){
 return "<p style=\"background-color:yellow;width:200px;" +
 "padding:5px\">Name: " + getName() + "<br/>E-Mail: " +
 getEmail() + "<br/>Phone: " + getPhone() + "</p>";}
 else{
 return "";} // request has not yet been made
 } // end method getResult

 

} // end class ValidationBean
