package com.myapp.hackbanero.hackbanero;

import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class PruebaExcel extends AppCompatActivity {
    private String hola;
    private TextView pruebaExcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_excel);



        try {
            AssetManager am= getAssets();
            InputStream is= am.open("hola.xls");


            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            Cell c = s.getCell(1,6);
            hola = c.getContents();
        }
        catch (Exception e){
            hola = e.toString();
        }


        pruebaExcel = (TextView) findViewById(R.id.textViewExcel);
        pruebaExcel.setText(hola);

        //int row = s.getRows();
        //int col = s.getColumns();


    }
}
