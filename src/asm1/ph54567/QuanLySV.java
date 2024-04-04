/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asm1.ph54567;

import Models.SinhVien;
import Repositories.SinhVienRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLySV extends javax.swing.JFrame {

    SinhVienRepository SinhVienRepo = new SinhVienRepository();

    /**
     * Creates new form QuanLySV
     */
    public QuanLySV() {
        initComponents();
        loadTable(SinhVienRepo.search(""));
    }

    public SinhVien getFormData() {
        String maSinhVien = txtMASV.getText();
        String Ten = txtHoTen.getText();
        double tiengAnh = Double.valueOf(txtTiengAnh.getText());
        double tinHoc = Double.valueOf(txtTinHoc.getText());
        double GDTC = Double.valueOf(txtGiaoDuc.getText());
        SinhVien nv = new SinhVien(maSinhVien, Ten, tiengAnh, tinHoc, GDTC, GDTC);
        return nv;
    }

    public void loadTable(ArrayList<SinhVien> ds) {
        DefaultTableModel tblModel = (DefaultTableModel) tblDanhSach.getModel();
        tblModel.setRowCount(0);
        for (SinhVien nv : ds) {
            Object[] thongTinSV = {nv.getMasv(), nv.getHoVaTen(), nv.getTiengAnh(), nv.getTinHoc(), nv.getGiaoDucTC(), nv.DiemTB()};
            tblModel.addRow(thongTinSV);
        }
    }

//    public void fillToTable() {
//        String[] coloums = {"MÃ Sinh Viên", "Họ VÀ Tên", "Tiếng Anh", "Tin Học", "Giáo dục TC", "Điểm TB"};
//        DefaultTableModel tblModel = new DefaultTableModel(coloums, 0);
//        for (SinhVien sv : danhSachSv) {
//            Object[] thongTinSV = {sv.getMasv(), sv.getHoVaTen(), sv.getTiengAnh(), sv.getTinHoc(), sv.getGiaoDucTC(), sv.getDiemTB()};
//            tblModel.addRow(thongTinSV);
//        }
//        tblDanhSach.setModel(tblModel);
//    }
//
//    public void addSinhVien() {
//        SinhVien sv = new SinhVien();
//        sv.setMasv(txtMASV.getText());
//        sv.setHoVaTen(txtHoTen.getText());
//        sv.setTiengAnh(Double.parseDouble(txtTiengAnh.getText()));
//        sv.setTinHoc(Double.parseDouble(txtTinHoc.getText()));
//        sv.setGiaoDucTC(Double.parseDouble(txtGiaoDuc.getText()));
//        sv.setDiemTB(sv.DiemTB());
//        lblTrungBinh.setText(String.format("%.1f", sv.getDiemTB()));
//        danhSachSv.add(sv);
//    }
//
//    public void updateSinhVien() {
//        int index = tblDanhSach.getSelectedRow();
//        if (index >= 1) {
//            SinhVien st = danhSachSv.get(index);
//            st.setMasv(txtMASV.getText());
//            st.setHoVaTen(txtHoTen.getText());
//            st.setTiengAnh(Double.parseDouble(txtTiengAnh.getText()));
//            st.setTinHoc(Double.parseDouble(txtTinHoc.getText()));
//            st.setGiaoDucTC(Double.parseDouble(txtGiaoDuc.getText()));
//            st.setDiemTB(st.DiemTB());
//            lblTrungBinh.setText(String.format("%.1f", st.getDiemTB()));
//        } else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên");
//
//        }
//    }
//
//    public void Doc() {
//        int index = tblDanhSach.getSelectedRow();
//        txtMASV.setText(danhSachSv.get(index).getMasv());
//        txtHoTen.setText(danhSachSv.get(index).getHoVaTen());
//        txtTiengAnh.setText(String.valueOf(danhSachSv.get(index).getTiengAnh()));
//        txtTinHoc.setText(String.valueOf(danhSachSv.get(index).getTinHoc()));
//        txtGiaoDuc.setText(String.valueOf(danhSachSv.get(index).getGiaoDucTC()));
//
//    }
//
//    public void Delete() {
//        int indexXoa = tblDanhSach.getSelectedRow();
//        if (indexXoa >= 1) {
//            danhSachSv.remove(indexXoa);
//            fillToTable();
//        } else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên");
//
//        }
//    }
//
//    public void Search() {
//        for (SinhVien sinhVien : danhSachSv) {
//            if (txtMSSv.getText().equals(sinhVien.getMasv())) {
//                txtMASV.setText(sinhVien.getMasv());
//                txtHoTen.setText(sinhVien.getHoVaTen());
//                txtTiengAnh.setText(String.valueOf(sinhVien.getTiengAnh()));
//                txtTinHoc.setText(String.valueOf(sinhVien.getTinHoc()));
//                txtGiaoDuc.setText(String.valueOf(sinhVien.getGiaoDucTC()));
//                lblTrungBinh.setText(String.format("%.1f", sinhVien.getDiemTB()));
//            }
//
//        }
//    }
    public void chuyen() {
        int index = tblDanhSach.getSelectedRow();
        if (index >= 0) { // Kiểm tra xem có hàng nào được chọn không
            int hangMoi = index + 2; // Tính toán chỉ số hàng mới để chuyển đến
            tblDanhSach.setRowSelectionInterval(hangMoi, hangMoi);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên");
        }
    }

    public void chuyenToiCuoiHang() {
        int index = tblDanhSach.getRowCount();
        if (index > 0) { // Kiểm tra xem có hàng nào trong bảng không
            int cuoiHang = index - 1; // Chỉ số của hàng cuối cùng trong bảng
            tblDanhSach.setRowSelectionInterval(cuoiHang, cuoiHang);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên");
        }
    }

    public void chuyenToiDauHang() {
        int index = tblDanhSach.getRowCount();
        if (index > 0) { // Kiểm tra xem có hàng nào trong bảng không
            int dauHang = 0; // Chỉ số của hàng đầu tiên trong bản

            tblDanhSach.setRowSelectionInterval(dauHang, dauHang);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên");
        }
    }

    public void chuyenLuiHang() {
        int index = tblDanhSach.getSelectedRow();
        if (index > 0) { // Kiểm tra xem có hàng nào trước đó trong bảng không
            int lui = index - 2; // Chỉ số của hàng trước đó
            // Đặt lựa chọn cho hàng trước đó
            tblDanhSach.setRowSelectionInterval(lui, lui);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblQuanLySV = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblMSSv = new javax.swing.JLabel();
        txtMSSv = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lblHoVaTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblMASV = new javax.swing.JLabel();
        txtMASV = new javax.swing.JTextField();
        lblTiengAnh = new javax.swing.JLabel();
        txtTiengAnh = new javax.swing.JTextField();
        lblTinHoc = new javax.swing.JLabel();
        txtTinHoc = new javax.swing.JTextField();
        lblTrungBinh = new javax.swing.JLabel();
        lblGiaoDuc = new javax.swing.JLabel();
        txtGiaoDuc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        tblDanhSach = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnChuyenlui = new javax.swing.JButton();
        btnChuyentiep = new javax.swing.JButton();
        btnChuyencuoi = new javax.swing.JButton();
        btnChuyenDau = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuanLySV.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuanLySV.setForeground(new java.awt.Color(51, 102, 255));
        lblQuanLySV.setText("Quản Lý Điểm Sinh Viên");

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTimKiem.setText("Tìm Kiếm");

        lblMSSv.setText("MSSV");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586855961_10d00122c07898b47099e5228d233896.jpg"))); // NOI18N
        btnTimKiem.setText("Search");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        lblHoVaTen.setText("Họ và tên");

        lblMASV.setText("MA SV");

        lblTiengAnh.setText("Tiếng Anh");

        lblTinHoc.setText("Tin Học");

        lblTrungBinh.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTrungBinh.setForeground(new java.awt.Color(0, 0, 204));

        lblGiaoDuc.setText("Giáo Dục TC");

        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("3. Sinh Viên có điểm cao nhất");

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "Ten", "Tieng Anh", "Tin Hoc", "GDTC", "Diem TB"
            }
        ));
        tblDanhSach.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDanhSachAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSach);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586908944_f4f3c21b0c55096e89f59f54d1be06c8.jpg"))); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586866335_3df334031c8e74f916ead7d578d723f2.jpg"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586896980_88d92557313d9e571872690eb69bff41.jpg"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586887917_3c34fed07f1be3d7a38faf96ee3c8b1e.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnChuyenlui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586877345_3fdd919d56ba0f539c5667ad96a6f58a.jpg"))); // NOI18N
        btnChuyenlui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenluiActionPerformed(evt);
            }
        });

        btnChuyentiep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586877346_124849d0b26267f17cf6a402e3fab243.jpg"))); // NOI18N
        btnChuyentiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyentiepActionPerformed(evt);
            }
        });

        btnChuyencuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586848508_869f7c1e5dde49a2b27271b34593b5ea.jpg"))); // NOI18N
        btnChuyencuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyencuoiActionPerformed(evt);
            }
        });

        btnChuyenDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asm1/ph54567/java2/z5264586855871_eebf41fb2d0ef0ba86c2e71075c23f91.jpg"))); // NOI18N
        btnChuyenDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDauActionPerformed(evt);
            }
        });

        jLabel1.setText("Diem TB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                        .addGap(0, 214, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblMASV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTiengAnh)
                                .addComponent(lblHoVaTen))
                            .addComponent(lblTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaoDuc))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMASV, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave)
                            .addComponent(btnNew))
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblQuanLySV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnChuyenDau)
                                .addGap(18, 18, 18)
                                .addComponent(btnChuyenlui, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnChuyentiep)
                                .addGap(31, 31, 31)
                                .addComponent(btnChuyencuoi))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMSSv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMSSv, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(347, 347, 347)
                                        .addComponent(lblTrungBinh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(btnTimKiem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUpdate)
                                            .addComponent(btnDelete))))))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblQuanLySV)
                .addGap(18, 18, 18)
                .addComponent(lblTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMSSv)
                    .addComponent(txtMSSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoVaTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMASV)
                            .addComponent(txtMASV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiengAnh))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTrungBinh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChuyenDau)
                            .addComponent(btnChuyenlui)
                            .addComponent(btnChuyentiep)
                            .addComponent(btnChuyencuoi)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)))
                .addGap(28, 28, 28)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        SinhVien sv = this.getFormData();
        SinhVienRepo.Save(sv);
        loadTable(SinhVienRepo.search(""));
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        SinhVien nv = this.getFormData();
        SinhVienRepo.Update(nv);
        loadTable(SinhVienRepo.search(""));
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String Masv = txtMASV.getText();
        SinhVienRepo.delete(Masv);
        loadTable(SinhVienRepo.search(""));
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblDanhSachAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDanhSachAncestorAdded

    }//GEN-LAST:event_tblDanhSachAncestorAdded

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtMASV.setText(null);
        txtHoTen.setText(null);
        txtTiengAnh.setText(null);
        txtTinHoc.setText(null);
        txtGiaoDuc.setText(null);
        txtMSSv.setText(null);

    }//GEN-LAST:event_btnNewActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        int index = tblDanhSach.getSelectedRow();
        String Masv = String.valueOf(tblDanhSach.getValueAt(index, 0));
        String Ten = String.valueOf(tblDanhSach.getValueAt(index, 1));
        String TiengAnh = String.valueOf(tblDanhSach.getValueAt(index, 2));
        String TinHoc = String.valueOf(tblDanhSach.getValueAt(index, 3));
        String GDTC = String.valueOf(tblDanhSach.getValueAt(index, 4));

        String diemTBStr = String.valueOf(tblDanhSach.getValueAt(index, 5));
        double diemTB = Double.parseDouble(diemTBStr);
        txtMASV.setText(Masv);
        txtHoTen.setText(Ten);
        txtTiengAnh.setText(TiengAnh);
        txtTinHoc.setText(TinHoc);
        txtGiaoDuc.setText(GDTC);

        lblTrungBinh.setText(String.format("%.2f", diemTB));


    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String kyword = txtMSSv.getText();
        loadTable(SinhVienRepo.search(kyword));
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnChuyentiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyentiepActionPerformed
        chuyen();
    }//GEN-LAST:event_btnChuyentiepActionPerformed

    private void btnChuyencuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyencuoiActionPerformed
        chuyenToiCuoiHang();
    }//GEN-LAST:event_btnChuyencuoiActionPerformed

    private void btnChuyenluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenluiActionPerformed
        chuyenLuiHang();
    }//GEN-LAST:event_btnChuyenluiActionPerformed

    private void btnChuyenDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDauActionPerformed
        chuyenToiDauHang();
    }//GEN-LAST:event_btnChuyenDauActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDau;
    private javax.swing.JButton btnChuyencuoi;
    private javax.swing.JButton btnChuyenlui;
    private javax.swing.JButton btnChuyentiep;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGiaoDuc;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblMASV;
    private javax.swing.JLabel lblMSSv;
    private javax.swing.JLabel lblQuanLySV;
    private javax.swing.JLabel lblTiengAnh;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTinHoc;
    private javax.swing.JLabel lblTrungBinh;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGiaoDuc;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMASV;
    private javax.swing.JTextField txtMSSv;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables


}
