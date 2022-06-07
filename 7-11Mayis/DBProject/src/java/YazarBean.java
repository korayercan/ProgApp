/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.Connection;
import java.sql.Date;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 import javax.annotation.Resource;
 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
 import javax.sql.DataSource;
 import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author PELIN
 */
@ManagedBean ( name="yazarBean" )
@SessionScoped

public class YazarBean {
 private String ad;
 private String soyad;
private String dogum_tarihi;
private String silinecek_id;
 
  DataSource dataSource;
    public YazarBean() {
        try {
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("jdbc/sample");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    

   public String getAd()
 {
 return ad;
 } // end method getFirstName

 // set the first name
 public void setAd( String ad )
 {
 this.ad = ad;
 } // end method setFirstName

  public String getSoyad()
 {
 return soyad;
 } // end method getFirstName

 // set the first name
 public void setSoyad( String soyad )
 {
 this.soyad = soyad;
 } // end method setFirstName

 public String getDogum_tarihi()
 {
 return dogum_tarihi;
 } // end method getFirstName

 // set the first name
 public void setDogum_tarihi( String dogum_tarihi )
 {
 this.dogum_tarihi = dogum_tarihi;
 } // end method setFirstName
 
 public String getSilinecek_id()
 {
 return silinecek_id;
 } // end method getFirstName

 // set the first name
 public void setSilinecek_id( String silinecek_id )
 {
 this.silinecek_id = silinecek_id;
 } // end method setFirstName
 
 
 public Date tipcevir(String tarih) throws ParseException{
 SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
 java.util.Date date = date1.parse(tarih);
 java.sql.Date sqlDate = new java.sql.Date(date.getTime());// getTime() long tipli tarih verisi döner
 return sqlDate;
 }
 
 
 
 public String ekle() throws SQLException
 {
 // check whether dataSource was injected by the server
 if ( dataSource == null )
 throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
 Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
 // create a PreparedStatement to insert a new address book entry
 PreparedStatement addEntry =
 connection.prepareStatement( "INSERT INTO yazarlar " +
 "(ad,soyad,dogum_tarihi)" +
 "VALUES ( ?, ?, ? )" );

 // specify the PreparedStatement's arguments

 addEntry.setString( 1, getAd() );
 addEntry.setString( 2, getSoyad() );
 addEntry.setDate(3,tipcevir(getDogum_tarihi()));

addEntry.executeUpdate(); // insert the entry
 return "index"; // go back to index.xhtml page
 } // end try
 catch(Exception e){
    return "index";
 }
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } 

 
 public String sil() throws SQLException
 {
 // check whether dataSource was injected by the server
 if ( dataSource == null )
 throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
 Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
 // create a PreparedStatement to insert a new address book entry
 PreparedStatement deleteEntry =
 connection.prepareStatement( "delete from yazarlar where id=?");

 // specify the PreparedStatement's arguments
 deleteEntry.setInt( 1, Integer.parseInt(getSilinecek_id()) );
 
deleteEntry.executeUpdate(); // insert the entry
 return "index"; // go back to index.xhtml page
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } 





}

