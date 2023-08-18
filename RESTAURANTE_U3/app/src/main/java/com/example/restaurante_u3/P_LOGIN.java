package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class P_LOGIN extends AppCompatActivity {


    Empleado empleado = new Empleado("123", "Juan Pérez", "juanperez", "contraseña123", "Administrador");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_login);

        _Navegacion( empleado.getRol() );

    }




    private void _Consulta(){

    }

    private void _Navegacion(final String _rol){
        if (_rol == "Admin"){

        }
        if (_rol == "Mesero"){

        }
        if (_rol == "Chef"){

        }
    }
}