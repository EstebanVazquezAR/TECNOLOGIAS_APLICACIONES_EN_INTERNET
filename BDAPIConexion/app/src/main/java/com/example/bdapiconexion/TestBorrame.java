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


public class TestBorrame extends AppCompatActivity {
    EditText txtUser, txtTitle, txtBody;
    Button btnEnviar;
    private Spinner spinner; // Declaración del Spinner
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_borrame);

        txtUser = findViewById(R.id.txtUser);
        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);
        btnEnviar = findViewById(R.id.btnEnviar);
        spinner = findViewById(R.id.spinner); // Asignación del ID del Spinner


        linearLayout = findViewById(R.id.linearLayout);
        tbtest2();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerWs();
            }
        });
    }
    private void tbtest2() {
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

                            Spinner spinner = findViewById(R.id.spinner);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(TestBorrame.this,
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


    private void tbtest(){
        String url = "https://jsonplaceholder.typicode.com/posts"; // URL que devuelve un arreglo de objetos JSON

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                TextView textView = new TextView(TestBorrame.this);
                                textView.setText("User ID: " + jsonObject.getString("id") +
                                        "\nTitle: " + jsonObject.getString("title") +
                                        "\nBody: " + jsonObject.getString("body"));

                                linearLayout.addView(textView);
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

    private void LeerWs() {

        String url = "https://jsonplaceholder.typicode.com/posts/11";

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUser.setText(jsonObject.getString("userId"));
                    String title = jsonObject.getString("title");
                    txtTitle.setText(title);
                    txtBody.setText(jsonObject.getString("body"));

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
}