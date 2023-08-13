package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZZZ_TEST extends AppCompatActivity {

    Button Layout_CRUD_Bebidas,Layout_CRUD_Comida,Layout_CRUD_Empleados;
    Button Layout_SELECT_Bebidas,Layout_SELECT_Comida,Layout_SELECT_Empleados;
    Button Layout_Principal_Login,Layout_Principal_Mesas,Layout_Principal_CARTA_MENU;
    Button Layout_Trabajo_Mesero,Layout_Trabajo_Cocinero;
    Button Layout_Login_Usuarios_PASS,Layout_Login_Admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zzz_test);

        Layout_CRUD_Bebidas = findViewById(R.id.Layout_CRUD_Bebidas);
        Layout_CRUD_Empleados = findViewById(R.id.Layout_CRUD_Empleados);
        Layout_CRUD_Comida = findViewById(R.id.Layout_CRUD_Comida);

        Layout_SELECT_Bebidas = findViewById(R.id.Layout_SELECT_Bebidas);
        Layout_SELECT_Comida = findViewById(R.id.Layout_SELECT_Comida);
        Layout_SELECT_Empleados = findViewById(R.id.Layout_SELECT_Empleados);

        Layout_Principal_Login = findViewById(R.id.Layout_Principal_Login);
        Layout_Principal_Mesas = findViewById(R.id.Layout_Principal_Mesas);
        Layout_Principal_CARTA_MENU = findViewById(R.id.Layout_Principal_CARTA_MENU);

        Layout_Trabajo_Mesero = findViewById(R.id.Layout_Trabajo_Mesero);
        Layout_Trabajo_Cocinero = findViewById(R.id.Layout_Trabajo_Cocinero);

        Layout_Login_Usuarios_PASS = findViewById(R.id.Layout_Login_Usuarios_PASS);
        Layout_Login_Admin = findViewById(R.id.Layout_Login_Admin);

        // 13 Botones

        Layout_CRUD_Bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, CRUD_Bebidas.class);
                startActivity(intent);

            }
        });
        Layout_CRUD_Empleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, CRUD_Empleados.class);
                startActivity(intent);

            }
        });
        Layout_CRUD_Comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, CRUD_Comidas.class);
                startActivity(intent);

            }
        });
        Layout_SELECT_Bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, SELECT_BEBIDAS.class);
                startActivity(intent);

            }
        });
        Layout_SELECT_Comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, SELECT_COMIDA.class);
                startActivity(intent);

            }
        });
        Layout_SELECT_Empleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, SELECT_EMPLEADOS.class);
                startActivity(intent);

            }
        });
        Layout_Principal_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, P_LOGIN.class);
                startActivity(intent);

            }
        });
        Layout_Principal_Mesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, P_MESAS.class);
                startActivity(intent);

            }
        });
        Layout_Principal_CARTA_MENU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, P_CARTA_MENU.class);
                startActivity(intent);

            }
        });
        Layout_Trabajo_Mesero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, T_MESERO.class);
                startActivity(intent);

            }
        });
        Layout_Trabajo_Cocinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, T_COCINERO.class);
                startActivity(intent);

            }
        });
        Layout_Login_Usuarios_PASS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, L_Usuarios_PASS.class);
                startActivity(intent);

            }
        });
        Layout_Login_Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZZZ_TEST.this, L_Admin.class);
                startActivity(intent);

            }
        });


    }
}