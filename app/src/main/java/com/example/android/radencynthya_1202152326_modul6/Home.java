package com.example.android.radencynthya_1202152326_modul6;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout); // untuk menambahkan tab
        tabLayout.addTab(tabLayout.newTab().setText("TERBARU")); // untuk menambahkan tab terbaru
        tabLayout.addTab(tabLayout.newTab().setText("FOTO SAYA")); // untuk menambahkan tab foto saya
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); //


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); // agar ada aksi di tombol tambahkan foto
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // method agar bisa ada option yang dipojok atas
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void tekan(View view) {

    }

    public void out(MenuItem item) { // menthod untuk menjalankan logout
        Intent intent = new Intent(Home.this, MainActivity.class); // untuk pindah ke halaman awal
        startActivity(intent);
    }
}