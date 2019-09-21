package com.xcheko51x.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText etTexto;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etTexto = findViewById(R.id.etTexto);
        btnAceptar = findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // REGRESAMOS EL TEXTO DEL EDIT TEXT AL ACTIVITY ANTERIOR
                Intent intent = new Intent();
                intent.putExtra("resultado", etTexto.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
