package com.aan.taskit2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LihatTaskActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnEdit, btnKembali;
    TextView textNama, textTanggal, textWaktu, textDeskripsi, lblTanggal, lblWaktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_task);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Read Data");



        dbHelper = new DataHelper(this);
        textNama = (TextView) findViewById(R.id.text_nama);
        textTanggal = (TextView) findViewById(R.id.text_tanggal);
        textWaktu = (TextView) findViewById(R.id.text_waktu);
        textDeskripsi = (TextView) findViewById(R.id.text_deskripsi);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        btnKembali = (Button) findViewById(R.id.btn_kembali);
        lblTanggal = (TextView) findViewById(R.id.lbl_tanggal);
        lblWaktu = (TextView) findViewById(R.id.lbl_waktu);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tasks WHERE task_nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            textNama.setText(cursor.getString(1).toString());
            textTanggal.setText(cursor.getString(2).toString());
            textWaktu.setText(cursor.getString(3).toString());
            textDeskripsi.setText(cursor.getString(4).toString());
        }

        if (TextUtils.isEmpty(textTanggal.getText())) {
            lblTanggal.setVisibility(View.GONE);
            textTanggal.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(textWaktu.getText())) {
            lblWaktu.setVisibility(View.GONE);
            textWaktu.setVisibility(View.GONE);
        }

        btnKembali.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}