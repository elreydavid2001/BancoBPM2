package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private TextView text;
    private EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        text = (TextView) findViewById(R.id.txt);
        edit = (EditText) findViewById(R.id.edContra);
    }

    private SecretKeySpec generateKey(String password) throws Exception {

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    public String Encriptar(String datos, String password) throws Exception {
        if (!edit.getText().toString().isEmpty()) {
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        } else {
            Toast.makeText(this, "Debe Ingresar Contraseña", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void Encriptar (View v)
    {
        try
        {
            String mensaje = Encriptar(edit.getText().toString(), text.getText().toString());
            text.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}