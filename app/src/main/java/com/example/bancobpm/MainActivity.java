package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contrasena;
    private ProgressBar pb;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById(R.id.edUsuario);
        contrasena = (EditText)findViewById(R.id.edContraseña);
        pb = (ProgressBar)findViewById(R.id.prb);
        ingresar = (Button) findViewById(R.id.btn);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario.getText().toString().equalsIgnoreCase("android") && contrasena.getText().toString().equalsIgnoreCase("123"))
                {

                    Toast.makeText(getBaseContext(), "Bienvenido a nuestro Banco", Toast.LENGTH_LONG).show();
                    new Task().execute();

                }

                else
                {
                    Toast.makeText(getBaseContext(), "Usuario o contraseña incorrectos.", Toast.LENGTH_LONG).show();
                }
            }
        });

        pb.setVisibility(View.INVISIBLE);

    }
    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            pb.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

            pb.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);

        }

    }

}