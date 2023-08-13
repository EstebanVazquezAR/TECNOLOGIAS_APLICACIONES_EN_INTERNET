package com.example.bdapiconexion;

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
import android.widget.ArrayAdapter;

public class CRUD_Comidas extends AppCompatActivity {


    Button Insert,Delete,Update,SelectID;
    Button Layout_Select,Layout_Menu;
    Button Limpiar;
    EditText etPrecioComida, etNombreComida,etIDComida;

    TextView twidcomida,twnombrecomida,twpreciocomida,twstatuscomida;
    private Spinner Categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_comidas);

        twidcomida = findViewById(R.id.twidcomida);
        twnombrecomida = findViewById(R.id.twnombrecomida);
        twpreciocomida = findViewById(R.id.twpreciocomida);
        twstatuscomida = findViewById(R.id.twstatuscomida);



        etPrecioComida = findViewById(R.id.etPrecioComida);
        etNombreComida = findViewById(R.id.etNombreComida);
        etIDComida = findViewById(R.id.etIDComida);

        Layout_Menu = findViewById(R.id.Layout_Menu);
        Layout_Select = findViewById(R.id.Layout_Select);

        Limpiar = findViewById(R.id.Limpiar);

        Insert = findViewById(R.id.Insert);
        Delete = findViewById(R.id.Delete);
        Update = findViewById(R.id.Update);
        SelectID = findViewById(R.id.SelectID);

        Categoria = findViewById(R.id.Categoria);

        Insert = findViewById(R.id.Insert);
        Delete = findViewById(R.id.Delete);
        Update = findViewById(R.id.Update);
        SelectID = findViewById(R.id.SelectID);


        ListaCategorias();
        //Limpiar
        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etIDComida.setText("");
                etNombreComida.setText("");
                etPrecioComida.setText("");
//                twidbebida.setText(" -----");
//                twnombrebebida.setText(" -----");
//                twpreciobebida.setText(" -----");
            }
        });

        //Insert
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoriaSeleccionada = Categoria.getSelectedItem().toString();
                String[] partes = categoriaSeleccionada.split("\\|");

                if (!etNombreComida.getText().toString().isEmpty() && !etPrecioComida.getText().toString().isEmpty() && !partes[0].isEmpty()) {
                    _Insert(etNombreComida.getText().toString(), partes[0], etPrecioComida.getText().toString());
                } else {
                    Toast.makeText(CRUD_Comidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });



        //Delete
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etIDComida.getText().toString().equals("")) {
                    _Delete(etIDComida.getText().toString());
                } else {
                    Toast.makeText(CRUD_Comidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        //SelectID
        SelectID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etIDComida.getText().toString().equals("")) {
                    _SelectId(etIDComida.getText().toString());
                } else {
                    Toast.makeText(CRUD_Comidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Update
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String categoriaSeleccionada = Categoria.getSelectedItem().toString();
                String[] partes = categoriaSeleccionada.split("\\|");

                if (!etIDComida.getText().toString().equals("") && !etNombreComida.getText().toString().isEmpty() && !etPrecioComida.getText().toString().isEmpty() && !partes[0].isEmpty()) {
                    _Update(etIDComida.getText().toString(),etNombreComida.getText().toString(),etPrecioComida.getText().toString(),partes[0]);
                } else {
                    Toast.makeText(CRUD_Comidas.this, "VALORES VACIOS", Toast.LENGTH_LONG).show();
                }
            }
        });






        //Navigate
        Layout_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CRUD_Comidas.this, SELECT_COMIDA.class);
                startActivity(intent);
            }
        });
        Layout_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CRUD_Comidas.this, Admin.class);
                startActivity(intent);
            }
        });

    }



    //Insert
    private void _Insert(final String _etNombreComida,final String _Status,final String _etPrecioComida){

        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp";

        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CRUD_Comidas.this, "RESULTADO POST = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("NombreComida", _etNombreComida);
                params.put("Descripcion", _etPrecioComida);
                params.put("Status", _Status);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }












    // Delete
    private void _Delete(final String _etIDComida) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?id="+_etIDComida;

        StringRequest postResquest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(CRUD_Comidas.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
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
    private void _SelectId(final String _etIDComida) {

        String url = "https://apprestauranteupt.azurewebsites.net/api/ComidasApp?id="+_etIDComida;

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // etPrecioComida, etNombreComida,etIDComida;
                    JSONObject jsonObject = new JSONObject(response);

                    // EditText
                    etIDComida.setText(jsonObject.getString("IdComida"));
                    String title = jsonObject.getString("NombreComida");
                    etNombreComida.setText(title);
                    etPrecioComida.setText(jsonObject.getString("Descripcion"));

                    String Status = jsonObject.getString("status");

                    if(Status == "1"){

                    } else if (Status=="2") {

                    } else if (Status == "3") {


                    }

                    // TextView twidcomida,twnombrecomida,twpreciocomida,twstatuscomida;
                    twidcomida.setText(jsonObject.getString("IdComida"));
                    twnombrecomida.setText(title);
                    twpreciocomida.setText(jsonObject.getString("Descripcion"));
                    twstatuscomida.setText(jsonObject.getString("status"));

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
    private void _Update(final String _etIDComida,final String _etNombreComida,final String _etPrecioComida,final String _Status){

        String url = "https://apprestauranteupt.azurewebsites.net/api/BebidasApp";

        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CRUD_Comidas.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("IdComida", _etIDComida);
                params.put("NombreComida", _etNombreComida);
                params.put("Descripcion", _etPrecioComida);
                params.put("Status", _Status);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }







    private void ListaCategorias(){
        // Datos para llenar el Spinner
        String[] bebidas = {"Categoria...", "1|Desayuno", "2|Comida", "3|Cena"};
        // Crea un ArrayAdapter utilizando el array de bebidas y el diseño predeterminado para los elementos
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bebidas);
        // Especifica el diseño a usar cuando el Spinner está desplegado
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Asigna el adaptador al Spinner
        Categoria.setAdapter(adapter);
    }



}