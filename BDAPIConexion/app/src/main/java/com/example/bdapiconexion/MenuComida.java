package com.example.bdapiconexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;
import java.util.*;
import android.widget.ArrayAdapter;


public class MenuComida extends AppCompatActivity {


    private Spinner Comida; // Declaración del Spinner
    private Spinner bebida; // Declaración del Spinner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_comida);

        Comida = findViewById(R.id.Comida); // Asignación del ID del Spinner
        bebida = findViewById(R.id.bebida); // Asignación del ID del Spinner



        ListaComida();
        ListaBebida();

    }







    //Carga de Listas / menu

    private void ListaComida() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = "IdComida: " + jsonObject.getString("IdComida") +
                                        "\nNombreComida: " + jsonObject.getString("NombreComida") +
                                        "\nDescripcion: " + jsonObject.getString("Descripcion");
                                spinnerItems.add(itemText);
                            }

                            Spinner spinner = findViewById(R.id.Comida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(MenuComida.this,
                                    android.R.layout.simple_spinner_item, spinnerItems);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(adapter);
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
    private void ListaBebida() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = "IdBebida: " + jsonObject.getString("IdBebida") +
                                        "\nNombreBebida: " + jsonObject.getString("NombreBebida") +
                                        "\nPrecio: " + jsonObject.getString("Precio");
                                spinnerItems.add(itemText);
                            }

                            Spinner spinner = findViewById(R.id.bebida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(MenuComida.this,
                                    android.R.layout.simple_spinner_item, spinnerItems);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(adapter);
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