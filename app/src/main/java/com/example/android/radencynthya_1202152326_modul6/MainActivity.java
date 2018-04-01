package com.example.android.radencynthya_1202152326_modul6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText user; // deklarasi variabel
    private EditText pass; // deklarasi variabel
    private FirebaseAuth firebaseAuth; // deklarasi variabel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.textView); // untuk bisa mengakses textview dari layout
        pass = (EditText) findViewById(R.id.textView2); // untuk bisa mengakses textview dari layout
        firebaseAuth = FirebaseAuth.getInstance(); // inisiasi dari firebase
    }

    public void Login(View view) { // method untuk menjalankan button login
        (firebaseAuth.signInWithEmailAndPassword(user.getText().toString(), pass.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show(); // menampilkan pesan apabila sudah berhasil login
                            Intent intent = new Intent(MainActivity.this, Home.class); // untuk pindah ke halaman home
                            startActivity(intent);
                        }else{
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void Register(View view) { // method untuk menjalankan method register
        (firebaseAuth.createUserWithEmailAndPassword(user.getText().toString(), pass.getText().toString())).addOnCompleteListener
                (new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show(); // menampilkan pesan apabila sudah berhasil daftar
                        }
                        else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}