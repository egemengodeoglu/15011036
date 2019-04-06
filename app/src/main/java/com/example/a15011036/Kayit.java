package com.example.a15011036;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.provider.MediaStore;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {

    private String[] sehirler={"01 Adana","02 Adıyaman","03 Afyon","04 Ağrı","05 Amasya","06 Ankara","07 Antalya","08 Artvin",
            "09 Aydın","10 Balıkesir","11 Bilecik","12 Bingöl","13 Bitlis","14 Bolu","15 Burdur","16 Bursa","17 Çanakkale",
            "18 Çankırı","19 Çorum","20 Denizli","21 Diyarbakır","22 Edirne","23 Elazığ","24 Erzincan","25 Erzurum","26 Eskişehir",
            "27 Gaziantep","28 Giresun","29 Gümüşhane","30 Hakkari","31 Hatay","32 Isparta","33 İçel","34 İstanbul","35 İzmir",
            "36 Kars","37 Kastamonu","38 Kayseri","39 Kırklareli","40 Kırşehir","41 Kocaeli","42 Konya","43 Kütahya","44 Malatya",
            "45 Manisa","46 K.maraş","47 Mardin","48 Muğla","49 Muş","50 Nevşehir","51 Niğde","52 Ordu","53 Rize","54 Sakarya",
            "55 Samsun","56 Siirt","57 Sinop","58 Sivas","59 Tekirdağ","60 Tokat","61 Trabzon","62 Tunceli","63 Şanlıurfa","64 Uşak",
            "65 Van","66 Yozgat","67 Zonguldak","68 Aksaray","69 Bayburt","70 Karaman","71 Kırıkkale","72  Batman","73 Şırnak",
            "74 Bartın","75 Ardahan","76 Iğdır","77 Yalova","78 Karabük","79 Kilis","80 Osmaniye","81 Düzce"};
    private Integer[] gunler={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    private Integer[] aylar={1,2,3,4,5,6,7,8,9,10,11,12};
    private Integer[] yillar={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018};
    private TextView textView_isim;
    private TextView textView_soyisim;
    private TextView textView_kimlik;
    private TextView textView_telefon;
    private TextView textView_mail;
    private TextView textView_sehir;
    private TextView textView_tarih;
    private EditText isim_editText;
    private EditText soyisim_editText;
    private EditText kimlik_editText;
    private EditText telefon_editText;
    private EditText mail_editText;
    private Spinner spinner_sehir;
    private Spinner spinner_gun;
    private Spinner spinner_ay;
    private Spinner spinner_yil;
    private ArrayAdapter<String> dataAdapterForSehirler;
    private ArrayAdapter<Integer> dataAdapterForGunler;
    private ArrayAdapter<Integer> dataAdapterForAylar;
    private ArrayAdapter<Integer> dataAdapterForYillar;

    private Button kaydet_button;
    private Button temizle_button;

    private ImageView pp;
    private Button galeri_button;
    private Uri secilen;

    private static  final int REQUEST_CODE=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        //////////////////////////////////////////////////////////////////////////
        textView_isim = (TextView)findViewById(R.id.isim_Textview);
        textView_soyisim = (TextView)findViewById(R.id.soyisim_Textview);
        textView_kimlik = (TextView)findViewById(R.id.kimlik_Textview);
        textView_telefon = (TextView)findViewById(R.id.telefon_TextView);
        textView_mail = (TextView)findViewById(R.id.mail_TextView);
        textView_sehir = (TextView)findViewById(R.id.sehir_Textview);
        textView_tarih = (TextView)findViewById(R.id.tarih_Textview);

        isim_editText = (EditText)findViewById(R.id.isim_editText);
        soyisim_editText = (EditText)findViewById(R.id.soyisim_editText);
        kimlik_editText = (EditText)findViewById(R.id.kimlik_editText);
        telefon_editText = (EditText)findViewById(R.id.telefon_editText);
        mail_editText = (EditText)findViewById(R.id.mail_editText);


        spinner_sehir = (Spinner) findViewById(R.id.sehir_spinner);
        dataAdapterForSehirler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sehirler);
        dataAdapterForSehirler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sehir.setAdapter(dataAdapterForSehirler);
        spinner_sehir.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_sehir.getSelectedView()).setTextColor(Color.WHITE);
            }
        });



        spinner_gun = (Spinner) findViewById(R.id.gun_spinner);
        dataAdapterForGunler = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, gunler);
        dataAdapterForGunler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gun.setAdapter(dataAdapterForGunler);
        spinner_gun.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_gun.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        spinner_ay = (Spinner) findViewById(R.id.ay_spinner);
        dataAdapterForAylar = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, aylar);
        dataAdapterForAylar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ay.setAdapter(dataAdapterForAylar);
        spinner_ay.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_ay.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        spinner_yil = (Spinner) findViewById(R.id.yil_spinner);
        dataAdapterForYillar = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, yillar);
        dataAdapterForYillar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_yil.setAdapter(dataAdapterForYillar);
        spinner_yil.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_yil.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        kaydet_button=(Button) findViewById(R.id.kaydet_button);

        kaydet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Burada Buttona tıklandığında çalıştırılacak kodlar yer alıyor
                boolean control=true;

                if(isim_editText.getText().length()>20) {
                    Toast.makeText(v.getContext(), "İsim çok uzun.\nLütfen 20 karakterden kısa giriniz.", Toast.LENGTH_LONG).show();
                    control=false;
                } else if(isim_editText.getText().length()==0) {
                    Toast.makeText(v.getContext(), "İsim boş olamaz.\nLütfen bir isim giriniz", Toast.LENGTH_LONG).show();
                    control=false;
                }else if(soyisim_editText.getText().length()>16) {
                    Toast.makeText(v.getContext(), "Soyisim çok uzun.\nLütfen 16 karakterden kısa giriniz", Toast.LENGTH_LONG).show();
                    control=false;
                }else if(soyisim_editText.getText().length()==0) {
                    Toast.makeText(v.getContext(), "Soyisim boş olamaz.\nLütfen bir soyisim giriniz", Toast.LENGTH_LONG).show();
                    control=false;
                }else if(telefon_editText.getText().length()!=10 && telefon_editText.getText().length()!=0) {
                    Toast.makeText(v.getContext(), "Lütfen telefon numarasını formata uygun giriniz.\nNumara 10 karakterden oluşmalı.", Toast.LENGTH_LONG).show();
                    control=false;
                }else if(kimlik_editText.getText().length()!=11&& kimlik_editText.getText().length()!=0) {
                    Toast.makeText(v.getContext(), "Lütfen kimlik numarasını formata uygun giriniz.\nKimlik 11 karakterden oluşmalı.", Toast.LENGTH_LONG).show();
                    control=false;
                }else if(mail_editText.getText().length()>24) {
                    Toast.makeText(v.getContext(), "Lütfen maili formata uygun giriniz\n24 karakterden uzun olamaz", Toast.LENGTH_LONG).show();
                    control=false;
                } else if(soyisim_editText.getText().length()==0) {
                    Toast.makeText(v.getContext(), "Mail boş olamaz.\nLütfen bir mail giriniz", Toast.LENGTH_LONG).show();
                    control=false;
                }

                if(control) {
                    Intent i = new Intent(getBaseContext(), Bilgilendirme.class);
                    i.putExtra("isim", isim_editText.getText().toString());
                    i.putExtra("soyisim", soyisim_editText.getText().toString());
                    i.putExtra("kimlik", kimlik_editText.getText().toString());
                    i.putExtra("telefon", telefon_editText.getText().toString());
                    i.putExtra("mail", mail_editText.getText().toString());
                    i.putExtra("sehir", spinner_sehir.getSelectedItem().toString());
                    i.putExtra("gun", spinner_gun.getSelectedItem().toString());
                    i.putExtra("ay", spinner_ay.getSelectedItem().toString());
                    i.putExtra("yil", spinner_yil.getSelectedItem().toString());
                    if (secilen != null) {
                        i.putExtra("resim", secilen.toString());
                    } else {
                        i.putExtra("resim", "0");
                    }
                    startActivity(i);
                }
            }
        });

        temizle_button=(Button) findViewById(R.id.temizle_button);
        temizle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //
                isim_editText.setText("");
                soyisim_editText.setText("");
                kimlik_editText.setText(null);
                telefon_editText.setText(null);
                mail_editText.setText("");
                spinner_sehir.setSelection(0);
                spinner_gun.setSelection(0);
                spinner_ay.setSelection(0);
                spinner_yil.setSelection(0);
                pp.setImageURI(null);
            }
        });

        pp=(ImageView)findViewById(R.id.img);
        galeri_button = (Button) findViewById(R.id.galeri_Button);
        galeri_button.setOnClickListener(new ImagePıckListener());

    }
    ////////////////////////////////////////////////////////////////
    public class ImagePıckListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent1=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent1.setType("image/*");
            startActivityForResult(Intent.createChooser(intent1,"Resim yukle"),REQUEST_CODE);
        }
    }
    public void onActivityResult(int requestcode,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode == Activity.RESULT_OK && data!=null){
            switch (requestcode){
                case REQUEST_CODE:
                    secilen = data.getData();
                    pp.setImageURI(secilen);
                    break;
                default:
                    break;
            }
        }
    }

}
