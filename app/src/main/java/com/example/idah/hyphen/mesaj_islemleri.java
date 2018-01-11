package com.example.idah.hyphen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class mesaj_islemleri extends AppCompatActivity {
    Button mesajyaz, gelenmesaj, cikis, anasayfa;
    Spinner spnr;
    EditText mesajkonusu,aliciemail;
    MultiAutoCompleteTextView mesajicerigi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesaj_islemleri);
        mesajicerigi = (MultiAutoCompleteTextView) findViewById(R.id.mlttext);
        mesajkonusu = (EditText) findViewById(R.id.edt1);
        aliciemail=(EditText)findViewById(R.id.alicimail);
        cikis = (Button) findViewById(R.id.cikis);
        anasayfa = (Button) findViewById(R.id.anasayfa);
        spnr = (Spinner) findViewById(R.id.spn);
        mesajyaz = (Button) findViewById(R.id.mesajyaz);
        mesajyaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
              String  gelenemail = extras.getString("email");
              String alicimail=aliciemail.getText().toString();
              String mesajkonus=mesajkonusu.getText().toString();
              String mesaj=mesajicerigi.getText().toString();
                veritabani vrtbn = new veritabani();
                String donus=vrtbn.mesajekle(gelenemail,alicimail,mesajkonus,mesaj);
                Toast.makeText(getApplicationContext(),donus, Toast.LENGTH_LONG).show();
            }
        });
        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:

                        break;
                    case 1:
                        startActivity(new Intent(mesaj_islemleri.this, profil.class));
                        break;
                    case 2:
                        startActivity(new Intent(mesaj_islemleri.this, uye_islemleri.class));
                        break;
                    case 3:
                        startActivity(new Intent(mesaj_islemleri.this, tlislemleri.class));
                        break;
                    case 4:
                        startActivity(new Intent(mesaj_islemleri.this, isveren_islemleri.class));
                        break;
                    case 5:
                        startActivity(new Intent(mesaj_islemleri.this, gorev_islemleri.class));
                        break;
                    case 6:
                        startActivity(new Intent(mesaj_islemleri.this, duyuru_islemleri.class));
                        break;
                    case 7:
                        startActivity(new Intent(mesaj_islemleri.this, mesaj_islemleri.class));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mesaj_islemleri.this, Hyphen.class));
            }
        });
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mesaj_islemleri.this, admin_paneli.class));
            }
        });
    }
}
