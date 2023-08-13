package com.example.restaurante_u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class P_MESAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmesas);

        LinearLayout bttns_carga = findViewById(R.id.bttns_carga);

        for (int i = 1; i <= 4; i++) {
            Button button = new Button(this);
            String buttonId = "Mesa_" + i;
            String buttonText = "Mesa " + i;

            button.setId(View.generateViewId());
            button.setText(buttonText);

            // Aplicar atributos de diseño al botón
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1
            );
            button.setLayoutParams(layoutParams);

            bttns_carga.addView(button);

            // Agregar un OnClickListener a cada botón
            final int mesaId = i;  // ID de la mesa para usar en el OnClickListener
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Manejar el clic en el botón
                    String mesaMsg = "Mesa seleccionada: " + mesaId;
                    Log.d("Mesa", mesaMsg);  // Envía un mensaje de registro (Log)
                    Intent intent = new Intent(P_MESAS.this, P_CARTA_MENU.class);
                    startActivity(intent);
                }
            });
        }
    }
}
