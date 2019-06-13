package com.example.appquanly.UserFeature;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.appquanly.Adapter.AdapterLopHoc;;
import com.example.appquanly.Objects.LopHoc;
import com.example.appquanly.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.appquanly.MainActivity.dataBase;

public class XemThongBao extends AppCompatActivity {
    ListView lv;
    ArrayList<LopHoc> arrayLopHoc;
    AdapterLopHoc adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thong_bao);
        lv = this.findViewById(R.id.danhsachthongbao);
        LayDanhSachLopHoc();
        adapter = new AdapterLopHoc(this, R.layout.custom_lophoc,arrayLopHoc);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public ArrayList<LopHoc> LayDanhSachLopHoc()
    {
        arrayLopHoc = new ArrayList<>();
        String sql = " Select LopHoc.TenLopHoc,count(LopHoc.IDLopHoc) as SoThongBao From LopHoc,ThongBao WHERE LopHoc.IDLopHoc = ThongBao.IDLopHoc GROUP BY LopHoc.IDLopHoc";
        Cursor c= dataBase.getData(sql);
        if(c!=null)
        {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                arrayLopHoc.add(new LopHoc(c.getString(0),c.getInt(1)));
                c.moveToNext();
            }
        }
        return arrayLopHoc;
    }
}
