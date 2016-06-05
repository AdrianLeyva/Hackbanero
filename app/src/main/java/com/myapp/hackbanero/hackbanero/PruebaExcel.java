package com.myapp.hackbanero.hackbanero;

import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class PruebaExcel extends AppCompatActivity {
    private String hola;
    private TextView pruebaExcel;
    String resultad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_excel);





    }

    public String Buscar(String sector, String inicio, String fin) {

        ArrayList resultados = new ArrayList();


        try {

            AssetManager am = getAssets();
            InputStream is = am.open("Sector Secundario.xls");

            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);


            int columna = 0;

            if ("Industria".equals(sector)) {
                columna = 1;
            } else if ("Manufactura".equals(sector)) {
                columna = 2;
            } else if ("Construcción".equals(sector)) {
                columna = 3;
            }

            int i, j = 0;
            int fechadeinicio = 0, fechadefin = 0;

            String fechaI = inicio + "/01";
            String fechaF = fin + "/12";

            for (i = 0; i < 87; i++) {
                Cell c = s.getCell(0, i);
                String celda = c.getContents();

                if (celda.compareTo(fechaI) == 0) {
                    fechadeinicio = i;
                }
            }

            for (j = 0; j < 87; j++) {
                Cell c = s.getCell(0, j);
                String celda = c.getContents();
                if (celda.compareTo(fechaF) == 0) {
                    fechadefin = j;
                }
            }


            for (i = fechadeinicio; i <= fechadefin; i++) {
                Cell c = s.getCell(columna, i);

                String celda = c.getContents();
                resultados.add(celda);
            }
            //for (int i=0 ; i<row ; i++){
            //    for (int j=0 ; j<col ; j++){

            //    }
            //}
            int tamaño = resultados.size();


            float suma = 0;


            for (int n = 0; n < tamaño; n++) {
                float numero = Float.valueOf(resultados.get(n).toString());
                suma = suma + numero;
            }

            float result = 0;
            result = suma / tamaño;
            //resultad = String.valueOf(result);
            resultad = "hola";

            return resultad;
        } catch (Exception e) {

        }
        return resultad;

    }
}
