package com.htcdiurno.nombreedad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int CODIGO = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btAct = (Button)findViewById(R.id.button);
        btAct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormMensaje();
            }
        });
    }

    public void abrirFormMensaje(){
        EditText etNombre = (EditText)findViewById(R.id.editText);
        EditText etEdad = (EditText)findViewById(R.id.editText2);
        String nombre = etNombre.getText().toString();
        String edad = etEdad.getText().toString();
        Intent intent= new Intent (this, FormMensaje.class);
        Bundle bundle = new Bundle();
        bundle.putString( "NOMBRE", nombre);
        bundle.putString( "EDAD", edad);
        intent.putExtras(bundle);
        startActivityForResult(intent, CODIGO);
    }
    protected void onActivityResult( int requestCode, int resultCode,
                                     Intent data) {
        if (requestCode == CODIGO && resultCode == RESULT_OK) {
            String res = data.getExtras().getString( "RESULTADO");
            Toast.makeText(getApplicationContext(), "Recibido: " +
                    res,Toast.LENGTH_LONG).show();
        }
    }
}