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

public class SELECT_COMIDA extends AppCompatActivity {

    Button Layout_CRUD;
    LinearLayout Consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_comida);

        Layout_CRUD = findViewById(R.id.Layout_CRUD);
        Consulta = findViewById(R.id.Consulta);

        TBDesayuno();
        TBComida();
        TBCena();
        //Navigate
        Layout_CRUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SELECT_COMIDA.this, CRUD_Comidas.class);
                startActivity(intent);

            }
        });
    }

    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=801
    private void TBDesayuno() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=801"; // URL que devuelve un arreglo de objetos JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            // Create a TextView for the header
                            TextView headerTextView = new TextView(SELECT_COMIDA.this);
                            headerTextView.setText("++ DESAYUNO ++");
                            // Customize headerTextView appearance if needed
                            Consulta.addView(headerTextView);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(SELECT_COMIDA.this);
                                textView.setText("" + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion"));

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

    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1200
    private void TBComida() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1201"; // URL que devuelve un arreglo de objetos JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            // Create a TextView for the header
                            TextView headerTextView = new TextView(SELECT_COMIDA.this);
                            headerTextView.setText("++ COMIDA ++");
                            // Customize headerTextView appearance if needed
                            Consulta.addView(headerTextView);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(SELECT_COMIDA.this);
                                textView.setText("" + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion"));

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



    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1801
    private void TBCena() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1801"; // URL que devuelve un arreglo de objetos JSON
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            // Create a TextView for the header
                            TextView headerTextView = new TextView(SELECT_COMIDA.this);
                            headerTextView.setText("++ CENA ++ ");
                            // Customize headerTextView appearance if needed
                            Consulta.addView(headerTextView);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(SELECT_COMIDA.this);
                                textView.setText("" + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion"));

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