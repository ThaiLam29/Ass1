package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class quanlyns extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlynhansu);
        Button btnPhongban= findViewById(R.id.btnPhongban);
        Button btnNhansu= findViewById(R.id.btnNhanSu);
        Button btnExit= findViewById(R.id.btnExit);


        btnPhongban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(quanlyns.this, phongban.class);
               startActivity(intent);
            }
        });
        btnNhansu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quanlyns.this, nhanvien.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(quanlyns.this, dangnhap.class);
                startActivity(intent);
            }
        });
    }
}

