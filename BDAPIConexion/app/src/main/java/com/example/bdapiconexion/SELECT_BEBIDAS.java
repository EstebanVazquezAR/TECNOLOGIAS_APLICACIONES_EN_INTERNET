package com.example.bdapiconexion;

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

public class SELECT_BEBIDAS extends AppCompatActivity {

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

                Intent intent = new Intent(SELECT_BEBIDAS.this, CRUD_Bebidas.class);
                startActivity(intent);

            }
        });

    }

    private void TB() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp"; // URL que devuelve un arreglo de objetos JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            // Create a TextView for the header
                            TextView headerTextView = new TextView(SELECT_BEBIDAS.this);
                            headerTextView.setText("Id | NombreBebida | Precio");
                            // Customize headerTextView appearance if needed
                            Consulta.addView(headerTextView);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(SELECT_BEBIDAS.this);
                                textView.setText("" + jsonObject.getString("IdBebida") +
                                        " | " + jsonObject.getString("NombreBebida") +
                                        " | " + jsonObject.getString("Precio"));

                                Consulta.addView(textView);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                                TextView textView = new TextView(SELECT_BEBIDAS.this);
//                                textView.setText("IdBebida: " + jsonObject.getString("IdBebida") +
//                                        " | NombreBebida: " + jsonObject.getString("NombreBebida") +
//                                        " | Precio: " + jsonObject.getString("Precio"));
//
//                                Consulta.addView(textView);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
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