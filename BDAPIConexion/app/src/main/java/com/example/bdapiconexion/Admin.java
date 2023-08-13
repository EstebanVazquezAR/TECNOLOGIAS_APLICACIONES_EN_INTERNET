package com.example.bdapiconexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {


    Button Layout_CRUD_Bebidas,Layout_CRUD_Empleados,Layout_CRUD_Comida,Layout_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Layout_CRUD_Bebidas = findViewById(R.id.Layout_CRUD_Bebidas);

        Layout_CRUD_Empleados = findViewById(R.id.Layout_CRUD_Empleados);

        Layout_CRUD_Comida = findViewById(R.id.Layout_CRUD_Comida);

        Layout_Login = findViewById(R.id.Layout_Login);




        Layout_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Admin.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Layout_CRUD_Comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Admin.this, CRUD_Comidas.class);
                startActivity(intent);

            }
        });



        Layout_CRUD_Empleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Admin.this, CRUD_empleados.class);
                startActivity(intent);

            }
        });


        Layout_CRUD_Bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Admin.this, CRUD_Bebidas.class);
                startActivity(intent);

            }
        });


    }
}