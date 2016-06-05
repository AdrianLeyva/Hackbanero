package com.myapp.hackbanero.hackbanero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import controller.Funcion;
import jxl.read.biff.BiffException;

public class SectorSecundarioGenericoActivity extends AppCompatActivity {
    private String resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_secundario_generico);

        String subSector = getIntent().getStringExtra("subsector");
        String añoInicial = getIntent().getStringExtra("año_inicial");
        String añoFinal = getIntent().getStringExtra("año_final");
        String estado = getIntent().getStringExtra("estado");

        TextView textViewEstado = (TextView)findViewById(R.id.textView_SM_Estado);
        TextView textViewIndice = (TextView)findViewById(R.id.textView_indiceGenerico);
        TextView textViewPeriodo = (TextView)findViewById(R.id.textView_Periodo_SS);
        TextView editTextIndicador = (TextView)findViewById(R.id.editText_indiceManufactura);

        Funcion pruebaExcel = new Funcion();

        switch (subSector){
            case "Manufactura":
                textViewEstado.setText(estado);
                textViewIndice.setText("Indice de crecimiento de la industria manufacturera");
                textViewPeriodo.setText(añoInicial + " - " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoFinal);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
                editTextIndicador.setText(resultado);
                Toast toast=Toast.makeText(this, resultado, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case "Construcción":
                textViewEstado.setText(estado);
                textViewIndice.setText("Indice de crecimiento de la industria de construcción");
                textViewPeriodo.setText(añoInicial + " - " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoFinal);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
                editTextIndicador.setText(resultado);
                break;
            case "Industria":
                textViewEstado.setText(estado);
                textViewIndice.setText("Indice de crecimiento industrial");
                textViewPeriodo.setText(añoInicial + " - " + añoFinal);
                try {
                    resultado = pruebaExcel.Buscar(this,subSector,añoInicial,añoFinal);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
                editTextIndicador.setText(resultado);
                break;
            default:
                break;
        }


    }
}
