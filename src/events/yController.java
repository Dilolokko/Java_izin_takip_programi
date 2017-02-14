/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class yController extends baglanti{

    
    public kullanici kulcek(String kID) throws SQLException
    {
        kullanici kul = new kullanici();
        try
        {
            baglan();
        
            PreparedStatement ps = con.prepareStatement("select * from giris where kullanici_id = ?");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                kul.setAd(rs.getString("Ad"));
                kul.setSoyad(rs.getString("Soyad"));
                kul.setTc(rs.getString("Tc_No"));
                kul.setSicil(rs.getString("Sicil_No"));
                kul.setCinsiyet(rs.getString("Cinsiyet"));
                kul.setDogt(rs.getString("Dog_Tar"));
                kul.setSehir(rs.getString("Sehir"));
                kul.setBirim(rs.getString("birim"));
            }
            return kul;
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage()+"bos");
            return kul;
        }
    }
    public List<kullanici> kulDoldur()
    {
        int i=0;
        List<kullanici> liste = new ArrayList<>();
        kullanici bilgi = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from giris");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bilgi = new kullanici();
                bilgi.setAd(rs.getString(2));
                bilgi.setSoyad(rs.getString(3));
                bilgi.setTc(rs.getString(4));
                bilgi.setSicil(rs.getString(5));
                bilgi.setCinsiyet(rs.getString(6));
                bilgi.setDogt(rs.getString(7));
                bilgi.setSehir(rs.getString(8));
                bilgi.setBirim(rs.getString(9));
                System.out.print("kullanıcı çekildi");
                liste.add(bilgi);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    public List<kullanici> kulAraDoldur(String sorgu)
    {
        int i=0;
        List<kullanici> liste = new ArrayList<>();
        kullanici bilgi = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bilgi = new kullanici();
                bilgi.setAd(rs.getString(2));
                bilgi.setSoyad(rs.getString(3));
                bilgi.setTc(rs.getString(4));
                bilgi.setSicil(rs.getString(5));
                bilgi.setCinsiyet(rs.getString(6));
                bilgi.setDogt(rs.getString(7));
                bilgi.setSehir(rs.getString(8));
                bilgi.setBirim(rs.getString(9));
                System.out.print("kullanıcı çekildi");
                liste.add(bilgi);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    
}
