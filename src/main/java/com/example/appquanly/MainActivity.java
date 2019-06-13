package com.example.appquanly;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appquanly.AdminFeature.QuanLy;
import com.example.appquanly.DataBase.DataBase;
import com.example.appquanly.Objects.TaiKhoan;
import com.example.appquanly.UserFeature.ChucNang;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static DataBase dataBase;
    EditText TenDangNhap,MatKhau;
    Button btnDangNhap;
    String tenDangNhap,matKhau;
    ArrayList<TaiKhoan> arrayTaiKhoan;
    int Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TenDangNhap = this.findViewById(R.id.TenDangNhap);
        MatKhau = this.findViewById(R.id.MatKhau);
        btnDangNhap = this.findViewById(R.id.buttonDangNhap);
        dataBase = new DataBase(this,"qlsv.db",null,1);
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(TenDangNhap TEXT NOT NULL, MatKhau TEXT NOT NULL, IDTaiKhoan INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, IDPhanQuyen INTEGER NOT NULL) ");
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tenDangNhap = TenDangNhap.getText().toString().trim();
                matKhau = MatKhau.getText().toString().trim();
                KiemTraTaiKhoan(tenDangNhap, matKhau);
                if (arrayTaiKhoan.size() != 0) {
                    for (int i = 0; i < arrayTaiKhoan.size(); i++) {
                        if (arrayTaiKhoan.get(i).getIDPhanQuyen() == 1) {
                            Intent intent = new Intent(getApplicationContext(), QuanLy.class);
                            intent.putExtra("TenDangNhap",tenDangNhap);
                            intent.putExtra("MatKhau",matKhau);
                            intent.putExtra("IDTaiKhoan",arrayTaiKhoan.get(i).getID());
                            intent.putExtra("IDPhanQuyen",arrayTaiKhoan.get(i).getIDPhanQuyen());
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(getApplicationContext(), ChucNang.class);
                            intent.putExtra("TenDangNhap",tenDangNhap);
                            intent.putExtra("MatKhau",matKhau);
                            intent.putExtra("IDTaiKhoan",arrayTaiKhoan.get(i).getID());
                            intent.putExtra("IDPhanQuyen",arrayTaiKhoan.get(i).getIDPhanQuyen());
                            startActivity(intent);
                        }
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sai Ten dang nhap ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public List<TaiKhoan> KiemTraTaiKhoan(String tdn,String mk) {
        arrayTaiKhoan = new ArrayList<>();
        String sql = "select * from TaiKhoan where TenDangNhap = '" +
                tdn + "' and MatKhau = '" + mk + "'";
        Cursor c = dataBase.getData(sql);
        if (c != null) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                arrayTaiKhoan.add(new TaiKhoan(c.getString(0), c.getString(1), c.getInt(2), c.getInt(3)));
                c.moveToNext();
            }
        }
        return arrayTaiKhoan;
    }
}
