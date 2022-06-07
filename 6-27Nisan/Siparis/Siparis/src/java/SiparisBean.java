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
@ManagedBean ( name="siparisler" )
@SessionScoped
public class SiparisBean {
    private String bulunacak_siparis;

    public void setBulunacak_siparis(String bulunacak_siparis) {
        this.bulunacak_siparis = bulunacak_siparis;
    }

    public String getBulunacak_siparis() {
        return bulunacak_siparis;
    }



    CachedRowSet rowSet=null;

    DataSource dataSource;
    public SiparisBean() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } 
        catch (NamingException e) {
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
            connection.prepareStatement( "select order_num, customer.customer_id, name,description,quantity,sales_date " +
            " from PURCHASE_ORDER, customer, Product " +
            "where order_num=? and " +
            "PURCHASE_ORDER.CUSTOMER_ID=customer.CUSTOMER_ID and " +
            "PURCHASE_ORDER.PRODUCT_ID=product.PRODUCT_ID" );
            //SQL cümlesinin içinde değişken kullanmak istersek ? işaretini kullanırız.
            //bu işaret aynı SQL cümlesinde birkaç tane olabilir. Sıra numaralarına göre sırayla değer 
            // göndermemiz gerekir.
            // Bu örnekte bir tane ? işareti var.Dolayısıyla setInt (1, Integer.parseInt(getBulunacak_siparis())
            // yazarak birinci ? işaretine getBulunacak_siparis() değerini yolluyoruz. Bu değer web sayfasında 
            //kullanıcıdan gelmişti.
            ps.setInt(1, Integer.parseInt(getBulunacak_siparis()));
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

