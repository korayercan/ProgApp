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
 @ManagedBean( name="samples" )

 public class SqlSamples 
 {


// allow the server to inject the DataSource

DataSource dataSource;
public SqlSamples()
{
try
{
Context ctx = new InitialContext();
// You must write the database you will use. Here we use "sample" built-in database.
dataSource = (DataSource) ctx.lookup("jdbc/sample");
}
catch (NamingException e) 
{
e.printStackTrace();
}
}


 // return a ResultSet of entries
// getSample1 metodu bir SQL komutu sonucu döndürmelidir. VE tipi ResultSet olmalıdır.
 public ResultSet getSample1() throws SQLException
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
 "SELECT avg(shipping_cost) as ortalama_kargo_ucreti " +
 "FROM purchase_order" );
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end method getAddresses

 // getSample2 metodu bir SQL komutu sonucu döndürmelidir. VE tipi ResultSet olmalıdır.
 public ResultSet getSample2() throws SQLException
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
 "SELECT * FROM purchase_order" );
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end
 

  // end class SqlSamples
 }
