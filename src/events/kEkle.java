/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.sql.PreparedStatement;

/**
 *
 * @author a
 */
public class kEkle extends baglanti{
    public boolean kEklek(kullanici k)
    {
        try
        {
            baglan();
            PreparedStatement ps = con.prepareStatement("insert into giris(Ad,Soyad,Tc_No,Sicil_No,Cinsiyet,Dog_Tar,Sehir,birim) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, k.getAd());
            ps.setString(2, k.getSoyad());
            ps.setString(3, k.getTc());
            ps.setString(4, k.getSicil());
            ps.setString(5, k.getCinsiyet());
            ps.setString(6, k.getDogt());
            ps.setString(7, k.getSehir());
            ps.setString(8, k.getBirim());
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean kEkleG(String kadi,String parola,String durum)
    {
        try
        {
            baglan();
            PreparedStatement ps = con.prepareStatement("insert into kullanici(Kullanici_Adi,Sifre,durum) values(?,?,?)");
            ps.setString(1, kadi);
            ps.setString(2, parola);
            ps.setString(3, durum);
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return false;
        }
    }
    
}
