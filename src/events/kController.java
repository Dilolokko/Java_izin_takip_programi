/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.util.Collections.list;

/**
 *
 * @author a
 */
public class kController extends baglanti{
    public String[] kulCek(String kID)
    {
        String[] veri = new String[8];
        
        try
        {
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from giris where kullanici_id = ?");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            rs.next();
                veri[0] = rs.getString("Ad");
                veri[1] = rs.getString("Soyad");
                veri[2] = rs.getString("Tc_No");
                veri[3] = rs.getString("Sicil_No");
                veri[4] = rs.getString("Cinsiyet");
                veri[5] = rs.getString("Dog_Tar");
                veri[6] = rs.getString("Sehir");
                veri[7] = rs.getString("birim");
                
            return veri;
        }
        catch(Exception e)
        {
            System.out.printf(e.getMessage());
            return null;
        }
        
    }
    public String sonGiris()
    {
        try
        {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from son");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("son_giris");
        }
        catch(Exception e)
        {
            return null;
        }
    }
    public void guncelle(String[] veri,String kID)
    {
        try
        {
            baglan();
            PreparedStatement ps = con.prepareStatement("update giris set Ad =?,Soyad=?,Tc_No =?,Sicil_No = ?, Cinsiyet =?,Dog_Tar =?,Sehir=? where kullanici_id=?");
            ps.setString(1, veri[0]);
            ps.setString(2, veri[1]);
            ps.setString(3, veri[2]);
            ps.setString(4, veri[3]);
            ps.setString(5, veri[4]);
            ps.setString(6, veri[5]);
            ps.setString(7, veri[6]);
            ps.setString(8,kID);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    
}
