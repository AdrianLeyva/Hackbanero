package controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.myapp.hackbanero.hackbanero.Splashscreen;

/**
 * Created by kevingamboa17 on 05/06/16.
 */
public class ControladorSectorGenerico {
    private String estado;
    private String periodoInicial;
    private String periodoFinal;
    private String subSector;
    private Context view;

    public ControladorSectorGenerico(Context view, String estado, String periodoInicial, String periodoFinal, String subSector) {
        this.estado = estado;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.subSector = subSector;
        this.view = view;
    }

    public boolean validarSelecciones(){
        int periodoI = Integer.parseInt(periodoInicial);
        int periodoF = Integer.parseInt(periodoFinal);

        if (periodoI >= periodoF) {
            Toast toast = Toast.makeText(view, "Periodos Invalidos", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
           /* Intent i = new Intent(this);
            i.putExtra("estado", estado );
            i.putExtra("año_inicial", periodoInicial);
            i.putExtra("año_final", periodoFinal);
            i.putExtra("subsector", subSector);
            */
        }

        return true;
    }
}
