package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dangky extends AppCompatActivity {
    public static String KEY_USERNAME = "username";
    public static String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        Button btnRegister = findViewById(R.id.btndangky);
        Button btntv = findViewById(R.id.btntrove);

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassWord);
        EditText edtRetypePassword = findViewById(R.id.edtlaiPassWord);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String nhaplai = edtRetypePassword.getText().toString();
                if (username.trim().isEmpty()) {
                    Toast.makeText(dangky.this, "Vui long nhap username", Toast.LENGTH_SHORT).show();
                } else if (password.trim().isEmpty()) {
                    Toast.makeText(dangky.this, "Vui long nhap password", Toast.LENGTH_SHORT).show();
                } else if (nhaplai.trim().isEmpty()) {
                    Toast.makeText(dangky.this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
                } else if (!nhaplai.equals(password)) {
                    Toast.makeText(dangky.this, "Password nhap lai khong khop", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(dangky.this, dangnhap.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_USERNAME, username);
                    bundle.putString(KEY_PASSWORD, password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        btntv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangky.this, dangnhap.class);
                startActivity(intent);
            }
        });
    }
}
