package com.uniminuto.appsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ConfirmacionDatos extends AppCompatActivity {
    private TextView txtConfirNombre;
    private TextView txtConfiFecha;
    private TextView txtCinfiTelefono;
    private TextView txtConfiEmail;
    private TextView txtConfiDescp;
    private FloatingActionButton floatinBtnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);
        Bundle parametros =getIntent().getExtras();
        String nombre= parametros.getString(getResources().getString(R.string.pEnvioNombre));
        String fecha = parametros.getString(getResources().getString(R.string.pEnvioFecha));
        String telefono = parametros.getString(getResources().getString(R.string.pEnvioTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEnvioEmail));
        String descripcion = parametros.getString(getResources().getString(R.string.pEnvioDescp));

        //Instanciamiento de TextView para la muestra de datos
            txtConfirNombre =(TextView) findViewById(R.id.txtConfirNombre);
            txtConfiFecha = (TextView) findViewById(R.id.txtConfiFecha);
            txtCinfiTelefono = (TextView) findViewById(R.id.txtCinfiTelefono);
            txtConfiEmail = (TextView) findViewById(R.id.txtConfiEmail);
            txtConfiDescp = (TextView) findViewById(R.id.txtConfiDescp);

        //Set de data a cada TextView para la muestra del contacto
            txtConfirNombre.setText(nombre);
            txtConfiFecha.setText(fecha);
            txtCinfiTelefono.setText(telefono);
            txtConfiEmail.setText(email);
            txtConfiDescp.setText(descripcion);

        //Boton para editar
        floatinBtnEditar = (FloatingActionButton) findViewById(R.id.floatinBtnEditar);
        floatinBtnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmacionDatos.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}