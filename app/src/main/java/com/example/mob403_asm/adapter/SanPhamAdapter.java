package com.example.mob403_asm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mob403_asm.R;
import com.example.mob403_asm.model.SanPhamBan;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPhamBan> listSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPhamBan> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @Override
    public Object getItem(int position) {
        return listSanPham.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        ImageView ivSanPham;
        TextView tvTenSp, tvGiaBan;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.one_item_san_pham, null);
            holder.ivSanPham = view.findViewById(R.id.ivSanPham);
            holder.tvTenSp = view.findViewById(R.id.tvTenSp);
            holder.tvGiaBan = view.findViewById(R.id.tvGiaBan);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SanPhamBan sanPhamBan = listSanPham.get(index);

        //format gia ban
        double VND = sanPhamBan.getGiaBan();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String giaFormatted = currencyVN.format(VND);

        holder.tvTenSp.setText(sanPhamBan.getTenSp());
        holder.tvGiaBan.setText(giaFormatted);

        String[] urls = sanPhamBan.getHinhSp();
        if (urls != null) {
            Glide.with(context.getApplicationContext())
                    .load(urls[0])
                    .into(holder.ivSanPham);
        } else {
            // do nothing
        }

        return view;
    }
}
