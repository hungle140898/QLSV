package com.example.appquanly.UserFeature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appquanly.R;

public class ChucNang extends AppCompatActivity {
    private String TenDangNhap,MatKhau;
    private  int IDTaiKhoan,IDPhanQuyen;
    private Button btnXemThongTin,btnXemThongBao,btnXemDiem,btnXemBaiHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang);
        btnXemBaiHoc = this.findViewById(R.id.btnXemBaiHoc);
        btnXemDiem = this.findViewById(R.id.btnXemDiem);
        btnXemThongBao = this.findViewById(R.id.btnXemThongBao);
        btnXemThongTin = this.findViewById(R.id.btnXemThongTin);
        final Intent intent = this.getIntent();
        TenDangNhap = intent.getStringExtra("TenDangNhap");
        MatKhau = intent.getStringExtra("MatKhau");
        IDTaiKhoan =intent.getIntExtra("IDTaiKhoan",0);
        IDPhanQuyen =intent.getIntExtra("IDPhanQuyen",0);
        Toast.makeText(getApplicationContext(),TenDangNhap+" "+MatKhau+" "+IDPhanQuyen+" "+IDTaiKhoan,Toast.LENGTH_LONG).show();
        btnXemThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChucNang.this, XemThongTin.class);
                //intent1.putExtra("TenTK",TenDangNhap);
                intent1.putExtra("IDTaiKhoan",IDTaiKhoan);
                startActivity(intent1);
            }
        });
        btnXemThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (ChucNang.this, XemThongBao.class);
                startActivity((intent2));
            }
        });
    }
}
