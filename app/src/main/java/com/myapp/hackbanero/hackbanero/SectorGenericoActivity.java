package com.myapp.hackbanero.hackbanero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import controller.ControladorSectorGenerico;

public class SectorGenericoActivity extends AppCompatActivity {
    private Spinner spinnerSubSector;
    private Spinner spinnerPeriodoI;
    private Spinner spinnerPeriodoF;
    private ControladorSectorGenerico controlador;
    private ArrayList<String> subSectores;
    private String sector;
    private String estado;
    private String [] sectoresSecundarios = {"Manufactura", "Construcción", "Industria"};
    private String [] sectoresTerciarios = {"Bienes y servicios al por menor", "Bienes y Servicios al por mayor",
                                            "Visitantes con pernocta al estado", "Porcenta de ocupación Hotelera"};
    private String [] periodoInicial = {"2009", "2010", "2011", "2012", "2013", "2014"};
    private String [] periodoFinal = {"2010", "2011", "2012", "2013", "2014", "2015"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_generico);

        estado = getIntent().getStringExtra("estado");
        TextView textViewEstado = (TextView)findViewById(R.id.textView_nombreEstado);
        textViewEstado.setText(estado);

        sector = getIntent().getStringExtra("sector");
        if (sector.compareTo("Secundario") == 0 ){
            //Creación del adaptador del spinner del subsector
            spinnerSubSector = (Spinner) findViewById(R.id.spinner_SubSector);
            ArrayAdapter<String> adaptadorSubSector = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_dropdown_item, sectoresSecundarios);
            spinnerSubSector.setAdapter(adaptadorSubSector);
        }
        else {
            //Creación del adaptador del spinner del subsector
            spinnerSubSector = (Spinner) findViewById(R.id.spinner_SubSector);
            ArrayAdapter<String> adaptadorSubSector = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_dropdown_item, sectoresTerciarios);
            spinnerSubSector.setAdapter(adaptadorSubSector);
        }

        //Creación del adaptador del spinner del periodo inicial
        spinnerPeriodoI = (Spinner) findViewById(R.id.spinner_PeriodoInicial);
        ArrayAdapter<String> adaptadorPeriodoInicial = new ArrayAdapter<String>(this,
                                android.R.layout.simple_spinner_dropdown_item,periodoInicial );
        spinnerPeriodoI.setAdapter(adaptadorPeriodoInicial);

        //Creación del adaptador del spinner del periodo Final
        spinnerPeriodoF = (Spinner) findViewById(R.id.spinner_PeriodoFinal);
        ArrayAdapter<String> adaptadorPeriodoFinal = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,periodoFinal );
        spinnerPeriodoF.setAdapter(adaptadorPeriodoFinal);

    }

    public void abrirSectorSecundarioGenerico(View view){
        ControladorSectorGenerico controlador = new ControladorSectorGenerico(this,
                                        spinnerPeriodoI.getSelectedItem().toString(),
                                        spinnerPeriodoF.getSelectedItem().toString());
        if (controlador.validarSelecciones()){
           /* Intent i = new Intent(this, );
            i.putExtra("estado", estado );
            i.putExtra("año_inicial", periodoInicial);
            i.putExtra("año_final", periodoFinal);
            i.putExtra("subsector", sector);
            */
        }
    }
}
