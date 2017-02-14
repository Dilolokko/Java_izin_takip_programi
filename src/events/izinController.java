/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import veritabani2o.yoneticiG;

/**
 *
 * @author a
 */
public class izinController extends baglanti{
    public List<izin> izinListesi(String kID)
    {
        
        
        int sayac =0;
        int i=0;
        List<izin> liste = new ArrayList<>();
        izin musteri = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from izinler where kullanici_id = ?");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                musteri = new izin();
                musteri.setBaslangic(rs.getDate(2).toString());
                musteri.setBitis(rs.getDate(3).toString());
                musteri.setMiktar(rs.getString(4));
                musteri.setTur(rs.getString(5));
                musteri.setKabul(rs.getString(6));
                musteri.setKayitno(rs.getString(7));
                System.out.print("aaaaaa");
                liste.add(musteri);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    public List<izin> izinListesiKabul(String kID)
    {
        
        
        int sayac =0;
        int i=0;
        List<izin> liste = new ArrayList<>();
        izin musteri = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from izinler where kullanici_id = ? and kabul=1");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                musteri = new izin();
                musteri.setBaslangic(rs.getDate(2).toString());
                musteri.setBitis(rs.getDate(3).toString());
                musteri.setMiktar(rs.getString(4));
                musteri.setTur(rs.getString(5));
                musteri.setKabul(rs.getString(6));
                musteri.setKayitno(rs.getString(7));
                System.out.print("Kabul");
                liste.add(musteri);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    public List<izin> izinler()
    {
        
        
        int sayac =0;
        int i=0;
        List<izin> liste = new ArrayList<>();
        izin musteri = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from izinler");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                musteri = new izin();
                musteri.setBaslangic(rs.getDate(2).toString());
                musteri.setBitis(rs.getDate(3).toString());
                musteri.setMiktar(rs.getString(4));
                musteri.setTur(rs.getString(5));
                musteri.setKabul(rs.getString(6));
                musteri.setKayitno(rs.getString(7));
                liste.add(musteri);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    public List<izin> izinArar(String sicil_no,String tur)
    {
        
        
        
        int i=0;
        List<izin> liste = new ArrayList<>();
        izin musteri = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from izinler where kullanici_id = (select kullanici_id from giris where Sicil_No = ?)"+tur);
            ps.setString(1, sicil_no);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                musteri = new izin();
                musteri.setBaslangic(rs.getDate(2).toString());
                musteri.setBitis(rs.getDate(3).toString());
                musteri.setMiktar(rs.getString(4));
                musteri.setTur(rs.getString(5));
                musteri.setKabul(rs.getString(6));
                musteri.setKayitno(rs.getString(7));
                liste.add(musteri);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    
    public List<izin> izinListesiRed(String kID)
    {
        
        
        int sayac =0;
        int i=0;
        List<izin> liste = new ArrayList<>();
        izin musteri = null;
        try {
            
            baglan();
            PreparedStatement ps = con.prepareStatement("select * from izinler where kullanici_id = ? and kabul=0");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                musteri = new izin();
                musteri.setBaslangic(rs.getDate(2).toString());
                musteri.setBitis(rs.getDate(3).toString());
                musteri.setMiktar(rs.getString(4));
                musteri.setTur(rs.getString(5));
                musteri.setKabul(rs.getString(6));
                musteri.setKayitno(rs.getString(7));
                System.out.print("red");
                liste.add(musteri);
                i++;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return liste;
    }
    public int izinController(String kID)
    {
        try
        {   int a=0;
            baglan();
            PreparedStatement ps = con.prepareStatement("select sum(Kullanilan_Miktar) from izinler where kullanici_id=?");
            ps.setString(1, kID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                a=rs.getInt(1);
            }
            return a;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    public int iziEkle(String bas,String bit,String it,String kg,String io,String kID)
    {
        try
        {
            baglan();
            PreparedStatement ps = con.prepareStatement("insert into izinler(kullanici_id,Baslangic,Bitis,izin_Tur,Kullanilan_Miktar,kabul) values(?,?,?,?,?,?)");
            ps.setString(1, kID);
            ps.setString(2, bas);
            ps.setString(3, bit);
            ps.setString(4, it);
            ps.setString(5, kg);
            ps.setString(6, io);
            ps.executeUpdate();
            return 1;
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return 0;
        }
        
    }
    public void izinOnay(String kn,String kbl) throws SQLException
    {
        baglan();
        try {
            PreparedStatement ps = con.prepareStatement("update izinler set kabul = ? where Kayit_No = ?");
            ps.setString(1, kbl);
            ps.setString(2, kn);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(izinController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hatalı bir kayıt numarası girdiniz lütfen kontrol ediniz!","Dikkat",WIDTH);
        }
        
    }
    
}
