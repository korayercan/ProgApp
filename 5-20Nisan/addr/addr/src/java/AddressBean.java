/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 @ManagedBean( name="bean" )
 // You must declare an instance variable for each table column(field)
 public class AddressBean 
 {
 private String firstName;
 private String lastName;
 private String street;
 private String city;
 private String state;
 private String zipcode;

// allow the server to inject the DataSource

DataSource dataSource;
public AddressBean()
{
try
{
Context ctx = new InitialContext();
// kullandığımız database adı addressbook.
dataSource = (DataSource) ctx.lookup("jdbc/sample");
}
catch (NamingException e) 
{
e.printStackTrace();
}
}


 // get the first name
 public String getFirstName()
 {
 return firstName;
 } // end method getFirstName

 // set the first name
 public void setFirstName( String firstName )
 {
 this.firstName = firstName;
 } // end method setFirstName

 // get the last name
 public String getLastName()
 {
 return lastName;
} // end method getLastName

 // set the last name
 public void setLastName( String lastName )
 {
 this.lastName = lastName;
 } // end method setLastName

// get the street
 public String getStreet()
 {
 return street;
 } // end method getStreet

 // set the street
 public void setStreet( String street )
 {
 this.street = street;
 } // end method setStreet

 // get the city
 public String getCity()
 {
 return city;
 } // end method getCity
// set the city
 public void setCity( String city )
 {
 this.city = city;
 } // end method setCity

 // get the state
 public String getState()
 {
 return state;
 } // end method getState

 // set the state
 public void setState( String state )
 {
 this.state = state;
 } // end method setState

 // get the zipcode
 public String getZipcode()
 {
 return zipcode;
 } // end method getZipcode

 // set the zipcode
 public void setZipcode( String zipcode )
 {
 this.zipcode = zipcode;
 } // end method setZipcode

 // return a ResultSet of entries
 public ResultSet getAddresses() throws SQLException
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
     // sql cümlesi yazmak için PreparedStatement oluşturmalıyız.    
 // create a PreparedStatement to select the records
 PreparedStatement object1 = connection.prepareStatement(
 "SELECT FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP " +
 "FROM ADDRESSES ORDER BY LASTNAME, FIRSTNAME" );
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end method getAddresses

 // save a new address book entry
 public String save() throws SQLException
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
 PreparedStatement object2 =
 connection.prepareStatement( "INSERT INTO ADDRESSES " +
 "(FIRSTNAME,LASTNAME,STREET,CITY,STATE,ZIP)" +
 "VALUES ( ?, ?, ?, ?, ?, ? )" );

 // specify the PreparedStatement's arguments
 object2.setString( 1, getFirstName() );
 object2.setString( 2, getLastName() );
 object2.setString( 3, getStreet() );
 object2.setString( 4, getCity() );
 object2.setString( 5, getState() );
 object2.setString( 6, getZipcode() );

 object2.executeUpdate(); // executeQuery() yerine executeUpdate() yazılmalı.Çünkü insert into kullanılıyor.
 return "index"; // go back to index.xhtml page
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end method save
  // end class AddressBean
 }
