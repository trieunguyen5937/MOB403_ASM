package com.example.mob403_asm.model;

import java.util.Date;

public class SanPhamBan {
    private String _id;
    private String tenSp, mieuTa, id_nguoiBan;
    private double giaBan;
    private String ngayDang;
    private byte[] hinhSp;
    private String danhMuc;
    private int dangBan; //trạng thái nhà đang bán hay đã bán, 1 là đang bán, 0 là đã bán

    public SanPhamBan() {
    }

    public SanPhamBan(String _id, String tenSp, String mieuTa, String id_nguoiBan, double giaBan, String ngayDang, byte[] hinhSp, int dangBan) {
        this._id = _id;
        this.tenSp = tenSp;
        this.mieuTa = mieuTa;
        this.id_nguoiBan = id_nguoiBan;
        this.giaBan = giaBan;
        this.ngayDang = ngayDang;
        this.hinhSp = hinhSp;
        this.dangBan = dangBan;
    }

    public SanPhamBan(String tenSp, String mieuTa, double giaBan, String ngayDang, int dangBan) {
        this.tenSp = tenSp;
        this.mieuTa = mieuTa;
        this.giaBan = giaBan;
        this.ngayDang = ngayDang;
        this.dangBan = dangBan;
    }

    public SanPhamBan(String tenSp, String mieuTa, double giaBan) {
        this.tenSp = tenSp;
        this.mieuTa = mieuTa;
        this.giaBan = giaBan;
    }

    public SanPhamBan(String tenSp, double giaBan) {
        this.tenSp = tenSp;
        this.giaBan = giaBan;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public String getId_nguoiBan() {
        return id_nguoiBan;
    }

    public void setId_nguoiBan(String id_nguoiBan) {
        this.id_nguoiBan = id_nguoiBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public byte[] getHinhSp() {
        return hinhSp;
    }

    public void setHinhSp(byte[] hinhSp) {
        this.hinhSp = hinhSp;
    }

    public int getDangBan() {
        return dangBan;
    }

    public void setDangBan(int dangBan) {
        this.dangBan = dangBan;
    }
}
