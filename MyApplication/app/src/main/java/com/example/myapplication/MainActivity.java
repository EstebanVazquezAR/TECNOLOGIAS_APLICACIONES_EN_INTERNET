package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.SQLException;
import android.util.Log;



public class MainActivity extends AppCompatActivity {
    private TextView statusTextView; // Declaración del TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);

        // Llamada al método para validar la conexión y mostrar el resultado
        validarConexion();
    }

    private void validarConexion() {
        CconexionBD conexionBD = new CconexionBD();
        Connection connection = conexionBD.conexionBd0(this, statusTextView); // "this" es el contexto de la actividad

    }


}


