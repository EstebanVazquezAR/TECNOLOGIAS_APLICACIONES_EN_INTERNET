package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SELECT_EMPLEADOS extends AppCompatActivity {

    Button Layout_CRUD;
    LinearLayout Consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bebidas);

        Layout_CRUD = findViewById(R.id.Layout_CRUD);
        Consulta = findViewById(R.id.Consulta);



        TB();
        //Navigate
        Layout_CRUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SELECT_EMPLEADOS.this, CRUD_Bebidas.class);
                startActivity(intent);

            }
        });

    }


    private void TB() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/EmpleadosApp"; // URL que devuelve un arreglo de objetos JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            // Create a TextView for the header
                            TextView headerTextView = new TextView(SELECT_EMPLEADOS.this);
                            headerTextView.setText("Id | NombreEmpleado | Usuario | Password | Rol");
                            // Customize headerTextView appearance if needed
                            Consulta.addView(headerTextView);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(SELECT_EMPLEADOS.this);
                                textView.setText("" + jsonObject.getString("IdEmpleado") +
                                        " | " + jsonObject.getString("NombreEmpleado") +
                                        " | " + jsonObject.getString("Usuario")+
                                        " | " + jsonObject.getString("Password")+
                                        " | " + jsonObject.getString("Rol"));

                                Consulta.addView(textView);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getMessage());
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }

}