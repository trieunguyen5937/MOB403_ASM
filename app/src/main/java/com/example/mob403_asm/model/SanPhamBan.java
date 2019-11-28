package com.example.mob403_asm.model;

import java.util.Date;

public class SanPhamBan {
    private String _id;
    private String tenSp, moTaSp, nhaCungCap, thuongHieu, xuatSu, kichThuoc, loaiSp, danhMuc, ngayDang;
    private double giaBan;
    private String[] hinhSp;
    private int dangBan; //trạng thái nhà đang bán hay đã bán, 1 là đang bán, 0 là đã bán

    public SanPhamBan() {
    }

    public SanPhamBan(String tenSp, double giaBan) {
        this.tenSp = tenSp;
        this.giaBan = giaBan;
    }

    public SanPhamBan(String tenSp, String moTaSp, String nhaCungCap, String thuongHieu, String xuatSu, String kichThuoc, String loaiSp, String danhMuc, String ngayDang, double giaBan, String[] hinhSp, int dangBan) {
        this.tenSp = tenSp;
        this.moTaSp = moTaSp;
        this.nhaCungCap = nhaCungCap;
        this.thuongHieu = thuongHieu;
        this.xuatSu = xuatSu;
        this.kichThuoc = kichThuoc;
        this.loaiSp = loaiSp;
        this.danhMuc = danhMuc;
        this.ngayDang = ngayDang;
        this.giaBan = giaBan;
        this.hinhSp = hinhSp;
        this.dangBan = dangBan;
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

    public String getMoTaSp() {
        return moTaSp;
    }

    public void setMoTaSp(String moTaSp) {
        this.moTaSp = moTaSp;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(String xuatSu) {
        this.xuatSu = xuatSu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String[] getHinhSp() {
        return hinhSp;
    }

    public void setHinhSp(String[] hinhSp) {
        this.hinhSp = hinhSp;
    }

    public int getDangBan() {
        return dangBan;
    }

    public void setDangBan(int dangBan) {
        this.dangBan = dangBan;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }
}
