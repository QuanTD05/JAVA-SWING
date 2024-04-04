/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String masv;
    private String hoVaTen;
    private double tiengAnh;
    private double tinHoc;
    private double giaoDucTC;
    private double diemTB;
    

    public SinhVien() {
    }

    public SinhVien(String masv, String hoVaTen, double tiengAnh, double tinHoc, double giaoDucTC, double diemTB) {
        this.masv = masv;
        this.hoVaTen = hoVaTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
        this.diemTB = diemTB;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(double giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
    public Double DiemTB(){
         double diem = (this.tiengAnh + this.tinHoc + this.giaoDucTC)/ 3; 
        
        return diem;
        
    }

    
    
}
