package com.example.a15011036;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Dersler extends AppCompatActivity {
    RecyclerView recyclerView;
    DersAdapter adapter;
    List<Ders> ders_listesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dersler);
        ders_listesi = new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ders_listesi.add(new Ders(1, "Mobil Programlamaya Giriş",
                "Doçent Doktor", "M. Amaç", "Güvensan",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği Z-035\n ",
                3.5, R.drawable.mag_vesikalik));

        ders_listesi.add(new Ders(2, "Ağ Teknolojileri",
                "Doçent Doktor", "Ali Gökhan", "Yavuz",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-216",
                2.0, R.drawable.agy_vesikalik));

        ders_listesi.add(new Ders(3, "Veri Yapıları ve Algoritmalar",
                "Doçent Doktor", "Mine Elif", "Karslıgil",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-217",
                3.0, R.drawable.mek_vesikalik));
        ders_listesi.add(new Ders(4, "Yapay Zeka",
                "Doçent Doktor", "M. Fatih", "Amasyalı",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-213",
                3.5, R.drawable.mfa_vesikalik));

        ders_listesi.add(new Ders(5, "Yapısal Programlamaya Giriş",
                "Doçent Doktor", "H. İrem", "Türkmen",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği",
                3.0, R.drawable.hit_vesikalik));

        ders_listesi.add(new Ders(6, "Veri İletişimi",
                "Yardımcı Doçent Doktor", "Z. Cihan", "Tayşi",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-126",
                4.0,R.drawable.zct_vesikalik));
        ders_listesi.add(new Ders(7, "Sayısal Analiz",
                "Profesör Doktor(Bölüm Başkanı)", "Banu", "Diri",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-222",
                2.5,R.drawable.bd_vesikalik));
        ders_listesi.add(new Ders(8, "Hesaplama Kuramı",
                "Doçent Doktor", "Ferkan", "Yılmaz",
                "Elektrik-Elektronik Fakültesi Bilgisayar Mühendisliği D-215",
                2.5,R.drawable.fy_vesikalik));

        adapter= new DersAdapter(this, ders_listesi);
        recyclerView.setAdapter(adapter);


    }

    public class DersAdapter extends RecyclerView.Adapter<DersAdapter.DersViewHolder>{

        private Context myContext;
        private List<Ders> ders_listesi;
        private Ders secilen;

        public DersAdapter(Context myContext, List<Ders> ders_listesi) {
            this.myContext = myContext;
            this.ders_listesi = ders_listesi;
        }

        @Override
        public DersViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater=LayoutInflater.from(myContext);
            View view=inflater.inflate(R.layout.list_layout, null);
            return new DersViewHolder(view);

        }

        @Override
        public void onBindViewHolder(DersViewHolder dersViewHolder, int i) {
            Ders dersim=ders_listesi.get(i);
            dersViewHolder.secilen=ders_listesi.get(i);

            dersViewHolder.imageView.setImageDrawable(myContext.getResources().getDrawable(dersim.getImage()));
            dersViewHolder.textViewDers.setText(dersim.getDers());
            dersViewHolder.textViewUnvan.setText(dersim.getUnvan());
            dersViewHolder.textViewIsim.setText(String.valueOf(dersim.getIsim()+" "+dersim.getSoyisim()));
            dersViewHolder.textViewOrtalamam.setText(String.valueOf("Ortalamam: "+dersim.getOrtalamam()));
            dersViewHolder.textViewOfis.setText(String.valueOf(dersim.getOfis()));
        }

        @Override
        public int getItemCount() {
            return ders_listesi.size();
        }

        class DersViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textViewDers, textViewUnvan, textViewIsim,textViewOrtalamam, textViewOfis;
            Ders secilen;

            public DersViewHolder(View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.pp_imageView);
                textViewDers=itemView.findViewById(R.id.textView_ders);
                textViewUnvan=itemView.findViewById(R.id.textView_unvan);
                textViewIsim=itemView.findViewById(R.id.textView_isim);
                textViewOrtalamam=itemView.findViewById(R.id.textView_ortalamam);
                textViewOfis=itemView.findViewById(R.id.textView_ofis)  ;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int ders_no=secilen.getId();
                        String ders_bilgi="";
                        switch (ders_no) {
                            case 1 :
                                ders_bilgi="Mobil Programlamaya Giriş\nÖğrenci sayisi:60\nNot Ortalaması:2,70";
                                break;

                            case 2 :
                                ders_bilgi="Ağ Teknolojileri\nÖğrenci sayisi:180\nNot Ortalaması:2,15";
                                break;

                            case 3 :
                                ders_bilgi="Veri Yapıları ve Algoritmalar\nÖğrenci sayisi:110\nNot Ortalaması:2,35";
                                break;

                            case 4 :
                                ders_bilgi="Yapay Zeka\nÖğrenci sayisi:60\nNot Ortalaması:2,80";
                                break;

                            case 5 :
                                ders_bilgi="Veri İletişimi\nÖğrenci sayisi:150\nNot Ortalaması:2,20";
                                break;

                            case 6 :
                                ders_bilgi="Veri İletişimi\nÖğrenci sayisi:95\nNot Ortalaması:2,40";
                                break;

                            case 7 :
                                ders_bilgi="Sayısal Analiz\nÖğrenci sayisi:85\nNot Ortalaması:2,90";
                                break;

                            case 8 :
                                ders_bilgi="Hesaplama Kuramı\nÖğrenci sayisi:80\nNot Ortalaması:2,50";
                                break;
                        }
                        Toast.makeText(v.getContext(), ders_bilgi, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }

    public class Ders{
        private int id;
        private String ders,unvan,isim,soyisim,ofis;
        private double ortalamam;
        private int image;

        public Ders(int id, String ders, String unvan, String isim, String soyisim, String ofis,double ortalamam, int image) {
            this.id = id;
            this.ders = ders;
            this.unvan = unvan;
            this.isim = isim;
            this.soyisim = soyisim;
            this.ofis = ofis;
            this.ortalamam=ortalamam;
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public String getDers() {
            return ders;
        }

        public String getUnvan() {
            return unvan;
        }

        public String getIsim() {
            return isim;
        }

        public String getSoyisim() {
            return soyisim;
        }

        public String getOfis() {
            return ofis;
        }

        public double getOrtalamam() {
            return ortalamam;
        }

        public int getImage() {
            return image;
        }
    }

}

