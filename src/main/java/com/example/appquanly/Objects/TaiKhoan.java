package com.example.appquanly.Objects;

public class TaiKhoan {
    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    private String TenDangNhap;

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    private String MatKhau;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;

    public int getIDPhanQuyen() {
        return IDPhanQuyen;
    }

    public void setIDPhanQuyen(int IDPhanQuyen) {
        this.IDPhanQuyen = IDPhanQuyen;
    }

    private int IDPhanQuyen;
    public TaiKhoan(String tenDangNhap ,String matKhau, int iD, int iDPhanQuyen)
    {
       this.TenDangNhap=tenDangNhap;
       this.MatKhau =  matKhau ;
       this.ID = iD;
       this.IDPhanQuyen = iDPhanQuyen;
    }
}
