package com.thailam.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dangky extends AppCompatActivity {
    public static String Nam = "user_name";
    public static String Nhap = "passwork";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btntv = findViewById(R.id.btntrove);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        EditText edtRetypePassword = findViewById(R.id.edtlaiPassWord);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate o nhap trong, password nhap lai dung
                String sUserName = edtUsername.getText().toString();
                String sPassword = edtPassword.getText().toString();
                String sRetypePass = edtRetypePassword.getText().toString();

                if (sUserName == null || sUserName.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Can nhap ten!", Toast.LENGTH_SHORT).show();
                } else if (sPassword == null || sPassword.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Can nhap mat khau!", Toast.LENGTH_SHORT).show();
                } else if (sRetypePass == null || sRetypePass.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Can nhap lai mat khau!", Toast.LENGTH_SHORT).show();
                } else if (!sRetypePass.equals(sPassword)) {
                    Toast.makeText(getApplicationContext(), "mat khai nhap lai chua dung!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), dangnhap.class);

                    intent.putExtra(Nam, sUserName);
                    intent.putExtra(Nhap, sPassword);

                    intent.putExtra("number", 18);

                    startActivity(intent);
                }

            }
        });

    }
}
