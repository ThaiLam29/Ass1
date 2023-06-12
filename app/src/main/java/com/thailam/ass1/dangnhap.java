package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class dangnhap extends AppCompatActivity {
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);


        Button btndki = findViewById(R.id.btn_signout);
        Button btnlogin = findViewById(R.id.btn_login);
        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);


        RadioButton rdoremember = findViewById(R.id.remeber);


        int number = getIntent().getIntExtra("number", 0);
        Toast.makeText(this, number + "", Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(dangky.KEY_USERNAME);
            password = bundle.getString(dangky.KEY_PASSWORD);
        }

        btndki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, dangky.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                if (ten.trim().isEmpty()) {
                    Toast.makeText(dangnhap.this, "Chưa nhập tài khoản ", Toast.LENGTH_SHORT).show();
                } else if (pass.trim().isEmpty()) {
                    Toast.makeText(dangnhap.this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else if (!ten.equals(username) && !pass.equals(password)) {
                    Toast.makeText(dangnhap.this, "Sai tài khoản hoặc mật khẩu ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(dangnhap.this, quanlyns.class));
                }
            }
        });
    }

}
