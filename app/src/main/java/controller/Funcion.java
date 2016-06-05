/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Marco
 */
public class Funcion {
    private float resultad;



    public float Buscar(Context view, String sector, String inicio, String fin) throws IOException, BiffException{

        ArrayList resultados = new ArrayList();


        try {
            AssetManager am = view.getAssets();
            InputStream is = am.open("TODOS.xls");

            Workbook wb = Workbook.getWorkbook(is);

            Sheet s = wb.getSheet(0);

            int columna = 0;

            if ("Industria".compareTo(sector) == 0) {
                columna = 1;
            } else if ("Manufactura".compareTo(sector) == 0) {
                columna = 2;
            } else if ("Construcción".compareTo(sector) == 0) {
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
            resultad = result;


        }catch (Exception e){
            Log.wtf("Exception", e.getMessage());
        }
        return resultad;
    }



    public float Buscar2(Context view, String sector, String inicio, String fin) throws IOException, BiffException{

        ArrayList resultados = new ArrayList();


        try {
            AssetManager am = view.getAssets();
            InputStream is = am.open("TODOS.xls");

            Workbook wb = Workbook.getWorkbook(is);

            Sheet s = wb.getSheet(0);

            int columna = 0;

            if ("Industria".compareTo(sector) == 0) {
                columna = 1;
            } else if ("Manufactura".compareTo(sector) == 0) {
                columna = 2;
            } else if ("Construcción".compareTo(sector) == 0) {
                columna = 3;
            }

            int i, j = 0;
            int fechadeinicio = 0, fechadefin = 0;

            String fechaI = inicio + "/01";
            String fechaF = fin + "/01";

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


            for (i = fechadeinicio; i <= fechadeinicio; i++) {
                Cell c = s.getCell(columna, i);

                String celda = c.getContents();
                resultados.add(celda);
            }

            for (i = fechadefin; i <= fechadefin; i++) {
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



                float numero = Float.valueOf(resultados.get(0).toString());
                float numero2 = Float.valueOf(resultados.get(1).toString());
                float porcentaje = (numero*100)/numero2;



            resultad = porcentaje;


        }catch (Exception e){
            Log.wtf("Exception", e.getMessage());
        }
        return resultad;
    }
    
    
}
