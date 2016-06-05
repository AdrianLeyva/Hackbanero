package com.myapp.hackbanero.hackbanero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SectorSecundarioGenericoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_manufactura);

        String subSector = getIntent().getStringExtra("subsector");
        String añoInicial = getIntent().getStringExtra("año_inicial");
        String añoFinal = getIntent().getStringExtra("año_final");
        String estado = getIntent().getStringExtra("estado");

        TextView textViewEstado = (TextView)findViewById(R.id.textView_SM_Estado);
        TextView textViewIndice = (TextView)findViewById(R.id.textView_indiceGenerico);
        TextView textViewPeriodo = (TextView)findViewById(R.id.textView_Periodo_SS);
    }
}
