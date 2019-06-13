package com.example.appquanly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appquanly.Objects.LopHoc;
import com.example.appquanly.R;

import java.util.List;

public class AdapterLopHoc extends BaseAdapter {
    private Context context;
    private  int resource;
    private List<LopHoc> ListLopHoc;
    @Override
    public int getCount() {
        return ListLopHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  AdapterLopHoc(Context context, int resource, List<LopHoc> listLopHoc) {
        this.context = context;
        this.resource = resource;
        this.ListLopHoc= listLopHoc;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_lophoc,parent,false);
        TextView TenLopHoc = convertView.findViewById(R.id.TenLopHoc);
        TextView SoThongBao = convertView.findViewById(R.id.SoThongBao);

        final LopHoc lopHoc = ListLopHoc.get(position);
        final int index = position;
        TenLopHoc.setText("Lớp : "+lopHoc.getTenLopHoc());
        SoThongBao.setText(lopHoc.getSoThongBao()+" Thông Báo");
        return convertView;
    }
}
