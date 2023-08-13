package com.example.myapplication;

import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;  // Agregamos la importación de TextView

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import android.content.*;



public class CconexionBD {

    public Connection conexionBd0(Context context, TextView statusTextView){
        Connection cnn = null;
        try {
            if (android.os.Build.VERSION.SDK_INT <= 19) {
                try {
                    ProviderInstaller.installIfNeeded(context.getApplicationContext());
                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }

            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder ().permitAll() .build();
            StrictMode.setThreadPolicy (politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://angelescuela.database.windows.net;databaseName=angelescuela;user=angelsa1;pasword=oxOWrOk3yPYjDmL5");
        } catch (Exception e) {
            Log.e("ERROR DE CONEXIÓN", e.getMessage());
            statusTextView.setText("Error de conexión: " + e.getMessage());
        }
        return cnn;
    }
}
