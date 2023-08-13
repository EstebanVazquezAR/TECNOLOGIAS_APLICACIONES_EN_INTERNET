package com.example.testmanejovae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button go_to_second_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button goToSecondActivityButton = findViewById(R.id.go_to_second_activity_button);
        goToSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a la SecondActivity cuando se hace clic en el botón
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        // Obtén la hora actual
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // Hora en formato 24 horas
        int minute = calendar.get(Calendar.MINUTE);

        // Formatea la hora y los minutos como una cadena
        String currentTime = String.format("%02d:%02d", hour, minute);

        // Asigna la hora formateada al TextView
        TextView textView = findViewById(R.id.textView);
        textView.setText(currentTime);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Eliminar completamente el archivo de SharedPreferences al cerrar la aplicación
        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }


    public void guardarValor(View view) {
        String valor = editText.getText().toString();
        // Obtén una instancia de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", MODE_PRIVATE);
        // Crea un editor para modificar los valores
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Guarda el valor ingresado en SharedPreferences
        editor.putString("miValor", valor);
        // Aplica los cambios
        editor.apply();
    }

}
