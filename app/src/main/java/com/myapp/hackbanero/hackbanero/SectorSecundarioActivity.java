package com.myapp.hackbanero.hackbanero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SectorSecundarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_primario);

        String estado = getIntent().getStringExtra("estado");
        TextView textViewEstado = (TextView)findViewById(R.id.textView_nombreEstado);
        textViewEstado.setText(estado);
    }
}
