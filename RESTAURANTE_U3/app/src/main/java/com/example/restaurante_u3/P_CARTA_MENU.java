package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import com.android.volley.*;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.util.Log;
import android.widget.TextView;

public class P_CARTA_MENU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcarta_menu);



        ComidaMenu();


    }

    private void ComidaMenu(){
        SpinnerBebida();
        // Obtén la hora actual
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // Hora en formato 24 horas
        int minute = calendar.get(Calendar.MINUTE);
        // Formatea la hora y los minutos como una cadena
        String currentTime = String.format("%02d:%02d", hour, minute);
        currentTime = currentTime.replace(":", ""); // Elimina los dos puntos
        //int timeAsInt = Integer.parseInt(currentTime); // Convierte la cadena a entero

        int timeAsInt = Integer.parseInt(currentTime); // Convierte la cadena a entero
        // Asigna la hora formateada al TextView
        TextView textView = findViewById(R.id.textView);
        textView.setText(currentTime);
        //Desayuno
        if(timeAsInt >= 800 && timeAsInt <= 1200){
        }
        //Comida
        if(timeAsInt >= 1201 && timeAsInt <= 1800 ){

        }
        //Cena
        if(timeAsInt >= 1801 && timeAsInt <= 2300){

            TBDesayuno();
            TBCena();
            TBComida();
        }


    }

    private void SpinnerBebida() {
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
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(P_CARTA_MENU.this,
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

    //Comida
    private void SpinnerComida() {
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

                            Spinner spinner = findViewById(R.id.Comida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(P_CARTA_MENU.this,
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




    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=801
    private void TBDesayuno() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=801"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = " | " + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion");
                                spinnerItems.add(itemText);
                            }

                            Spinner spinner = findViewById(R.id.Comida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(P_CARTA_MENU.this,
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

    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1200
    private void TBComida() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1201"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = " | " + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion");
                                spinnerItems.add(itemText);
                            }

                            Spinner spinner = findViewById(R.id.Comida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(P_CARTA_MENU.this,
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



    //https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1801
    private void TBCena() {
        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?time=1801"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = " | " + jsonObject.getString("IdComida") +
                                        " | " + jsonObject.getString("NombreComida") +
                                        " | " + jsonObject.getString("Descripcion");
                                spinnerItems.add(itemText);
                            }

                            Spinner spinner = findViewById(R.id.Comida);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(P_CARTA_MENU.this,
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