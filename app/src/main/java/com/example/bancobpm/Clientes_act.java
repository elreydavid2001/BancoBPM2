package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText codigo, nombre,salario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        codigo = (EditText) findViewById(R.id.txt1);
        nombre = (EditText) findViewById(R.id.txt2);
        salario = (EditText) findViewById(R.id.txt3);
    }
    public void GuardarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fachero", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!codigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo.getText().toString());
            registro.put("nombre", nombre.getText().toString());
            registro.put("salario", salario.getText().toString());

            BaseDeDatos.insert("clientes",null, registro);
            BaseDeDatos.close();

            Toast.makeText(this,"Se ha agregado el insumo correctamente", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Debe rellenar los campos", Toast.LENGTH_LONG).show();
        }
    }
    public void MostrarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fachero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = codigo.getText().toString();

        if(!codigoreal.isEmpty())
        {
            Cursor fila = BD.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo="+codigoreal, null);

            if(fila.moveToFirst())
            {
                nombre.setText(fila.getString(0));
                salario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No hay datos en los campos de la tabla clientes.", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "No existe cliente con el codigo asociado", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fachero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = codigo.getText().toString();

        BD.delete("clientes", "codigo ="+codigoreal, null);
        BD.close();
        Toast.makeText(this, "Has eliminado un cliente", Toast.LENGTH_LONG).show();
    }
    public void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fachero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = codigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", codigo.getText().toString());
        cont.put("nombre", nombre.getText().toString());
        cont.put("salario", salario.getText().toString());


        if(!codigoreal.isEmpty())
        {
            BD.update("clientes", cont, "codigo ="+codigoreal, null);
            BD.close();
            Toast.makeText(this, "Has actualizado un campo", Toast.LENGTH_LONG).show();
        }
    }
}