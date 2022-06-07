/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="book")
@RequestScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class Book {
 	private String firstname;
        private String lastname;
        private String mail;
        private String phone;
        private String bookname;
        private String operatingsystem;

        public String getFirstname() {
		return firstname;}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
        
        public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
        
        public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
        
        public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
         public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
        public String getOperatingsystem() {
		return operatingsystem;}
	public void setOperatingsystem(String operatingsystem) {
		this.operatingsystem = operatingsystem;
	} }
