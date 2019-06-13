package com.example.appquanly.Objects;

public class LopHoc {
    public int getIDLopHoc() {
        return IDLopHoc;
    }

    public void setIDLopHoc(int IDLopHoc) {
        this.IDLopHoc = IDLopHoc;
    }

    private int IDLopHoc;

    public String getTenLopHoc() {
        return TenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        TenLopHoc = tenLopHoc;
    }

    private String TenLopHoc;
    public LopHoc(String tenLopHoc,int soThongBao)
    {
        this.TenLopHoc = tenLopHoc;
        this.SoThongBao = soThongBao;
    }

    public int getSoThongBao() {
        return SoThongBao;
    }

    public void setSoThongBao(int soThongBao) {
        SoThongBao = soThongBao;
    }

    private int SoThongBao;

}
