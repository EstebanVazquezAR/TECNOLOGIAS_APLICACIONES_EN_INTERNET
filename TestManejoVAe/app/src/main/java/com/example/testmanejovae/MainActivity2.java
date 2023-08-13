package com.example.testmanejovae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private Button go_to_second_activity_button;
    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtener el valor de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", MODE_PRIVATE);
        String valorRecuperado = sharedPreferences.getString("miValor", "");

        // Mostrar el valor en algún elemento de UI (por ejemplo, TextView)
        TextView textView = findViewById(R.id.TextView);
        textView.setText(valorRecuperado);


        Button goToSecondActivityButton = findViewById(R.id.go_to_second_activity_button);
        goToSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a la SecondActivity cuando se hace clic en el botón
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}