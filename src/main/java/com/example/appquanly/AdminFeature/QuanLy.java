package com.example.appquanly.AdminFeature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appquanly.R;

public class QuanLy extends AppCompatActivity {
    private String TenDangNhap,MatKhau;
    private  int IDTaiKhoan,IDPhanQuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        Intent intent = this.getIntent();
        TenDangNhap = intent.getStringExtra("TenDangNhap");
        MatKhau = intent.getStringExtra("MatKhau");
        IDTaiKhoan =intent.getIntExtra("IDTaiKhoan",0);
        IDPhanQuyen =intent.getIntExtra("IDPhanQuyen",0);
        //Toast.makeText(getApplicationContext(),TenDangNhap+" "+MatKhau+" "+IDPhanQuyen+" "+IDTaiKhoan,Toast.LENGTH_LONG).show();
    }
}
