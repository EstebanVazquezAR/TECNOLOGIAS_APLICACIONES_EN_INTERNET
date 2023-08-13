package com.example.myapplication;

import android.os.StrictMode;
import android.util.Log;

import java.sql.*;

public class CRUDMESAS {

    public Connection conexionBd0(){
        Connection cnn = null;
        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder ().permitAll() .build();
            StrictMode.setThreadPolicy (politica);
            Class. forName ("net. sourceforge, jtds. jdbc .Driver") .newInstance();
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://angelescuela.database.windows.net;databaseName=angelescuela;user=angelsa1;pasword=oxOWrOk3yPYjDmL5");
        } catch (Exception e) {
            Log.e("ERROR DE CONEXCION", e. getMessage ());
        }
        return cnn;
    }

}
