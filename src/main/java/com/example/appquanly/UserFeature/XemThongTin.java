package com.example.appquanly.UserFeature;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appquanly.Objects.LopHoc;
import com.example.appquanly.Objects.ThongTinCaNhan;
import com.example.appquanly.R;

import java.util.ArrayList;

import static com.example.appquanly.MainActivity.dataBase;

public class XemThongTin extends AppCompatActivity {
    TextView HoTen,NgaySinh,SDT;
    ListView LopHoc;
    ImageView HinhCaNhan;
    private int ID;
    ArrayList<ThongTinCaNhan> arrayThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thong_tin);
        final Intent intent = this.getIntent();
        ID = intent.getIntExtra("IDTaiKhoan",0);
        HoTen =this.findViewById(R.id.HoTen);
        NgaySinh =this.findViewById(R.id.NgaySinh);
        SDT = this.findViewById(R.id.SDT);
        LopHoc = this.findViewById(R.id.LopHoc);
        HinhCaNhan = this.findViewById(R.id.HinhCaNhan);
        LayThongTinCaNhan(ID);
            HoTen.setText("Họ & Tên     : " + arrayThongTin.get(0).getHoTen());
            NgaySinh.setText("Ngày Sinh   : " + arrayThongTin.get(0).getNgaySinh());
            SDT.setText("Số ĐT           : " + String.valueOf(arrayThongTin.get(0).getSDT()));
            int ImageID = getMipmapResIdByName(arrayThongTin.get(0).getHinhCaNhan());
            HinhCaNhan.setImageResource(ImageID);
    }
    public ArrayList<ThongTinCaNhan> LayThongTinCaNhan(int ID)
    {
        arrayThongTin = new ArrayList<>();
        String sql = "select * from ThongTinCaNhan where IDCaNhan = "+ID;
        Cursor c = dataBase.getData(sql);
        if(c!=null)
        {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                arrayThongTin.add(new ThongTinCaNhan(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getInt(4),c.getString(5)));
                c.moveToNext();
            }
        }
        return arrayThongTin;
    }
    public int getMipmapResIdByName(String resName) {
        String pkgName = getApplicationContext().getPackageName();
        int resID = getApplicationContext().getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
}
