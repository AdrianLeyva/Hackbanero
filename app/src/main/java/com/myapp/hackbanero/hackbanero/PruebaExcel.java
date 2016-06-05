package com.myapp.hackbanero.hackbanero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

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

        File f = new File("/Users'kevingamboa17/Documents/hola.xls");

        try {
            Workbook wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);
            Cell c = s.getCell(1,4);
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
