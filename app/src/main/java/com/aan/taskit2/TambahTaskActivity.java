package com.aan.taskit2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TambahTaskActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSimpan, btnKembali;
    EditText editNama, editTanggal, editWaktu, editDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_task);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Add Data");

        dbHelper = new DataHelper(this);
        editNama = (EditText) findViewById(R.id.edit_nama);
        editTanggal = (EditText) findViewById(R.id.edit_tanggal);
        editWaktu = (EditText) findViewById(R.id.edit_waktu);
        editDeskripsi = (EditText) findViewById(R.id.edit_deskripsi);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);
        btnKembali = (Button) findViewById(R.id.btn_kembali2);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (TextUtils.isEmpty(editNama.getText()) ||
                        TextUtils.isEmpty(editDeskripsi.getText()) ) {

                    Toast.makeText(getApplicationContext(),"Nama dan deskripsi harus diisi",Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into tasks(task_nama, task_tgl, task_waktu, task_deskripsi) values('" +
                            editNama.getText().toString() + "','" +
                            editTanggal.getText().toString() + "','" +
                            editWaktu.getText().toString() + "','" +
                            editDeskripsi.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    MainActivity.ma.RefreshList();
                    finish();
                }
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}