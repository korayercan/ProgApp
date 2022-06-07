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
@ManagedBean ( name="musteriler" )
@SessionScoped
public class MusteriBean {
private String bulunacak_musteri;

    public void setBulunacak_musteri(String bulunacak_musteri) {
        this.bulunacak_musteri = bulunacak_musteri;
    }

    public String getBulunacak_musteri() {
        return bulunacak_musteri;
    }



CachedRowSet rowSet=null;

   

  DataSource dataSource;
   public MusteriBean() {
        try {
			Context ctx = new InitialContext();
                        // sample databaseine bağlanıyoruz
			dataSource = (DataSource)ctx.lookup("jdbc/sample");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
  
 
 public ResultSet bul() throws SQLException
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
 
 PreparedStatement ps =
 connection.prepareStatement( "select PURCHASE_ORDER.customer_id,max(quantity) as max_quantity, " +
 "sum(quantity) as sum_quantity "+
" from PURCHASE_ORDER " +
"group by PURCHASE_ORDER.CUSTOMER_ID " +
"having PURCHASE_ORDER.customer_id=? " );
 //SQL cümlesinin içinde değişken kullanmak istersek ? işaretini kullanırız.
 //bu işaret aynı SQL cümlesinde birkaç tane olabilir. Sıra numaralarına göre sırayla değer 
 // göndermemiz gerekir.
 // Bu örnekte bir tane ? işareti var.Dolayısıyla setInt (1, Integer.parseInt(getBulunacak_musteri())
 // yazarak birinci ? işaretine getBulunacak_musteri() değerini yolluyoruz. Bu değer web sayfasında 
 //kullanıcıdan gelmişti.
 ps.setInt(1, Integer.parseInt(getBulunacak_musteri()));
 rowSet = new com.sun.rowset.CachedRowSetImpl();
 rowSet.populate( ps.executeQuery() );
return rowSet;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } 



}

