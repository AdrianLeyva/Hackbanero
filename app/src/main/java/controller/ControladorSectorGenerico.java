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
    private String periodoInicial;
    private String periodoFinal;
    private Context view;

    public ControladorSectorGenerico(Context view, String periodoInicial, String periodoFinal) {
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.view = view;
    }

    public boolean validarSelecciones(){
        int periodoI = Integer.parseInt(periodoInicial);
        int periodoF = Integer.parseInt(periodoFinal);

        if (periodoI > periodoF) {
            Toast toast = Toast.makeText(view, "Periodos Invalidos", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        return true;
    }
}
