package com.htcdiurno.nombreedad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by juanrajc on 04/10/2017.
 */

public class FormMensaje extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        TextView txtMensaje =(TextView)findViewById(R.id.textView3);
        Bundle bundle = getIntent().getExtras();
        txtMensaje.setText( "Te llamas "+ bundle.getString("NOMBRE")+
                " y tienes "+ bundle.getString("EDAD")+" años");
        Intent intent = new Intent();
        intent.putExtra("RESULTADO", "He acertado");
        setResult(RESULT_OK, intent);
    }
}