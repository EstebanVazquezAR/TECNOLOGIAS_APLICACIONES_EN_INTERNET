package com.example.cafeteria;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);

        new ConnectToDBTask(statusTextView).execute();
    }
    private static class ConnectToDBTask extends AsyncTask<Void, Void, String> {
        private WeakReference<TextView> textViewWeakReference;

        ConnectToDBTask(TextView statusTextView) {
            textViewWeakReference = new WeakReference<>(statusTextView);
        }

        @Override
        protected String doInBackground(Void... params) {
            String connectionResult = "No se pudo conectar";

            try {
                // Configura la cadena de conexión a tu servidor SQL Server
                String url = "jdbc:jtds:sqlserver://angelescuela.database.windows.net/angelescuela";
                String username = "angelsa1";
                String password = "oxOWrOk3yPYjDmL5";

                // Intenta establecer la conexión
                Connection connection = DriverManager.getConnection(url, username, password);
                if (connection != null) {
                    connectionResult = "Conexión exitosa";
                    connection.close();
                }
            } catch (SQLException e) {
                connectionResult = "Error: " + e.getMessage();
            }

            return connectionResult;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            TextView textView = textViewWeakReference.get();
            if (textView != null) {
                textView.setText(result);
            }
        }

    }
}
