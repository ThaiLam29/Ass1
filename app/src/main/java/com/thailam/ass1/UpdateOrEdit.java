package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateOrEdit   extends AppCompatActivity {
    public static String KEY_ma = "Ma_sua";
    public static String KEY_Name = "Name_sua";
    public static String KEY_Phongban = "phong ban";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);


        TextView txtMa = findViewById(R.id.edt_manv);
        TextView txtTen = findViewById(R.id.edt_hoten);
        TextView txtpb = findViewById(R.id.edt_pb);

        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ma= txtMa.getText().toString();
                String Name= txtTen.getText().toString();
                String phongban= txtpb.getText().toString();

                Intent intent = new Intent(UpdateOrEdit.this, nhanvien.class);
                intent.putExtra(KEY_ma, Ma);
                intent.putExtra(KEY_Name, Name);
                intent.putExtra(KEY_Phongban, phongban);
                startActivity(intent);
            }
        });
    }
}
