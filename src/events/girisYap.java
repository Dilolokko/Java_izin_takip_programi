/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author a
 */
public class girisYap extends baglanti{
    public String dogrula(String kAdi,String kSifre) throws SQLException
    {
        try
        {
            String kID = null,durum = null;
            baglan();
            PreparedStatement st = con.prepareStatement("select kullanici_id from kullanici where Kullanici_Adi = ? and Sifre = ?");
            st.setString(1, kAdi);
            st.setString(2, kSifre);
            ResultSet rs = st.executeQuery();
            while(rs.next())
                kID = rs.getString("kullanici_id");
            
            System.out.print("giriş yapıldı");
            st = con.prepareStatement("update son set son_giris = ? ");
            st.setString(1,kID);
            st.executeUpdate();
            baglantiKes();
            return kID;
        }
        catch(Exception e)
        {
            System.out.print("hata var "+e.getMessage());
            return null;
        }
        
    }
    public String sec(String kID) throws SQLException
    {
        try
        {
            String durum = null;
            baglan();
            PreparedStatement st = con.prepareStatement("select durum from kullanici where kullanici_id = ?");
            st.setString(1, kID);
            
            ResultSet rs = st.executeQuery();
            while(rs.next())
                durum = rs.getString("durum");
            
            System.out.print("giriş yapıldı");
            baglantiKes();
            return durum;
        }
        catch(Exception e)
        {
            System.out.print("hata var "+e.getMessage());
            return null;
        }
        
    }
    
}
