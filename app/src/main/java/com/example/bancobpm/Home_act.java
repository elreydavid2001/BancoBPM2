package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper slide;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        slide = (ViewFlipper) findViewById(R.id.slider);


        for (int i = 0; i < images.length; i++) {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        slide.addView(view);
        slide.setAutoStart(true);
        slide.setFlipInterval(3000);

        slide.setInAnimation(this, android.R.anim.slide_in_left);
        slide.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void GestionarClientes(View v) {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }
    public void Prestamos(View v) {

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos= new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");
        clientes.add("Betzabe");
        clientes.add("Matias");

        creditos.add("Hipotecario");
        creditos.add("Automotriz");


        Intent i = new Intent(this, Prestamos_act.class);
        i.putExtra("listaClientes", clientes);
        i.putExtra("listaCreditos", creditos);
        startActivity(i);
    }
    public void Seguridad(View v) {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }
    public void Informacion(View v) {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}