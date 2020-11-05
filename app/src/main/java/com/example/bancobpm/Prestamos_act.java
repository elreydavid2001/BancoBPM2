package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Calculos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spnClientes, spnTipoCredito;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spnClientes = (Spinner)findViewById(R.id.spn1);
        spnTipoCredito = (Spinner)findViewById(R.id.spn2);
        text = (TextView)findViewById(R.id.txt);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spnClientes.setAdapter(adapt);
        spnTipoCredito.setAdapter(adapt2);

    }

    public void CalcularPrestamo(View v)
    {
        String varCliente = spnClientes.getSelectedItem().toString();
        String varCredito = spnTipoCredito.getSelectedItem().toString();
        int nCliente;
        int nCredito;
        ArrayList<String> prestamoParaDeuda = new ArrayList<String>();

        if(varCliente.equals("Axel"))
        {
            if(varCredito.equals("Hipotecario"))
            {
                nCliente = 750000;
                nCredito = 1000000;
                Calculos calculo = new Calculos(nCliente, nCredito);
                calculo.CalcularPrestamos();
                text.setText("Su sueldo final es: "+calculo.CalcularPrestamos());
                prestamoParaDeuda.add(calculo.CalcularPrestamos());
            }
            else
            {
                nCliente = 750000;
                nCredito = 500000;
                Calculos calculo = new Calculos(nCliente, nCredito);
                calculo.CalcularPrestamos();
                text.setText("Su sueldo final es: "+calculo.CalcularPrestamos());
                prestamoParaDeuda.add(calculo.CalcularPrestamos());
            }
        }
        else {
            if (varCredito.equals("Hipotecario"))
            {
                nCliente = 900000;
                nCredito = 1000000;
                Calculos calculo = new Calculos(nCliente, nCredito);
                calculo.CalcularPrestamos();
                text.setText("Su sueldo final es: " + calculo.CalcularPrestamos());
                prestamoParaDeuda.add(calculo.CalcularPrestamos());
            }
            else
            {
                nCliente = 900000;
                nCredito = 500000;
                Calculos calculo = new Calculos(nCliente, nCredito);
                calculo.CalcularPrestamos();
                text.setText("Su sueldo final es: " + calculo.CalcularPrestamos());
                prestamoParaDeuda.add(calculo.CalcularPrestamos());
            }
        }



    }

    public void CalcularDeudas(View v)
    {
        int nCredito;

        String varCliente = spnClientes.getSelectedItem().toString();
        String varCredito = spnTipoCredito.getSelectedItem().toString();
        int val =Integer.parseInt((text.getText().toString()).replaceAll("[^0-9.]", ""));

        if (varCliente.equals("Axel"))
        {
            if (varCredito.equals("Hipotecario"))
            {
                nCredito = 1000000;
                Calculos calculo = new Calculos(0,nCredito);
                calculo.setPrestamoTotal(val);

                text.setText("Axel deberá pagar 12 cuotas de: "+ calculo.CalcularDeudas()+"$"+"(Se ha agregado 1 peso para redondear las cuotas)" );
            }
            else
            {
                nCredito = 500000;
                Calculos calculo = new Calculos(0,nCredito);
                calculo.setPrestamoTotal(val);
                text.setText("Axel deberá pagar 8 cuotas de: "+ calculo.CalcularDeudas()+"$"+"(Se ha agregado 1 peso para redondear las cuotas)" );
            }

        }
        else
        {
            if (varCredito.equals("Hipotecario"))
            {
                nCredito = 1000000;
                Calculos calculo = new Calculos(0, nCredito);
                calculo.setPrestamoTotal(val);
                text.setText("Roxana deberá pagar 12 cuotas de: "+ calculo.CalcularDeudas()+"$"+"(Se ha agregado 1 peso para redondear las cuotas)" );
            }
            else
            {
                nCredito = 500000;
                Calculos calculo = new Calculos(0,nCredito);
                calculo.setPrestamoTotal(val);
                text.setText("Roxana deberá pagar 8 cuotas de: "+ calculo.CalcularDeudas()+"$"+"(Se ha agregado 1 peso para redondear las cuotas)" );
            }
        }
    }
}