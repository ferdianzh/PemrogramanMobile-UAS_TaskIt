package com.aan.taskit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        TextView textLogin = (TextView) findViewById(R.id.tv_login);
        EditText editUsername = (EditText) findViewById(R.id.edit_username);
        EditText editPassword = (EditText) findViewById(R.id.edit_password);
        EditText editKonfpassword = (EditText) findViewById(R.id.edit_konfirmpassword);
        TextView textBuatakun = (TextView) findViewById(R.id.text_buatakun);
        Button btnLogin = (Button) findViewById(R.id.btn_login);

        final Intent intent = getIntent();
        if (intent.hasExtra("isRegis")) {
            textLogin.setText("Registrasi");
            editKonfpassword.setVisibility(View.VISIBLE);
            textBuatakun.setText("Batal");
            btnLogin.setText("Daftar");
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intent.hasExtra("isRegis")) {
                    finish();
                } else {
                    Intent in = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(in);
                    finish();
                }
            }
        });

        textBuatakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intent.hasExtra("isRegis")) {
                    finish();
                } else {
                    Intent in = new Intent(LoginActivity.this, LoginActivity.class);
                    boolean isRegis = true;
                    in.putExtra("isRegis", isRegis);
                    startActivity(in);
                }
            }
        });
    }
}