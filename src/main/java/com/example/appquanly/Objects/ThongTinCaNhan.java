package com.example.appquanly.Objects;

public class ThongTinCaNhan {
    public String getHinhCaNhan() {
        return HinhCaNhan;
    }

    public void setHinhCaNhan(String hinhCaNhan) {
        HinhCaNhan = hinhCaNhan;
    }

    private  String HinhCaNhan;
    public int getIDCaNhan() {
        return IDCaNhan;
    }

    public void setIDCaNhan(int IDCaNhan) {
        this.IDCaNhan = IDCaNhan;
    }

    private int IDCaNhan;

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    private String HoTen;

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    private  String NgaySinh;

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    private int SDT;

    public int getIDLopHoc() {
        return IDLopHoc;
    }

    public void setIDLopHoc(int IDLopHoc) {
        this.IDLopHoc = IDLopHoc;
    }

    private  int IDLopHoc;
    public ThongTinCaNhan(int idCaNhan, String hoTen, String ngaySinh, int sdt, int idLopHoc, String hinhCaNhan)
    {
        this.IDCaNhan = idCaNhan;
        this.HoTen = hoTen;
        this.NgaySinh = ngaySinh;
        this.SDT = sdt;
        this.IDLopHoc = idLopHoc;
        this.HinhCaNhan = hinhCaNhan;
    }

}
