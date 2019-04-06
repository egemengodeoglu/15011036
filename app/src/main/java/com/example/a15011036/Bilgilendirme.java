package com.example.a15011036;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bilgilendirme extends AppCompatActivity {

    private TextView textView_isim;
    private TextView textView_soyisim;
    private TextView textView_kimlik;
    private TextView textView_telefon;
    private TextView textView_mail;
    private TextView textView_sehir;
    private TextView textView_tarih;
    private TextView textView_bilgi;
    private Button dersler_button;
    private ImageView kayit_resim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgilendirme);

        Bundle extras = getIntent().getExtras();
        String isim = extras.getString("isim");
        String soyisim= extras.getString("soyisim");
        String kimlik = extras.getString("kimlik");
        final String telefon= extras.getString("telefon");
        final String mail = extras.getString("mail");
        String sehir= extras.getString("sehir");
        String gun = extras.getString("gun");
        String ay= extras.getString("ay");
        String yil = extras.getString("yil");

        kayit_resim=(ImageView)findViewById(R.id.kaydet_imageView) ;
        String imageUrl = getIntent().getStringExtra("resim");
        if(!imageUrl.equals("0")) {
            Uri myUri = Uri.parse(imageUrl);
            kayit_resim.setImageURI(myUri);
        }

        dersler_button=(Button)findViewById(R.id.dersler_button);
        dersler_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Burada Buttona tıklandığında çalıştırılacak kodlar yer alıyor
                Intent i = new Intent(getBaseContext(), Dersler.class);
                startActivity(i);
            }
        });

        textView_isim = (TextView)findViewById(R.id.isim_textView2);
        textView_soyisim = (TextView)findViewById(R.id.soyisim_textView2);
        textView_kimlik = (TextView)findViewById(R.id.kimlik_textView2);
        textView_telefon = (TextView)findViewById(R.id.telefon_textView2);
        textView_bilgi=(TextView)findViewById(R.id.mailbilgi_textView2);
        textView_mail = (TextView)findViewById(R.id.mail_textView2);
        textView_sehir = (TextView)findViewById(R.id.sehir_textView2);
        textView_tarih = (TextView)findViewById(R.id.tarih_textView2);


        textView_isim.setText(String.valueOf("İsim: "+isim));
        textView_soyisim.setText(String.valueOf("Soyisim: "+soyisim));
        textView_kimlik.setText(String.valueOf("Kimlik no: "+kimlik));
        textView_telefon.setText(String.valueOf("Telefon: "+telefon));
        if(telefon.length()==0)
            textView_telefon.setClickable(false);
        else {
            textView_telefon.setClickable(true);
            textView_telefon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf("tel:" + telefon)));
                    startActivity(intent);
                }
            });
        }
        textView_mail.setText(mail);
        if(mail.length()==0)
            textView_mail.setClickable(false);
        else {
            textView_mail.setClickable(true);
            textView_mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mailFonk(mail);
                }
            });
        }
        textView_sehir.setText(String.valueOf("Şehir: "+sehir));
        textView_tarih.setText(String.valueOf("Tarih: "+gun+"/"+ay+"/"+yil));


    }

    public void mailFonk(String mail){
        try {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Konu");//Email konusu
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Mail");//Email içeriği
            startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mail);
            startActivity(emailIntent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
