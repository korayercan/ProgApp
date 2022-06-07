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
 @ManagedBean( name="samples2" )

 public class SqlSamples2 
 {


// allow the server to inject the DataSource

DataSource dataSource;
public SqlSamples2()
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
 public ResultSet getSample3() throws SQLException
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
 "select customer_id,sum(quantity) as toplam " +
 "from PURCHASE_ORDER group by customer_id " +
 "having sum(quantity)>105" );
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
 public ResultSet getSample4() throws SQLException
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
 "select PURCHASE_ORDER.order_num,Customer.name, Product.description " +
"from PURCHASE_ORDER, Customer, Product " +
"where PURCHASE_ORDER.CUSTOMER_ID=Customer.CUSTOMER_ID and " +
"Product.PRODUCT_ID=Purchase_Order.PRODUCT_ID" );
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end
 

  // end class SqlSamples2
 }
