package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dangnhap extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        Button btndki = findViewById(R.id.btn_signout);
        Button btnlogin = findViewById(R.id.btn_login);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);

        String sUserName = getIntent().getStringExtra(dangky.Nam);
        String sPassword = getIntent().getStringExtra(dangky.Nhap);

        edtUsername.setText(sUserName);
        edtPassword.setText(sPassword);

        int number = getIntent().getIntExtra("number", 0);
        Toast.makeText(this, number + "", Toast.LENGTH_SHORT).show();

        Button btnRegister = findViewById(R.id.btn_signout);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btndki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), dangky.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                if (ten == null || ten.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "cần nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                } else if (pass == null || pass.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Cần nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), quanlyns.class);
                    startActivity(intent);
                }
            }
        });
    }
}
