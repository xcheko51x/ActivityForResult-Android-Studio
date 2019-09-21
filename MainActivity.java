package com.xcheko51x.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTexto;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTexto = findViewById(R.id.tvTexto);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ABRIMOS LA SEGUNDA ACTIVIDAD PERO CON UN CODIGO PARA SABER QUE ESPERAMOS RESPUESTA
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100) {
            if(resultCode == Activity.RESULT_OK) {
                String textoRecibido = data.getStringExtra("resultado");

                tvTexto.setText(textoRecibido);
            }
        }
    }
}
