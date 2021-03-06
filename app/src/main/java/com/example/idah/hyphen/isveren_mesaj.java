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

public class isveren_mesaj extends AppCompatActivity {
    Button cikis;
    Button anasayfa,mesajyaz;
    Spinner spnr;
    EditText mesajkonusu,aliciemail;
    MultiAutoCompleteTextView mesajicerigi;
    String gelenemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isveren_mesaj);
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
                gelenemail = extras.getString("email");
                String alicimail=aliciemail.getText().toString().trim();
                String mesajkonus=mesajkonusu.getText().toString();
                String mesaj=mesajicerigi.getText().toString();
                veritabani vrtbn = new veritabani();
                String donus=vrtbn.mesajekle(gelenemail,alicimail,mesajkonus,mesaj);
                Toast.makeText(getApplicationContext(),donus, Toast.LENGTH_LONG).show();
            }
        });
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(isveren_mesaj.this, isveren_paneli.class));
            }
        });
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(isveren_mesaj.this, Hyphen.class));
            }
        });
        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        break;
                    case 1:
                        startActivity(new Intent(isveren_mesaj.this, isveren_profil.class));
                        Intent intent = new Intent(isveren_mesaj.this, isveren_profil.class);
                        intent.putExtra("email",gelenemail);
                        startActivity(intent);
                        break;
                    case 2:
                        startActivity(new Intent(isveren_mesaj.this, isveren_duyuru.class));
                        Intent intent1 = new Intent(isveren_mesaj.this, isveren_duyuru.class);
                        intent1.putExtra("email",gelenemail);
                        startActivity(intent1);
                        break;
                    case 3:
                        startActivity(new Intent(isveren_mesaj.this, isveren_mesaj.class));
                        Intent intent2 = new Intent(isveren_mesaj.this, isveren_mesaj.class);
                        intent2.putExtra("email",gelenemail);
                        startActivity(intent2);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
