package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class P_CARTA_MENU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcarta_menu);
    }


    private void tbtest() {
        String url = "https://jsonplaceholder.typicode.com/posts"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> spinnerItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String itemText = "User ID: " + jsonObject.getString("id") +
                                        "\nTitle: " + jsonObject.getString("title") +
                                        "\nBody: " + jsonObject.getString("body");
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

}