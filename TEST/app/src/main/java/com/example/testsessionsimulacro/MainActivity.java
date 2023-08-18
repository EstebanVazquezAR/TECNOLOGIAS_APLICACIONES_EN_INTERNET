package com.example.testsessionsimulacro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear una instancia de Empleado
        Empleado empleado = new Empleado("123", "Juan Pérez", "juanperez", "contraseña123", "Administrador");

        // Obtener referencias a las vistas
        TextView idTextView = findViewById(R.id.idTextView);
        TextView nombreTextView = findViewById(R.id.nombreTextView);
        TextView usuarioTextView = findViewById(R.id.usuarioTextView);
        TextView passwordTextView = findViewById(R.id.passwordTextView);
        TextView rolTextView = findViewById(R.id.rolTextView);

        // Obtener los datos del empleado y establecerlos en las vistas
        String idEmpleado = empleado.getIdEmpleado();
        String nombreEmpleado = empleado.getNombreEmpleado();
        String usuario = empleado.getUsuario();
        String password = empleado.getPassword();
        String rol = empleado.getRol();

        idTextView.setText("IdEmpleado: " + idEmpleado);
        nombreTextView.setText("NombreEmpleado: " + nombreEmpleado);
        usuarioTextView.setText("Usuario: " + usuario);
        passwordTextView.setText("Password: " + password);
        rolTextView.setText("Rol: " + rol);
    }
}
