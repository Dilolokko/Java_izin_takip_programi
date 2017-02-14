/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author a
 */
public class baglanti {
    protected static final String HOSTNAME="jdbc:mysql://localhost:3306/izin?useUnicode=yes&characterEncoding=UTF-8";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1";
      
    public Connection con=null;
    
    public void baglan ()
    {
    
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(HOSTNAME,USER,PASSWORD);
             System.out.println("baglandi");
        } catch (Exception e) {
            System.out.println("Veri tabanına Bağlanamadı"+e.getMessage());
        }
    
    }
    
        protected void baglantiKes ()
    {
    
        try 
        {
          con.close();
          System.out.println("baglati kesildi");
          
        } catch (Exception e) 
        {
          System.out.println("Veri tabanına Bağlanamadı");
        }
    
    }
}
