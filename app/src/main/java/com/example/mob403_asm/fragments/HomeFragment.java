package com.example.mob403_asm.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.GridView;

import com.example.mob403_asm.R;
import com.example.mob403_asm.adapter.SanPhamAdapter;
import com.example.mob403_asm.model.SanPhamBan;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    GridView gridView;
    SanPhamAdapter sanPhamAdapter;
    ArrayList<SanPhamBan> listSanPham;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // SET ADAPTER
        gridView = view.findViewById(R.id.gridView);
        populateData();
        sanPhamAdapter = new SanPhamAdapter(getContext(), listSanPham);
        gridView.setAdapter(sanPhamAdapter);


        return view;
    }

    public void populateData() {
        listSanPham = new ArrayList<>();
        listSanPham.add(new SanPhamBan("iPhone 11", 21000000));
        listSanPham.add(new SanPhamBan("iPhone 11 Pro", 28990000));
        listSanPham.add(new SanPhamBan("iPhone 11 Pro Max", 33000000));
        listSanPham.add(new SanPhamBan("Macbook Pro 16", 61000000));
        listSanPham.add(new SanPhamBan("iPad Pro 2019", 18000000));
        listSanPham.add(new SanPhamBan(
                "Apple Watch Series 5 GPS",
                "Đồng hồ thông minh Apple Watch thế hệ thứ 5 với GPS",
                "FPT trading",
                "Apple",
                "Mỹ",
                "40 x 34 x 10.7 mm",
                "Đồng hồ thông minh",
                "Đồ công nghệ",
                "28/11/2019",
                11690000,
                new String[]{
                        "https://images.fpt.shop/unsafe/fit-in/200x200/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/10/15/637067332334331058_series-5-vien-nhom-44-caosu-den-dd.png",
                        "https://images.fpt.shop/unsafe/fit-in/200x200/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/10/15/637067336891983180_series-5-vien-nhom-44-caosu-hong-dd.png",
                        "https://images.fpt.shop/unsafe/fit-in/200x200/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/10/15/637067317313557277_series-5-vien-nhom-caosu-trang-dd.png"
                },
                1));
    }
}
