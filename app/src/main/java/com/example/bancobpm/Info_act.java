package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        vv = (VideoView)findViewById(R.id.vvm);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        vv.setVideoURI(uri);

        MediaController media = new MediaController(this);
        vv.setMediaController(media);
    }
    public void Mapa(View v)
    {
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }
}