package com.example.a15011036;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Giris extends AppCompatActivity {

    private TextView textView_kullanici;
    private TextView textView_sifre;
    private EditText text_kullanici;
    private EditText text_sifre;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        textView_kullanici = (TextView)findViewById(R.id.textView);
        textView_sifre = (TextView)findViewById(R.id.textView2);
        text_kullanici = (EditText)findViewById(R.id.kullanici);
        text_sifre = (EditText)findViewById(R.id.sifre);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { //Burada Buttona tıklandığında çalıştırılacak kodlar yer alıyor.
                String tmp=text_kullanici.getText().toString();
                String tmp2=text_sifre.getText().toString();
                if(tmp.equals("admin") && tmp2.equals("password")) {
                    Intent i = new Intent(getBaseContext(), Kayit.class);
                    startActivity(i);
                }else{
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Giris.this);
                    dlgAlert.setMessage("Kullanıcı adı ve ya şifre hatalı!");
                    dlgAlert.setTitle("Hata");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }


            }
        });


    }
}

