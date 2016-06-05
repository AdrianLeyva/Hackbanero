package com.myapp.hackbanero.hackbanero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import controller.ControladorMain;

public class MainActivity extends AppCompatActivity {
    //Array de los estados de la república
    private String [] estados = {"Aguascalientes", "Baja California","Baja California Sur",
                                 "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima",
                                 "Distrito Federal", "Durango", "Estado de México", "Guanajuato",
                                 "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit",
                                 "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo",
                                 "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas",
                                 "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" };
    private String [] sectores = {"Primario", "Secundario", "Terciario"};
    private Spinner spinnerEstados;
    private Spinner spinnerSectores;
    private ControladorMain controladorMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Creacion del spinner de los estados
        spinnerEstados = (Spinner) findViewById(R.id.spinnerEstados);
        ArrayAdapter<String> adaptadorEstados= new ArrayAdapter<String>(this,
                     android.R.layout.simple_spinner_dropdown_item, estados);
        spinnerEstados.setAdapter(adaptadorEstados);

        //Creación del spinner de los sectores
        spinnerSectores = (Spinner) findViewById(R.id.spinnerSectores);
        ArrayAdapter<String> adaptadorSectores = new ArrayAdapter<String>(this,
                      android.R.layout.simple_spinner_dropdown_item, sectores);
        spinnerSectores.setAdapter(adaptadorSectores);

        //controladorMain = new ControladorMain(this, spinnerEstados, spinnerSectores);
    }

    public void botonConsultar(View view){
        String estadoSeleccionado = spinnerEstados.getSelectedItem().toString();
        String sectorSeleccionado = spinnerSectores.getSelectedItem().toString();

        if (estadoSeleccionado == "Yucatán") {
            switch (sectorSeleccionado) {
                case "Primario":
                    Intent i = new Intent(this, SectorPrimarioActivity.class);
                    i.putExtra("estado", estadoSeleccionado);
                    startActivity(i);

                case "Secundario":
                    //
                    break;

                case "Terciario":
                    //
                    break;
                default:
                    break;
            }
        }
        else {
            Toast toast = Toast.makeText(this, "Esta es una demo, selecciona Yucatán, por favor", Toast.LENGTH_SHORT);
            toast.show();
        }

      //  Intent i = new Intent(this, PruebaExcel.class);
      //  startActivity(i);
    }



}
