/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SinhVien;
import java.sql.*;
import java.util.ArrayList;
import utils.DbConnection;

/**
 *
 * @author Admin
 */
public class SinhVienRepository {

    private Connection conn;

    public SinhVienRepository() {
        conn = DbConnection.getConnection();
    }

    public ArrayList<SinhVien> search(String kyword) {
        String SQL = "SELECT * FROM DanhSachSV ";
        if (kyword.trim().length() != 0) {
            SQL += " WHERE MaSinhVien LIKE ? OR Ten LIKE ? ";
        }
        ArrayList<SinhVien> ds = new ArrayList<SinhVien>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            if (kyword.trim().length() != 0) {
                ps.setString(1, "%" + kyword + "%");
                ps.setString(2, "%" + kyword + "%");
            }
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                String maSinhVien = rs.getString("MaSinhVien");
                String ten = rs.getString("Ten");
                int tiengAnh = rs.getInt("TiengAnh");
                int tinHoc = rs.getInt("TinHoc");
                int gdTC = rs.getInt("GDTC");

                ds.add(new SinhVien(maSinhVien, ten, tiengAnh, tinHoc, gdTC, gdTC));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public void Update(SinhVien sv) {
        String SQL = "UPDATE DanhSachSV SET Ten = ?,  TiengAnh = ?, TinHoc = ?, GDTC = ? WHERE MaSinhVien = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getHoVaTen());
            ps.setString(5, sv.getMasv());
            ps.setDouble(2, sv.getTiengAnh());
            ps.setDouble(3, sv.getTinHoc());
            ps.setDouble(4, sv.getGiaoDucTC());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Save(SinhVien sv) {
        String SQL = "INSERT INTO DanhSachSV (MaSinhVien, Ten, TiengAnh, TinHoc,GDTC  ) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, sv.getMasv());
            ps.setString(2, sv.getHoVaTen());
            ps.setDouble(3, sv.getTiengAnh());
            ps.setDouble(4, sv.getTinHoc());
            ps.setDouble(5, sv.getGiaoDucTC());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String Masv) {
        String SQL = "DELETE FROM DanhSachSV WHERE MaSinhVien=?";
        try {
            PreparedStatement nv = this.conn.prepareStatement(SQL);
            nv.setString(1, Masv);
            nv.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
