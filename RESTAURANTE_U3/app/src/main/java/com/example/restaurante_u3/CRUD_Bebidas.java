package com.example.restaurante_u3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;
import java.util.*;

public class CRUD_Bebidas extends AppCompatActivity {

    EditText etPrecioBebida,etNombreBebidas, etIdBebida;
    Button Insert,Delete,Update,SelectID;
    Button Layout_Select,Layout_Menu;
    Button Limpiar;

    TextView twidbebida,twnombrebebida,twpreciobebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_bebidas);

        twidbebida = findViewById(R.id.twidbebida);
        twnombrebebida = findViewById(R.id.twnombrebebida);
        twpreciobebida = findViewById(R.id.twpreciobebida);

        etPrecioBebida = findViewById(R.id.etPrecioBebida);
        etNombreBebidas = findViewById(R.id.etNombreBebidas);
        etIdBebida = findViewById(R.id.etIdBebida);

        Layout_Menu = findViewById(R.id.Layout_Menu);
        Layout_Select = findViewById(R.id.Layout_Select);

        Limpiar = findViewById(R.id.Limpiar);

        Insert = findViewById(R.id.Insert);
        Delete = findViewById(R.id.Delete);
        Update = findViewById(R.id.Update);
        SelectID = findViewById(R.id.SelectID);



        //Limpiar
        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etIdBebida.setText("");
                etPrecioBebida.setText("");
                etNombreBebidas.setText("");
                twidbebida.setText(" -----");
                twnombrebebida.setText(" -----");
                twpreciobebida.setText(" -----");
            }
        });

        //Insert
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etPrecioBebida.getText().toString().equals("") && !etNombreBebidas.getText().toString().equals("")) {
                    _Insert(etPrecioBebida.getText().toString(), etNombreBebidas.getText().toString());
                } else {
                    Toast.makeText(CRUD_Bebidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }

            }
        });

        //Delete
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etIdBebida.getText().toString().equals("")) {
                    _Delete(etIdBebida.getText().toString());
                } else {
                    Toast.makeText(CRUD_Bebidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        //SelectID
        SelectID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etIdBebida.getText().toString().equals("")) {
                    _SelectId(etIdBebida.getText().toString());
                } else {
                    Toast.makeText(CRUD_Bebidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Update
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etIdBebida.getText().toString().equals("") && !etPrecioBebida.getText().toString().equals("") && !etNombreBebidas.getText().toString().equals("")) {
                    _Update(etIdBebida.getText().toString(),etPrecioBebida.getText().toString(), etNombreBebidas.getText().toString());
                } else {
                    Toast.makeText(CRUD_Bebidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Navigate
        Layout_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CRUD_Bebidas.this, SELECT_BEBIDAS.class);
                startActivity(intent);

            }
        });

        Layout_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CRUD_Bebidas.this, L_Admin.class);
                startActivity(intent);

            }
        });


    }

    //Insert
    private void _Insert(final String _etPrecioBebida, final String _etNombreBebidas) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp";

        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CRUD_Bebidas.this, "RESULTADO POST = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("Precio", _etPrecioBebida);
                params.put("NombreBebida", _etNombreBebidas);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }
    // Delete
    private void _Delete(final String _etIdBebida) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp?id="+_etIdBebida;

        StringRequest postResquest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(CRUD_Bebidas.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    //Select id
    private void _SelectId(final String _etIdBebida) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp?id="+_etIdBebida;

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //twidbebida,twnombrebebida,twpreciobebida
                    JSONObject jsonObject = new JSONObject(response);

                    // TextView
                    twidbebida.setText(jsonObject.getString("IdBebida"));
                    String title = jsonObject.getString("NombreBebida");
                    twnombrebebida.setText(title);
                    twpreciobebida.setText(jsonObject.getString("Precio"));

                    //EditText
                    etPrecioBebida.setText(jsonObject.getString("Precio"));
                    etNombreBebidas.setText(title);
                    etIdBebida.setText(jsonObject.getString("IdBebida"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    //Update
    private void _Update(final String _etIdBebida,final String _etPrecioBebida, final String _etNombreBebidas) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp";

        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CRUD_Bebidas.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("IdBebida", _etIdBebida);
                params.put("NombreBebida", _etNombreBebidas);
                params.put("Precio", _etPrecioBebida);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }

}