package com.myapp.hackbanero.hackbanero;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

import controller.Funcion;
import jxl.read.biff.BiffException;

public class SectorSecundarioGenericoActivity extends AppCompatActivity {
    private float resultado;
    private float resultado2;
    private  float resul;
    private  float resul2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_secundario_generico);

        DecimalFormat decimales = new DecimalFormat("0.00");
        String subSector = getIntent().getStringExtra("subsector");
        String añoInicial = getIntent().getStringExtra("año_inicial");
        String añoFinal = getIntent().getStringExtra("año_final");
        String estado = getIntent().getStringExtra("estado");

        TextView textViewEstado = (TextView)findViewById(R.id.textView_SM_Estado);
        TextView textViewIndice = (TextView)findViewById(R.id.textView_indiceGenerico);
        TextView textViewPeriodo = (TextView)findViewById(R.id.textView_Periodo_SS);
        TextView editTextIndicador = (TextView)findViewById(R.id.editText_indiceManufactura);
        TextView textViewPromedios = (TextView) findViewById(R.id.textViewPromedios);
        TextView textViewPorcentajes = (TextView) findViewById(R.id.textViewPorcentaje);

        Funcion pruebaExcel = new Funcion();

        switch (subSector){
            case "Manufactura":
                textViewEstado.setText(estado);
                textViewIndice.setText("Promedio del indice de crecimiento de la industria manufacturera");
                textViewPeriodo.setText(añoInicial + " - " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoInicial);
                    resultado2 = pruebaExcel.Buscar(this,subSector,añoFinal,añoFinal);
                    Float promedio = (resultado2-resultado)/(resultado*100);
                    textViewPorcentajes.setText(String.valueOf(promedio));
                    textViewPromedios.setText(decimales.format(resultado) + "  |  " + decimales.format(resultado2));
                    if(resultado2>resultado){
                        editTextIndicador.setText("Hubo aumento");
                        editTextIndicador.setTextColor(Color.parseColor("#FF3C8B29"));
                    }else{
                        editTextIndicador.setText("Hubo disminución");
                        editTextIndicador.setTextColor(Color.RED);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }

                break;
            case "Construcción":
                textViewEstado.setText(estado);
                textViewIndice.setText("Promedio del indice de crecimiento de la industria de construcción");
                textViewPeriodo.setText(añoInicial + "  |  " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoInicial) ;
                    resultado2 = pruebaExcel.Buscar(this,subSector,añoFinal,añoFinal);
                    textViewPromedios.setText(decimales.format(resultado) + "  |  " + decimales.format(resultado2));
                    Float promedio = (resultado2-resultado)/(resultado*100);
                    textViewPorcentajes.setText(String.valueOf(promedio));
                    if(resultado2>resultado){
                        editTextIndicador.setText("Hubo aumento");
                        editTextIndicador.setTextColor(Color.parseColor("#FF3C8B29"));
                    }else{
                        editTextIndicador.setText("Hubo disminución");
                        editTextIndicador.setTextColor(Color.RED);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
                break;
            case "Industria":
                textViewEstado.setText(estado);
                textViewIndice.setText("Promedio del indice de crecimiento industrial");
                textViewPeriodo.setText(añoInicial + "  |  " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoInicial);
                    resultado2 = pruebaExcel.Buscar(this,subSector,añoFinal,añoFinal);
                    textViewPromedios.setText(decimales.format(resultado) + "  |  " + decimales.format(resultado2));

                    resul = pruebaExcel.Buscar2(this, subSector,añoInicial,añoInicial);
                    resul2 = pruebaExcel.Buscar2(this, subSector,añoFinal,añoFinal);



                    Float promedio = ((resul2-resul)/(resul*100))*100;
                    textViewPorcentajes.setText(decimales.format(promedio)+ "%");

                    if(resultado2>resultado){
                        editTextIndicador.setText("Hubo aumento");
                        editTextIndicador.setTextColor(Color.parseColor("#FF3C8B29"));
                    }else{
                        editTextIndicador.setText("Hubo disminución");
                        editTextIndicador.setTextColor(Color.RED);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }


    }
}
